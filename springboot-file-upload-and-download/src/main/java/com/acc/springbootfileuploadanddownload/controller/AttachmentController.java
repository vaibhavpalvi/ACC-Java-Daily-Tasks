package com.acc.springbootfileuploadanddownload.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acc.springbootfileuploadanddownload.entity.Attachment;
import com.acc.springbootfileuploadanddownload.model.ResponseData;
import com.acc.springbootfileuploadanddownload.service.AttachmentService;

@RestController
public class AttachmentController {
	
	private AttachmentService attachmentService;

	public AttachmentController(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	
	// save file in the database
	@PostMapping("/upload")
	public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
		Attachment attachment = null;
		attachment = attachmentService.saveAttachment(file);
		String downloadURI = "";
		downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(attachment.getId())
				.toUriString();
		
		return new ResponseData(attachment.getFileName(), downloadURI, file.getContentType(), file.getSize());
	}
	
	//save file locally
	@PostMapping("/local")
	public ResponseData uploadFileLocally(@RequestParam("file")MultipartFile file) throws Exception {
		File path = new File("D:\\Java Programms"+file.getOriginalFilename());
		FileOutputStream outputStream = new FileOutputStream(path);
		outputStream.write(file.getBytes());
		outputStream.close();
		return new ResponseData(file.getOriginalFilename(), file.getName(), file.getContentType(), file.getSize());
	}
	
	//download file 
	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception{
		Attachment attachment = null;
		attachment = attachmentService.getAttachment(fileId);
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +attachment.getFileName()
				+"\"" ).body(new ByteArrayResource(attachment.getData()));
	}
}
