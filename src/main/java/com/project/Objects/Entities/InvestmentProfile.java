package com.project.Objects.Entities;

public class InvestmentProfile {
    private int userId;
    private int riskLevel;
    private int age;
    private int income;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getInvestmentKnowledge() {
        return investmentKnowledge;
    }

    public void setInvestmentKnowledge(String investmentKnowledge) {
        this.investmentKnowledge = investmentKnowledge;
    }

    private String maritalStatus;
    private String investmentKnowledge;

}
