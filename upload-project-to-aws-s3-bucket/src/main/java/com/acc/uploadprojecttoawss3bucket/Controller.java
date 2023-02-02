package com.acc.uploadprojecttoawss3bucket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controller {

	@Autowired
	private S3ServiceImpl s3ServiceImpl;
	
	@PostMapping("/uploadfile")
	public String uploadFile(@RequestParam("file")MultipartFile file) {
		return s3ServiceImpl.saveFile(file);
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("filename") String filename) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.ALL_VALUE);
		headers.add("Content-Disposition", "attachment; filename ="+filename);
		byte[] bs =  s3ServiceImpl.downloadFile(filename);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bs);
	}
	
	@DeleteMapping("/delete/{filename}")
	public String deleteFile(@PathVariable("filename") String filename) {
		return s3ServiceImpl.deleteFile(filename);
	}
	
	@GetMapping("/getall")
	public List<String> getAllFiles(){
		return s3ServiceImpl.listAllFiles();
	}
	
}
