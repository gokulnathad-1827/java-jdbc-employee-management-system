package in.kce.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.kce.bean.Employee;
import in.kce.util.DBUtil;

public class EmployeeDAO {
	//Store Employee
	public boolean saveEmployee(Employee employee) {
		Connection connection=DBUtil.getConnection();
		String query="insert into employee2 values(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getDesignation());
			int row=preparedStatement.executeUpdate();
			if(row>=1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//update Employee
	public boolean updateEmployee(Employee employee) {

	    Connection connection = DBUtil.getConnection();

	    String query =
	        "UPDATE employee2 SET empname=?, designation=? WHERE empid=?";

	    try {

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        preparedStatement.setString(1, employee.getEmpName());
	        preparedStatement.setString(2, employee.getDesignation());
	        preparedStatement.setInt(3, employee.getEmpId());

	        int row = preparedStatement.executeUpdate();

	        return row > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	//delete Employee
	public boolean deleteEmployee(String empId) {
	    Connection connection = DBUtil.getConnection();
	    String query = "DELETE FROM employee2 WHERE empid=?";
		
	    try {
	    	PreparedStatement preparedStatement = connection.prepareStatement(query);
	    	
	    	preparedStatement.setString(1, empId);
	    	
	    	int row = preparedStatement.executeUpdate();
	    	
	    	if(row>0) {
	    	return true;	
	    	}
	    	
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
		return true;
	}
	//fetch one employee
	public Employee getEmployee(String empId) {
	    Connection connection = DBUtil.getConnection();
	    String query = "SELECT * FROM employee2 WHERE empid=?";
	    try {
	    	PreparedStatement preparedStatement = connection.prepareStatement(query);
	    	
	    	preparedStatement.setString(1, empId);
	    	
	    	ResultSet resultSet = preparedStatement.executeQuery();
	    	
	    	if(resultSet.next()) {
	    		Employee employee = new Employee();
	    		
	    		employee.setEmpId(resultSet.getInt("empid"));
	    		employee.setEmpName(resultSet.getString("empname"));
	    		employee.setDesignation(resultSet.getString("designation"));
	    		
	    		return employee;
	    	}
	    }catch(SQLException e){
	    	e.printStackTrace();
	    } 
		return null;
		
	}
	//fetch all employees
	public ArrayList<Employee> getAllEmployees() {

	    Connection connection = DBUtil.getConnection();
	    String query = "SELECT * FROM employee2";

	    ArrayList<Employee> employeeList = new ArrayList<>();

	    try {

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        ResultSet resultSet =
	                preparedStatement.executeQuery();

	        while(resultSet.next()) {

	            Employee employee = new Employee();

	            employee.setEmpId(
	                    resultSet.getInt("EMPID"));

	            employee.setEmpName(
	                    resultSet.getString("EMPNAME"));

	            employee.setDesignation(
	                    resultSet.getString("DESIGNATION"));

	            employeeList.add(employee);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return employeeList;
	}
}
