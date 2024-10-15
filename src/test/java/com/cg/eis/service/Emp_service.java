package com.cg.eis.service;
 
import com.cg.eis.bean.Emp;
 
public interface Emp_service {
	void addEmployee(Emp employee);
    Emp getEmployeeById(int id);
    void displayEmployeeDetails(int id);
    String findInsuranceScheme(double salary, String designation);  
    void displayAllEmployees();
	
}