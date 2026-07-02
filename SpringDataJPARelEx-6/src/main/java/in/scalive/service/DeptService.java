package in.scalive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.model.Department;
import in.scalive.model.Employee;
import in.scalive.repository.DeptRepository;
@Service
public class DeptService {
	
	private DeptRepository repo;
    
	@Autowired
	public DeptService(DeptRepository repo) {
		this.repo = repo;
	}
	
	public Department createDepartment(String dname, List<String>empNames) {
		Department dept=new Department(dname);
		for(String name:empNames) {
			Employee emp= new Employee(name);
			dept.addEmp(emp);
		}
		return repo.save(dept);
	}
	
	public List<Department> getAllDepartment(){
		return repo.findAll();
	}
	
	public Department updateDepartment(Integer deptId,String deptName) {
		Department dept= repo.findById(deptId).orElse(null);
		if(dept==null) {
			return null;
		}
		dept.setName(deptName);
		return repo.save(dept);
	}
	
    public void addEmp(Integer deptId,String empName) {
    	Department dept = repo.findById(deptId).orElse(null);
    	if(dept==null) {
    		return;
    	}
    	Employee emp=new Employee(empName);
    	dept.addEmp(emp);
    	repo.save(dept);
    	System.out.println("Employee added!");
    }
    
    public void removeEmpFromDept(Integer deptId,Integer empId) {
    	Department dept = repo.findById(deptId).orElse(null);
    	if(dept==null) {
    		System.out.println("Dept not found!");
    		return;
    	}
    	List<Employee>empList=dept.getEmpList();
    	for(Employee e : empList) {
    		if(e.getId()==empId) {
    			dept.removeEmp(e);
    			repo.save(dept);
    			System.out.println("Emp removed!");
    			return;
    		}
    	 }
    	System.out.println("EmpId not found!");
    }
    public void deleteDept(Integer deptId) {
    	Department dept = repo.findById(deptId).orElse(null);
    	if(dept==null) {
    		System.out.println("Dept not found!");
    		return;
    	}
    	repo.deleteById(deptId);
    	System.out.println("Dept deleted!");
    }
    
}
