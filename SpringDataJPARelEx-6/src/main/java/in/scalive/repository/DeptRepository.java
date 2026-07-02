package in.scalive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.scalive.model.Department;

public interface DeptRepository extends JpaRepository<Department,Integer>{

}
