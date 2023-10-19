package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
        private String employeeName;
        private Double salary;
        private String bankAccount;
        private String nationalInsurance;
        private int teamId;

        @JsonCreator
        public EmployeeRequest(@JsonProperty("employeeName") String employeeName,
                               @JsonProperty("salary") Double salary,
                               @JsonProperty("bankAccount") String bankAccount,
                               @JsonProperty("nationalInsurance") String nationalInsurance,
                               @JsonProperty("team")int team) {
            this.employeeName = employeeName;
            this.salary = salary;
            this.bankAccount = bankAccount;
            this.nationalInsurance = nationalInsurance;
            this.teamId = team;
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
