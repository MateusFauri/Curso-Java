package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department insert ===");
		Department dep = new Department(null, "Machines");
		depDao.insert(dep);
		System.out.println("Inserted!");
		
		
		System.out.println("=== TEST 2: update department ===");
		depDao.update(new Department(7,"Cars"));
		System.out.println("Update Complete!");
		
		System.out.println("=== TEST 3: delete department ===");
		depDao.deleteById(9);
		System.out.println("Delete Complete!");
		
		System.out.println("=== TEST 4: find Department by Id ===");
		dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== TEST 5: find All Department ===");
		List<Department> list = depDao.findAll();
		for(Department depart : list) {
			System.out.println(depart);
		}
		
	}

}
