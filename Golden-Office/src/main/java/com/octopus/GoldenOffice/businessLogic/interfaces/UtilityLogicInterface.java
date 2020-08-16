package com.octopus.GoldenOffice.businessLogic.interfaces;

public interface UtilityLogicInterface {

    String IdGenerator();

    void updateCustomerCaseList(String custEmail, String caseId);
}
