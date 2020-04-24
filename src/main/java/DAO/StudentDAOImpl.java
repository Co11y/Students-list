package DAO;

import Models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {
    private static final String GET_ALL_STUDENTS = "SELECT * FROM students";

    @Override
    public Optional<Student> findStudentById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DataSource.getConnection()) {
            PreparedStatement query = connection
                    .prepareStatement(GET_ALL_STUDENTS);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                students.add(mapStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

        private Student mapStudent(ResultSet rs) throws SQLException {
        return new Student(rs.getLong("id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getLong("rating"), rs.getString("group"));
    }

    @Override
    public Boolean updateStudent(Student student) {
        return null;
    }

    @Override
    public Boolean deleteStudent(long id) {
        return null;
    }


}
