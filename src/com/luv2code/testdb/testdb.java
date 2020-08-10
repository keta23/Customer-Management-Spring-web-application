package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class testdb
 */
@WebServlet("/testdb")
public class testdb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="springstudent";
		String pass="springstudent";
		String jdbcurl="jdbc:mysql:3306//web_customer_tracker?useSSL=false&serverTimezome=UTC";
		String driver="com.mysql.jdbc.Driver";
		try
		{
			PrintWriter out=response.getWriter();
			out.println("connected");
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcurl,user,pass);
			out.println("sucessful");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
