package com.capgemini.hr.rotation.api;

import com.capgemini.hr.rotation.domain.PersonRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonRequestApi {
    ResponseEntity<List<PersonRequest>> getAllFirmPersonRequests();
}
