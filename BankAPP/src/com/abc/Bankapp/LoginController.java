package com.abc.Bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet 
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			String temp=x.getParameter("customerid");
			int customerid=Integer.parseInt(temp);
			
			String password=x.getParameter("password");
			
			Model m=new Model();
			m.setCustomerid(customerid);
			m.setPassword(password);
			
			boolean b=m.login();
			if(b==true)
			{
				HttpSession hs=x.getSession(true);
				hs.setAttribute("NAME", m.getName());
				hs.setAttribute("ACCNO", m.getAccno());
				y.sendRedirect("/BankAPP/LoginSuccess.jsp");
			}
			else
			{
				y.sendRedirect("/BankAPP/LoginFailure.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
