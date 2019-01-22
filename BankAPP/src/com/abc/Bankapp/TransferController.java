package com.abc.Bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransferController extends HttpServlet
{
	public void service(HttpServletRequest  x,HttpServletResponse y)
	{
		try
		{
			String temp = x.getParameter("tpaccno");
			int tpaccno = Integer.parseInt(temp);
			String temp2=x.getParameter("transamt");
			int transamt = Integer.parseInt(temp2);
			
			HttpSession hs = x.getSession();
			int accno=(int) hs.getAttribute("ACCNO");
			
			Model m=new Model();
			m.setTpaccno(tpaccno);
			m.setTransamt(transamt);
			m.setAccno(accno);
			boolean b= m.transfer();
			
			if(b==true)
			{
				y.sendRedirect("/BankAPP/TransferSuccess.jsp");
			}
			else
			{
				y.sendRedirect("/BankAPP/TransferFailure.jsp");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
