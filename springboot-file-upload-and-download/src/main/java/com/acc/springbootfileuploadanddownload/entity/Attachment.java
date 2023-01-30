package com.acc.springbootfileuploadanddownload.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Attachment {
	
	@Id
	@GeneratedValue(generator =  "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	private String FileName;
	
	private String FileType;
	
	@Lob
	private byte[] data;

	public Attachment(String fileName, String fileType, byte[] data) {
		super();
		FileName = fileName;
		FileType = fileType;
		this.data = data;
	}
	
	
}
