/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sasa Adel
 */
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
public class HelloServlet implements Servlet  {

    private String databaseAddress;
    private String userName;
    private String password;
public HelloServlet() {
    System.out.println("HelloServlet Constructor Called");
}
    @Override
    public void init(ServletConfig sc) throws ServletException {
        System.out.println("Servlet Initialized");
        databaseAddress = sc.getInitParameter("databaseAddress");
        userName = sc.getInitParameter("userName");
        password = sc.getInitParameter("password");
        System.out.println("Servlet Initialized with Database Address: " + databaseAddress
                + ", User Name: " + userName
                + ", Password: " + password);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest sr, ServletResponse servletresponse) throws ServletException, IOException {
        servletresponse.setContentType("text/html");
        PrintWriter writer = servletresponse.getWriter();
       writer.print("<h1>Hello There, it's Samuel</h1>");
        writer.print("<p>Database Address: " + databaseAddress + "</p>");
        writer.print("<p>User Name: " + userName + "</p>");
        writer.print("<p>Password: " + password + "</p>");
        writer.print("</body></html>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed");
    }

}
