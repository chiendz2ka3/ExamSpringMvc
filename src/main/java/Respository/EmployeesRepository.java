package Respository;

import Entities.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity ,Long> {
    public List<EmployeesEntity> getlist();
    public void addnew(EmployeesEntity data);
}
