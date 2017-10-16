package com.capgemini.hr.rotation.api;

import com.capgemini.hr.rotation.domain.PersonRequest;
import com.capgemini.hr.rotation.service.PersonRequestExcelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"rest/person-requests"})
@CrossOrigin
public class PersonRequestApiImpl implements PersonRequestApi {
    private final Logger LOGGER = Logger.getLogger(PersonRequestApiImpl.class);
    private final PersonRequestExcelService personRequestExcelService;

    @Autowired
    public PersonRequestApiImpl(PersonRequestExcelService personRequestExcelService) {
        this.personRequestExcelService = personRequestExcelService;
    }

    @RequestMapping(
            path = {"/all"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    public ResponseEntity<List<PersonRequest>> getAllFirmPersonRequests() {
        List filteredPersonRequests = null;

        try {
            String likelihood100Percent = "100% Firm";
            List<PersonRequest> personRequests = this.personRequestExcelService.readDataFromUnformattedExcelFile("resourcing-spreadsheet.xlsx");
            filteredPersonRequests = personRequests.stream().filter((pr) -> pr.getLikelihood().equalsIgnoreCase("100% Firm")).collect(Collectors.toList());
        } catch (FileNotFoundException var4) {
            this.LOGGER.info(var4.getStackTrace());
        }

        return filteredPersonRequests == null ?  new ResponseEntity(HttpStatus.NOT_FOUND) : new ResponseEntity(filteredPersonRequests, HttpStatus.OK);
    }
}
