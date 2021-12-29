package com.xworkz.newspaper;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class NewspaperServlet implements Servlet{
	
	public NewspaperServlet() {

		System.out.println(this.getClass().getSimpleName() +" bean created");
	}

	@Override
	public void destroy() {
		System.out.println(this.getClass().getSimpleName() +" bean destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig req) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.write("<html><body>");
		out.write("<h1> Heyyyy!! </h1>");
		out.write("</body></html>");
		
		out.close();
	}

}
