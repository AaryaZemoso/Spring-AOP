package webapp.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

        String driver = "com.mysql.jdbc.Driver";

        try{

            PrintWriter out = resp.getWriter();

            out.println("Connecting to Database...." + jdbcUrl);

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Connection Successfull");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
