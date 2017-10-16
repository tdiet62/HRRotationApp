package com.capgemini.hr.rotation.service;

import com.capgemini.hr.rotation.domain.FileUpload;
import com.google.common.io.Files;
import org.apache.log4j.Logger;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Service
public class FileTransferServiceImpl implements FileTransferService {
    private final Logger LOGGER = Logger.getLogger(FileTransferService.class);

    public FileTransferServiceImpl() {
    }

    public void uploadFile(FileUpload fileUpload) throws InvalidMediaTypeException {
        File resourcingSpreadsheet = new File("resourcing-spreadsheet.xlsx");

        try {
            if (!this.matchesAnyExcelMimeType(fileUpload.getMimeType())) {
                throw new InvalidMediaTypeException(fileUpload.getMimeType(), "The file supplied is not of excel file format, please upload the correct spreadsheet");
            }

            Files.write(fileUpload.getFile(), resourcingSpreadsheet);
        } catch (IOException var4) {
            this.LOGGER.info(var4.getStackTrace());
        }

    }

    private boolean matchesAnyExcelMimeType(String mimeType) {
        String[] possibleExcelMimeTypes = new String[]{"application/vnd.ms-excel", "application/msexcel", "application/x-msexcel", "application/x-ms-excel", "application/x-excel", "application/x-dos_ms_excel", "application/xls", "application/x-xls", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet","application/octet-stream"};
        return Arrays.asList(possibleExcelMimeTypes).contains(mimeType.toLowerCase());
    }
}