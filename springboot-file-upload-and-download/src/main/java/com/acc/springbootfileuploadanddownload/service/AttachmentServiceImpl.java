package com.acc.springbootfileuploadanddownload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.acc.springbootfileuploadanddownload.entity.Attachment;
import com.acc.springbootfileuploadanddownload.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService {
	
	private AttachmentRepository attachmentRepository;
	
	

	public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
		this.attachmentRepository = attachmentRepository;
	}



	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
		String fileName = file.getOriginalFilename();
		try {
			if (fileName.contains("..")) {
			throw new Exception("Filename contais invalid chatracters"+fileName);
			
			} 
			Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
			return attachmentRepository.save(attachment);
		} catch (Exception e) {
			throw new Exception("Could not save the file"+fileName);
		}
		
	}



	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		
		return attachmentRepository.findById(fileId)
				.orElseThrow(()-> new Exception("File not found: "+fileId));
	}

}
