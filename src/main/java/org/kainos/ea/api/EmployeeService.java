package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployeeResponse;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;
import org.kainos.ea.core.EmployeeValidator;
import org.kainos.ea.db.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();
    private EmployeeValidator employeeValidator = new EmployeeValidator();

    public int createEmployee(EmployeeRequest employee) throws InvalidEmployeeException, FailedToCreateEmployeeException {

        try {

            if (!employeeValidator.isValidEmployee(employee)) {
                throw new InvalidEmployeeException();
            }

            int id = employeeDao.createEmployee(employee);

            if (id == -1) {
                throw new FailedToCreateEmployeeException();
            }

            return id;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateEmployeeException();
        }

    }

    public DeliveryEmployeeResponse getDeliveryEmployeeByID (int id) throws FailedToGetEmployeeException, DeliveryEmployeeDoesNotExistException {


        try {
            DeliveryEmployeeResponse employee = employeeDao.getDeliveryEmployeeByID(id);

            if (employee == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            return employee;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetEmployeeException();
        }

    }

    public List<DeliveryEmployeeResponse> selectAllDeliveryEmployees() throws SQLException{

        List<DeliveryEmployeeResponse> deliveryEmployeeResponses = employeeDao.selectAllDeliveryEmployees();

        return deliveryEmployeeResponses;

    }


}
