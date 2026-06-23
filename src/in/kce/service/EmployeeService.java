package in.kce.service;

import java.util.ArrayList;

import in.kce.bean.Employee;
import in.kce.dao.EmployeeDAO;

public class EmployeeService {

    EmployeeDAO empdao = new EmployeeDAO();

    public boolean saveEmployee(int empId, String empName, String desig) {

        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setDesignation(desig);

        return empdao.saveEmployee(emp);
    }

    public boolean updateEmployee(int empId, String empName, String desig) {

        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setDesignation(desig);

        return empdao.updateEmployee(emp);
    }

    public boolean deleteEmployee(String empId) {
        return empdao.deleteEmployee(empId);
    }

    public Employee getEmployee(String empId) {
        return empdao.getEmployee(empId);
    }

    public ArrayList<Employee> getAllEmployees() {
        return empdao.getAllEmployees();
    }
}