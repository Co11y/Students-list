package DAO;

import Models.User;

import java.sql.*;
import java.util.Optional;

public class UserDAO {
    private static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE EMAIL = ? AND PASSWORD = ?";
    private static final String CREATE_USER = "INSERT INTO users (first_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?)";


    private UserDAO() {
    }

    public static Optional findByEmailAndPassword (User user) throws Exception {
        try (Connection connection = DataSource.getConnection()) {
            PreparedStatement query = connection
                    .prepareStatement(FIND_BY_EMAIL_AND_PASSWORD);
            query.setString(1, user.getEmail());
            query.setString(2, user.getPassword());
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                return Optional.of(mapUser(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new Exception("Unable to find all students", e);
        }
    }
    public static void createNewUser(User user) throws SQLException {
        try (Connection connection = DataSource.getConnection()) {
            PreparedStatement query = connection
                    .prepareStatement(CREATE_USER);
            query.setString(1, user.getFirstName());
            query.setString(2, user.getLastName());
            query.setString(3, user.getEmail());
            query.setString(4, user.getPassword());
            query.setString(5, user.getRole());
            query.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Unable to store student due: " + e.getMessage(), e);
        }
    }

    private static User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("role"));
    }

}
