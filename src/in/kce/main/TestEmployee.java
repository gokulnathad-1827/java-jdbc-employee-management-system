package in.kce.main;

import java.util.ArrayList;
import java.util.Scanner;

import in.kce.bean.Employee;
import in.kce.service.EmployeeService;

public class TestEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        System.out.println("===== Employee Management System =====");
        System.out.println("1. Store Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Fetch One Employee");
        System.out.println("4. Fetch All Employees");
        System.out.println("5. Delete Employee");
        System.out.print("Enter Your Choice: ");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {

        case 1:

            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String empName = sc.nextLine();

            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();

            boolean saveResult = employeeService.saveEmployee(empId, empName, designation);

            if (saveResult) {
                System.out.println("Employee Saved Successfully");
            } else {
                System.out.println("Employee Save Failed");
            }
            break;

        case 2:

            System.out.print("Enter Employee ID to Update: ");
            int updateId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Employee Name: ");
            String updateName = sc.nextLine();

            System.out.print("Enter New Designation: ");
            String updateDesignation = sc.nextLine();

            boolean updateResult = employeeService.updateEmployee(updateId, updateName, updateDesignation);

            if (updateResult) {
                System.out.println("Employee Updated Successfully");
            } else {
                System.out.println("Employee Update Failed");
            }
            break;

        case 3:

            System.out.print("Enter Employee ID: ");
            String searchId = sc.nextLine();

            Employee employee = employeeService.getEmployee(searchId);

            if (employee != null) {
                System.out.println("Employee Details");
                System.out.println("ID          : " + employee.getEmpId());
                System.out.println("Name        : " + employee.getEmpName());
                System.out.println("Designation : " + employee.getDesignation());
            } else {
                System.out.println("Employee Not Found");
            }
            break;

        case 4:

            ArrayList<Employee> employees = employeeService.getAllEmployees();

            if (employees.size() > 0) {

                System.out.println("\nEmployee List");
                System.out.println("--------------------------------");

                for (Employee emp : employees) {

                    System.out.println("ID          : " + emp.getEmpId());
                    System.out.println("Name        : " + emp.getEmpName());
                    System.out.println("Designation : " + emp.getDesignation());
                    System.out.println("--------------------------------");
                }

            } else {
                System.out.println("No Employees Found");
            }

            break;

        case 5:

            System.out.print("Enter Employee ID to Delete: ");
            String deleteId = sc.nextLine();

            boolean deleteResult = employeeService.deleteEmployee(deleteId);

            if (deleteResult) {
                System.out.println("Employee Deleted Successfully");
            } else {
                System.out.println("Employee Delete Failed");
            }

            break;

        default:
            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}