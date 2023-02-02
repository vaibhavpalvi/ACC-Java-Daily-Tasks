package com.acc.uploadprojecttoawss3bucket;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
	
	String saveFile(MultipartFile file) throws IOException;
	
	byte[] downloadFile(String filename);
	
	String deleteFile(String filename);
	
	List<String> listAllFiles();
}
