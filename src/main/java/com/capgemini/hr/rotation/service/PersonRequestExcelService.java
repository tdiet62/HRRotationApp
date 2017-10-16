package com.capgemini.hr.rotation.service;

import com.capgemini.hr.rotation.domain.PersonRequest;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public interface PersonRequestExcelService {
    List<PersonRequest> readDataFromUnformattedExcelFile(String var1) throws FileNotFoundException;
}