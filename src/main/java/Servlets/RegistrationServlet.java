package Servlets;

import DAO.UserDAO;
import Models.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        System.out.println("got post");
        String requestText = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        User user = gson.fromJson(requestText, User.class);
        try {
            UserDAO.createNewUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Writer wr = response.getWriter();
        wr.write("we created user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}