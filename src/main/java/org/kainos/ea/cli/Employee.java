package org.kainos.ea.cli;

public class Employee {
    private int employeeId;
    private String employeeName;
    private Double salary;
    private String bankAccount;
    private String nationalInsurance;
    private int teamId;

    public Employee(int employeeId, String employeeName, Double salary, String bankAccount, String nationalInsurance, int team) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.nationalInsurance = nationalInsurance;
        this.teamId = team;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getNationalInsurance() {
        return nationalInsurance;
    }

    public void setNationalInsurance(String nationalInsurance) {
        this.nationalInsurance = nationalInsurance;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
