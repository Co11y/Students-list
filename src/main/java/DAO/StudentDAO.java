package DAO;

import Models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    Optional<Student> findStudentById(Long id);
    List<Student> findAllStudents();
    Boolean updateStudent (Student student);
    Boolean deleteStudent(long id);
}
