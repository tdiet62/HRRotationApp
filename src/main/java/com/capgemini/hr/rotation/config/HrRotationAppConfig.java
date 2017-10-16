package com.capgemini.hr.rotation.config;

import com.capgemini.hr.rotation.api.FileTransferApi;
import com.capgemini.hr.rotation.api.FileTransferApiImpl;
import com.capgemini.hr.rotation.api.PersonRequestApi;
import com.capgemini.hr.rotation.api.PersonRequestApiImpl;
import com.capgemini.hr.rotation.service.FileTransferService;
import com.capgemini.hr.rotation.service.FileTransferServiceImpl;
import com.capgemini.hr.rotation.service.PersonRequestExcelService;
import com.capgemini.hr.rotation.service.PersonRequestExcelServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HrRotationAppConfig {
    public HrRotationAppConfig() {
    }

    @Bean
    public PersonRequestExcelService personRequestExcelService() {
        return new PersonRequestExcelServiceImpl();
    }

    @Bean
    public PersonRequestApi personRequestApi() {
        return new PersonRequestApiImpl(this.personRequestExcelService());
    }

    @Bean
    public FileTransferApi fileTransferApi() {
        return new FileTransferApiImpl(this.fileTransferService());
    }

    @Bean
    public FileTransferService fileTransferService() {
        return new FileTransferServiceImpl();
    }
}