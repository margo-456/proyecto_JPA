package com.web.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Usuario_Mos;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xhtml");
		PrintWriter out =response.getWriter();
		// accept username and password from index.html file
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?useSSL=false","root","");
			
			Statement stm= con.createStatement();
			ResultSet rs=stm.executeQuery("select * from usuario where username='"+username+"' and password='"+password+"'");
			
			if(rs.next()) {
				response.sendRedirect("bienvenidaCli.jsf");
				System.out.println(rs.getNString(3));
			}else {
				out.println("Usuario incorrecto");
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		                                       
	}


}
