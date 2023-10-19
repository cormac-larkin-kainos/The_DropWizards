package org.kainos.ea.db;

import org.kainos.ea.cli.EmployeeRequest;

import java.sql.*;

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
}
