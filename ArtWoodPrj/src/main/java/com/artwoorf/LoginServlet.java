package com.artwoorf;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

import static java.lang.System.out;

public class LoginServlet extends HttpServlet {
    private  static final long serialVersionUid = 1L;

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/artwood","root","");
            String n=request.getParameter("txtName");
            String p=request.getParameter("txtPwd");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM login WHERE uname=? and password=?");
            ps.setString(1, n);
            ps.setString(2, p);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {

                RequestDispatcher rd =request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            }
            else
            {
                    out.println("<font color=red size=18> Login Failed!! <");
                    out.println("<a href=login.jsp> Try Again< /a>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
