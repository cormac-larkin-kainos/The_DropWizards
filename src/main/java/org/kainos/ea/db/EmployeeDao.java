package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryEmployeeResponse;
import org.kainos.ea.cli.Employee;
import org.kainos.ea.cli.EmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public int createEmployee(EmployeeRequest employee) throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        String insertQuery ="INSERT INTO Employee (" +
                "employee_name, salary, bank_account_number, " +
                "national_insurance_number, team_id) VALUES (?,?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, employee.getEmployeeName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccount());
        st.setString(4, employee.getNationalInsurance());
        st.setInt(5, employee.getTeamId());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;

    }
    public List<DeliveryEmployeeResponse> selectAllDeliveryEmployees() throws SQLException {

        Connection c = DatabaseConnector.getConnection();

        Statement st = c.createStatement();

        String selectQuery =
                "SELECT employee_name AS `Name`, salary AS `Salary`,bank_account_number AS `Bank Account Number`, \n" +
                "national_insurance_number AS `National Insurance Number`\n" +
                "FROM Team T\n" +
                "LEFT JOIN Employee E on T.team_id = E.team_id\n" +
                "WHERE T.team_id =2";

        ResultSet rs = st.executeQuery(selectQuery);

        List<DeliveryEmployeeResponse> deliveryEmployees = new ArrayList<>();

        while (rs.next()){
            DeliveryEmployeeResponse deliveryEmployeeResponse = new DeliveryEmployeeResponse(
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("Bank Account Number"),
                    rs.getString("National Insurance Number")
            );
            deliveryEmployees.add(deliveryEmployeeResponse);
        }
        return deliveryEmployees;
    }
}
