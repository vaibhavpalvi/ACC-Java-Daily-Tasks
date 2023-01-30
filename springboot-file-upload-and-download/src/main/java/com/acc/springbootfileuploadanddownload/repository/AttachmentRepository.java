package com.acc.springbootfileuploadanddownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.springbootfileuploadanddownload.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}
