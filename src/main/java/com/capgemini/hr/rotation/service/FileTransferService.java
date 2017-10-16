package com.capgemini.hr.rotation.service;

import com.capgemini.hr.rotation.domain.FileUpload;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.stereotype.Service;

@Service
public interface FileTransferService {
    void uploadFile(FileUpload var1) throws InvalidMediaTypeException;
}