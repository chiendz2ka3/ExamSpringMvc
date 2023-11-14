package Respository;

import Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRespository extends JpaRepository<StudentEntity , Long> {
    public List<StudentEntity> FindStudent(String Name);
}
