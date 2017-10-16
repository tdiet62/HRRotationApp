
package com.capgemini.hr.rotation.api;

import com.capgemini.hr.rotation.domain.FileUpload;
import com.capgemini.hr.rotation.service.FileTransferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Arrays;
import java.util.Iterator;

@RestController
@RequestMapping({"rest/file-transfer"})
@CrossOrigin
public class FileTransferApiImpl implements FileTransferApi {
    private FileTransferService fileTransferService;
    private final Logger LOGGER = Logger.getLogger(FileTransferApiImpl.class);

    @Autowired
    public FileTransferApiImpl(FileTransferService fileTransferService) {
        this.fileTransferService = fileTransferService;
    }

    @RequestMapping(
            value = {"/upload"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<?> uploadResourcingSpreadSheet(MultipartHttpServletRequest request) {
        try {
            Iterator itr = request.getFileNames();

            while(itr.hasNext()) {
                String uploadedFile = (String)itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                String mimeType = file.getContentType();
                String filename = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                FileUpload newFile = new FileUpload(filename, bytes, mimeType);
                this.fileTransferService.uploadFile(newFile);
            }
        } catch (InvalidMediaTypeException var9) {
            this.LOGGER.info(Arrays.toString(var9.getStackTrace()));
            return new ResponseEntity("{}", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        } catch (Exception var10) {
            this.LOGGER.info(Arrays.toString(var10.getStackTrace()));
            return new ResponseEntity("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity("{}", HttpStatus.CREATED);
    }
}
