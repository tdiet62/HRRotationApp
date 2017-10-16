package com.capgemini.hr.rotation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"resourceManager", "deliveryUnit", "roleId", "skill", "minimumGrade", "maximumGrade", "clientProject", "location", "currentStartDate", "currentEndDate", "typeOfProject", "levelOfClearance","roleDescription"})
public class PersonRequest {
    @JsonProperty("resourceManager")
    @JsonPropertyDescription("The name of the Resource Manager")
    private String resourceManager;
    @JsonProperty("deliveryUnit")
    @JsonPropertyDescription("The name of the Delivery Unit")
    private String deliveryUnit;
    @JsonProperty("roleId")
    @JsonPropertyDescription("The id number for the role")
    private String roleId;
    @JsonProperty("skill")
    @JsonPropertyDescription("The Skill type required for the role")
    private String skill;
    @JsonProperty("minimumGrade")
    @JsonPropertyDescription("The minimum grade required for the role")
    private String minimumGrade;
    @JsonProperty("maximumGrade")
    @JsonPropertyDescription("The maximum grade required for the role")
    private String maximumGrade;
    @JsonIgnore
    private String roleCategory;
    @JsonProperty("clientProject")
    @JsonPropertyDescription("Which client and project the role is for")
    private String clientProject;
    @JsonIgnore
    private String sector;
    @JsonProperty("location")
    @JsonPropertyDescription("Where the role is located")
    private String location;
    @JsonIgnore
    private String originalStartDate;
    @JsonProperty("currentStartDate")
    @JsonPropertyDescription("The current start date for the role")
    private String currentStartDate;
    @JsonProperty("currentEndDate")
    @JsonPropertyDescription("The current end date for the role")
    private String currentEndDate;
    @JsonIgnore
    private String timeBracket;
    @JsonIgnore
    private String likelihood;
    @JsonIgnore
    private String typeOfProject;
    @JsonProperty("levelOfClearance")
    @JsonPropertyDescription("What level of clearance is required for the role")
    private String levelOfClearance;
    @JsonIgnore
    private String own;
    @JsonIgnore
    private String secondee;
    @JsonIgnore
    private String contractor;
    @JsonIgnore
    private String requester;
    @JsonIgnore
    private String additionalNotes;
    @JsonIgnore
    private String resourceNotes;
    @JsonProperty("roleDescription")
    @JsonPropertyDescription("Publicly available notes on the role")
    private String roleDescription;

    public PersonRequest() {
    }

    @JsonProperty("resourceManager")
    public String getResourceManager() {
        return this.resourceManager;
    }

    @JsonProperty("resourceManager")
    public void setResourceManager(String resourceManager) {
        this.resourceManager = resourceManager;
    }

    @JsonProperty("deliveryUnit")
    public String getDeliveryUnit() {
        return this.deliveryUnit;
    }

    @JsonProperty("deliveryUnit")
    public void setDeliveryUnit(String deliveryUnit) {
        this.deliveryUnit = deliveryUnit;
    }

    @JsonProperty("roleId")
    public String getRoleId() {
        return this.roleId;
    }

    @JsonProperty("roleId")
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @JsonProperty("skill")
    public String getSkill() {
        return this.skill;
    }

    @JsonProperty("skill")
    public void setSkill(String skill) {
        this.skill = skill;
    }

    @JsonProperty("minimumGrade")
    public String getMinimumGrade() {
        return this.minimumGrade;
    }

    @JsonProperty("minimumGrade")
    public void setMinimumGrade(String minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    @JsonProperty("maximumGrade")
    public String getMaximumGrade() {
        return this.maximumGrade;
    }

    @JsonProperty("maximumGrade")
    public void setMaximumGrade(String maximumGrade) {
        this.maximumGrade = maximumGrade;
    }

    @JsonIgnore
    public String getRoleCategory() {
        return this.roleCategory;
    }

    @JsonIgnore
    public void setRoleCategory(String roleCategory) {
        this.roleCategory = roleCategory;
    }

    @JsonProperty("clientProject")
    public String getClientProject() {
        return this.clientProject;
    }

    @JsonProperty("clientProject")
    public void setClientProject(String clientProject) {
        this.clientProject = clientProject;
    }

    @JsonIgnore
    public String getSector() {
        return this.sector;
    }

    @JsonIgnore
    public void setSector(String sector) {
        this.sector = sector;
    }

    @JsonProperty("location")
    public String getLocation() {
        return this.location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonIgnore
    public String getOriginalStartDate() {
        return this.originalStartDate;
    }

    @JsonIgnore
    public void setOriginalStartDate(String originalStartDate) {
        this.originalStartDate = originalStartDate;
    }

    @JsonProperty("currentStartDate")
    public String getCurrentStartDate() {
        return this.currentStartDate;
    }

    @JsonProperty("currentStartDate")
    public void setCurrentStartDate(String currentStartDate) {
        this.currentStartDate = currentStartDate;
    }

    @JsonProperty("currentEndDate")
    public String getCurrentEndDate() {
        return this.currentEndDate;
    }

    @JsonProperty("currentEndDate")
    public void setCurrentEndDate(String currentEndDate) {
        this.currentEndDate = currentEndDate;
    }

    @JsonIgnore
    public String getTimeBracket() {
        return this.timeBracket;
    }

    @JsonIgnore
    public void setTimeBracket(String timeBracket) {
        this.timeBracket = timeBracket;
    }

    @JsonIgnore
    public String getLikelihood() {
        return this.likelihood;
    }

    @JsonIgnore
    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }

    @JsonIgnore
    public String getTypeOfProject() {
        return this.typeOfProject;
    }

    @JsonIgnore
    public void setTypeOfProject(String typeOfProject) {
        this.typeOfProject = typeOfProject;
    }

    @JsonProperty("levelOfClearance")
    public String getLevelOfClearance() {
        return this.levelOfClearance;
    }

    @JsonProperty("levelOfClearance")
    public void setLevelOfClearance(String levelOfClearance) {
        this.levelOfClearance = levelOfClearance;
    }

    @JsonIgnore
    public String getOwn() {
        return this.own;
    }

    @JsonIgnore
    public void setOwn(String own) {
        this.own = own;
    }

    @JsonIgnore
    public String getSecondee() {
        return this.secondee;
    }

    @JsonIgnore
    public void setSecondee(String secondee) {
        this.secondee = secondee;
    }

    @JsonIgnore
    public String getContractor() {
        return this.contractor;
    }

    @JsonIgnore
    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    @JsonIgnore
    public String getRequester() {
        return this.requester;
    }

    @JsonIgnore
    public void setRequester(String requester) {
        this.requester = requester;
    }

    @JsonIgnore
    public String getAdditionalNotes() {
        return this.additionalNotes;
    }

    @JsonIgnore
    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @JsonIgnore
    public String getResourceNotes() {
        return this.resourceNotes;
    }

    @JsonIgnore
    public void setResourceNotes(String resourceNotes) {
        this.resourceNotes = resourceNotes;
    }

    @JsonProperty("roleDescription")
    public String getRoleDescription() {
        return this.roleDescription;
    }

    @JsonProperty("roleDescription")
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}