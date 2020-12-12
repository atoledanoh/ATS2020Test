/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

import com.nbcc.gex.models.Employee;
import com.nbcc.gex.models.EmployeesModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AlejandroT
 */
public class SQLEmployee implements ISQLEmployee {

    public EmployeesModel getEmployees() {
        EmployeesModel employees = new EmployeesModel();

        String sql = "{CALL spEmployee_ListAllEmployees()}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);

            ResultSet rs = DataAccess.getResultSet(statement);

            while (rs.next()) {

                // Get record Variables
                int id = rs.getInt("EmployeeID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int SIN = rs.getInt("SIN");
                float payRate = rs.getFloat("PayRate");

                // Create an employee from those variables
                Employee employee = new Employee(firstName, lastName, SIN, payRate);
                employee.setEmployeeID(id);

                // load employee into list
                employees.add(employee);
            }
        } catch (SQLException sqle) {
        }

        return employees;
    }

    public EmployeesModel getEmployeesOnTeam(int teamID) {
        EmployeesModel employees = new EmployeesModel();

        String sql = "{CALL spEmployee_GetEmployeesOnTeam(?)}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);
            statement.setInt(1, teamID);

            ResultSet rs = DataAccess.getResultSet(statement);

            while (rs.next()) {

                // Get record Variables
                int id = rs.getInt("EmployeeID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int SIN = rs.getInt("SIN");
                float payRate = rs.getFloat("PayRate");

                // Create an employee from those variables
                Employee employee = new Employee(firstName, lastName, SIN, payRate);
                employee.setEmployeeID(id);

                // load employee into list
                employees.add(employee);
            }
        } catch (SQLException sqle) {
        }

        return employees;
    }

    public EmployeesModel getUnassignedEmployees() {
        EmployeesModel employees = new EmployeesModel();

        String sql = "{CALL spEmployee_ListUnassignedEmployees()}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);

            ResultSet rs = DataAccess.getResultSet(statement);

            while (rs.next()) {

                // Get record Variables
                int id = rs.getInt("EmployeeID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int SIN = rs.getInt("SIN");
                float payRate = rs.getFloat("PayRate");

                // Create an employee from those variables
                Employee employee = new Employee(firstName, lastName, SIN, payRate);
                employee.setEmployeeID(id);

                // load employee into list
                employees.add(employee);
            }
        } catch (SQLException sqle) {
        }

        return employees;
    }

    public Employee getEmployee(int employeeID) {

        Employee employee = new Employee();

        String sql = "{CALL spEmployee_GetEmployee(?)}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);
            statement.setInt(1, employeeID);

            ResultSet rs = DataAccess.getResultSet(statement);

            if (rs.next()) {

                // Get record Variables
                int id = rs.getInt("EmployeeID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int SIN = rs.getInt("SIN");
                float payRate = rs.getFloat("PayRate");

                // Create an employee from those variables
                employee = new Employee(firstName, lastName, SIN, payRate);
                employee.setEmployeeID(id);

            }
        } catch (SQLException sqle) {
        }

        return employee;
    }

    public int addEmployee(Employee employee) {
        int rowCount = 0;

        String sql = "{CALL spEmployee_AddEmployee(?, ?, ?, ?)}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setInt(3, employee.getSIN());
            statement.setFloat(4, employee.getPayRate());

            rowCount = DataAccess.update(statement);

        } catch (SQLException sqle) {
        }

        return rowCount;
    }

    @Override
    public int deleteEmployee(int employeeID) {
        int rowCount = 0;

        String sql = "{CALL spTask_DeleteEmployee(?)}";

        try (Connection conn = DataAccess.getConnection();) {
            CallableStatement statement = conn.prepareCall(sql);

            statement.setInt(1, employeeID);

            rowCount = DataAccess.update(statement);

        } catch (SQLException sqle) {
        }

        return rowCount;
    }
}
