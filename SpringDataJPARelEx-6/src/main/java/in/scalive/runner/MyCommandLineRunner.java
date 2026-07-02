package in.scalive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.scalive.model.Department;
import in.scalive.service.DeptService;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    @Autowired
	private DeptService ds;
   
	@Override
	public void run(String... args) throws Exception {
		List<String>empNames=List.of("Dheeraj","Neeraj");
			Department dept1=ds.createDepartment("IT", empNames);
			System.out.println("Dept1 created");
			System.out.println("Id:"+dept1.getId());
			System.out.println("Dept name:"+dept1.getName());
			
			empNames=List.of("Riya","Priya");
			Department dept2=ds.createDepartment("Finance", empNames);
			System.out.println("Dept2 created");
			System.out.println("Id:"+dept2.getId());
			System.out.println("Dept name:"+dept2.getName());
			
			empNames=List.of("Shweta","payal");
			Department dept3=ds.createDepartment("BDE", empNames);
			System.out.println("Dept3 created");
			System.out.println("Id:"+dept3.getId());
			System.out.println("Dept name:"+dept3.getName());
			
			empNames=List.of("Shreya","Amit");
			Department dept4=ds.createDepartment("Accountant", empNames);
			System.out.println("Dept4 created");
			System.out.println("Id:"+dept4.getId());
			System.out.println("Dept name:"+dept4.getName());
			
			
			List<Department>deptList=ds.getAllDepartment();
			System.out.println("All Dept Details:");
			for(Department department:deptList) {
				System.out.println(department);
			}
		
		    Department dept=ds.updateDepartment(2,"HR");
			if(dept!=null) {
				System.out.println("New Name:"+dept.getName());
			}else {
				System.out.println("Dept not found");
			}
			
			ds.addEmp(1, "Sumit");
			ds.removeEmpFromDept(1,2);
		    ds.deleteDept(3);
			
	} 

}
