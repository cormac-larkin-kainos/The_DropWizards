package org.kainos.ea.core;

import org.kainos.ea.cli.EmployeeRequest;

public class EmployeeValidator {
    public boolean isValidEmployee(EmployeeRequest employee) {

        if(employee.getEmployeeName().length() >255 || employee.getEmployeeName().length() <1 || employee == null){
            return false;
        }

        if (employee.getSalary() <10000 ){
            return false;
        }

        if (employee.getBankAccount().length() != 8){
            return false;
        }

        if (employee.getNationalInsurance().length() !=9){
            return false;
        }

        if (employee.getTeamId() <1){
            return false;
        }

        return true;
    }
}
