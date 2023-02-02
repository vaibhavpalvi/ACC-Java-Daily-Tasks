package com.acc.uploadprojecttoawss3bucket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.util.IOUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class S3ServiceImpl implements S3Service {

	private final AmazonS3 s3;

	@Value("${bucketName}")
	private String bucketName;

	public S3ServiceImpl(AmazonS3 s3) {
		this.s3 = s3;
	}

	@Override
	public String saveFile(MultipartFile file){

		File file1;
		try {
			file1 = convertMultiPartFileToFile(file);
			s3.putObject(bucketName,file.getOriginalFilename(),file1);
			return "File upload succesfully";
		} catch (IOException e) {
			throw new RuntimeException("File not uploaded please try again");
			
		}
	}

	@Override
	public byte[] downloadFile(String filename) {
		
	       S3Object object=s3.getObject(bucketName,filename);
	       S3ObjectInputStream s3ObjectInputStream=object.getObjectContent();
	       try {
			return IOUtils.toByteArray(s3ObjectInputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public String deleteFile(String filename) {
		s3.deleteObject(bucketName,filename);
		return "File Deleted";
	}

	@Override
	public List<String> listAllFiles() {
		ListObjectsV2Result listObjectsV2Result = s3.listObjectsV2(bucketName);
		
		return listObjectsV2Result.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
	}

	private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fileOutputStream  = new FileOutputStream(convFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		return convFile;
	}

}
