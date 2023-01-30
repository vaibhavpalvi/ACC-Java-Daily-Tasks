package com.acc.springbootfileuploadanddownload.service;

import org.springframework.web.multipart.MultipartFile;

import com.acc.springbootfileuploadanddownload.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getAttachment(String fileId) throws Exception;

	

}
