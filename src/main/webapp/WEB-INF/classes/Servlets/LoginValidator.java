package Servlets;

import DAO.DataSource;
import DAO.UserDAO;
import Models.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import java.util.stream.Collectors;

public class LoginValidator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        System.out.println("got post");
        String requestText = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        User login = gson.fromJson(requestText, User.class);
        Optional<User> user = null;
        try {
            user = UserDAO.findByEmailAndPassword(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user.isPresent()) {
            String userJson = gson.toJson(user.get());
            response.setContentType("text/plain");
            Writer wr = response.getWriter();
            wr.write(userJson);
        }
        else {
            System.out.println("we didnt found anything");
            response.setContentType("text/plain");
            Writer wr = response.getWriter();
            wr.write("notFound");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer wr  = response.getWriter();
        wr.write("HELLO IM FUCKING WORKING YOU KNOW GUYS");
    }
}
