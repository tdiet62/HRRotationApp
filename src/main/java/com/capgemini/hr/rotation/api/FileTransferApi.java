package com.capgemini.hr.rotation.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileTransferApi {
    ResponseEntity<?> uploadResourcingSpreadSheet(MultipartHttpServletRequest var1);
}
