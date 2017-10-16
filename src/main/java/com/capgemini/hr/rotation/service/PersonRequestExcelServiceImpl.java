package com.capgemini.hr.rotation.service;

import com.capgemini.hr.rotation.domain.PersonRequest;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonRequestExcelServiceImpl implements PersonRequestExcelService {
    private final Logger LOGGER = Logger.getLogger(PersonRequestExcelServiceImpl.class);

    public PersonRequestExcelServiceImpl() {
    }

    public List<PersonRequest> readDataFromUnformattedExcelFile(String fileName) throws FileNotFoundException {
        List<PersonRequest> allPersonRequests = new ArrayList();
        File resourcingSpreadsheet = new File(fileName);

        try {
            FileInputStream excelFile = new FileInputStream(resourcingSpreadsheet);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet dataTypeSheet = workbook.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            boolean rowWhereDataStarts = true;
            Iterator var9 = dataTypeSheet.iterator();

            while(var9.hasNext()) {
                Row currentRow = (Row)var9.next();
                if (currentRow.getRowNum() >= 2) {
                    allPersonRequests.add(this.mapRowToPersonRequestObject(formulaEvaluator, currentRow));
                }
            }

            return allPersonRequests;
        } catch (IOException var11) {
            this.LOGGER.info(Arrays.toString(var11.getStackTrace()));
            throw new FileNotFoundException(Arrays.toString(var11.getStackTrace()));
        }
    }

    private PersonRequest mapRowToPersonRequestObject(FormulaEvaluator formulaEvaluator, Row currentRow) {
        boolean resourceManagerIndex = true;
        boolean deliveryUnitIndex = true;
        boolean roleIdIndex = true;
        boolean skillIndex = true;
        boolean minimumGradeIndex = true;
        boolean maximumGradeIndex = true;
        boolean roleCategoryIndex = true;
        boolean clientProjectIndex = true;
        boolean sectorIndex = true;
        boolean locationIndex = true;
        boolean originalStartDateIndex = true;
        boolean currentStartDateIndex = true;
        boolean currentEndDateIndex = true;
        boolean timeBracketIndex = true;
        boolean likelihoodIndex = true;
        boolean typeOfProjectIndex = true;
        boolean levelOfClearanceIndex = true;
        boolean ownIndex = true;
        boolean secondeeIndex = true;
        boolean contractorIndex = true;
        boolean requesterIndex = true;
        boolean additionalNotesIndex = true;
        boolean resourceNotesIndex = true;
        boolean roleDescriptionIndex = true;
        PersonRequest personRequest = new PersonRequest();
        personRequest.setResourceManager(currentRow.getCell(1).toString());
        personRequest.setDeliveryUnit(currentRow.getCell(2).toString());
        personRequest.setRoleId(currentRow.getCell(3).toString());
        personRequest.setSkill(currentRow.getCell(4).toString());
        personRequest.setMinimumGrade(currentRow.getCell(5).toString());
        personRequest.setMaximumGrade(currentRow.getCell(6).toString());
        personRequest.setRoleCategory(currentRow.getCell(7).toString());
        personRequest.setClientProject(currentRow.getCell(8).toString());
        personRequest.setSector(currentRow.getCell(9).toString());
        personRequest.setLocation(currentRow.getCell(10).toString());
        personRequest.setOriginalStartDate(currentRow.getCell(11).toString());
        personRequest.setCurrentStartDate(currentRow.getCell(12).toString());
        personRequest.setCurrentEndDate(currentRow.getCell(13).toString());
        personRequest.setTimeBracket(currentRow.getCell(14).getRichStringCellValue().toString());
        personRequest.setLikelihood(currentRow.getCell(15).toString());
        personRequest.setTypeOfProject(currentRow.getCell(16).toString());
        personRequest.setLevelOfClearance(currentRow.getCell(17).toString());
        personRequest.setOwn(currentRow.getCell(18).toString());
        personRequest.setSecondee(currentRow.getCell(19).toString());
        personRequest.setContractor(currentRow.getCell(20).toString());
        personRequest.setRequester(currentRow.getCell(21).toString());
        personRequest.setAdditionalNotes(currentRow.getCell(22).toString());
        personRequest.setResourceNotes(currentRow.getCell(23).toString());

        /**
         * During transition to the new app, the column role description may not yet be present in the imported spreadsheet.
         * This code is intended to catch this situation and degrade gracefully without throing any error
         */

        String roleDescription="";
        try{
            roleDescription=currentRow.getCell( 24).toString();
        } catch (NullPointerException ex){
            roleDescription = "Please contact your Resource Manager";
        }
        personRequest.setRoleDescription(roleDescription);
        return personRequest;
    }
}
