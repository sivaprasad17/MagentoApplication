package com.abc.Bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private String un="system";
	private String pwd="system";
	private Connection con=null;
	private ResultSet res=null;
	private PreparedStatement pstmt=null;
	
	private int customerid=0;
	private String password=null;
	
	private int transamt=0;
	private int tpaccno=0;
	
	private int balance=0;
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	public int getTransamt() {
		return transamt;
	}
	public int getTpaccno() {
		return tpaccno;
	}
	public void setTransamt(int transamt) {
		this.transamt = transamt;
	}
	public void setTpaccno(int tpaccno) {
		this.tpaccno = tpaccno;
	}
	public int getCustomerid() {
		return customerid;
	}
	public String getPassword() {
		return password;
	}
	public int getAccno() {
		return accno;
	}
	public String getName() {
		return name;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public void setName(String name) {
		this.name = name;
	}

	private int accno=0;
	private String name=null;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setRes(ResultSet res) {
		this.res = res;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public String getUrl() {
		return url;
	}
	public String getUn() {
		return un;
	}
	public String getPwd() {
		return pwd;
	}
	public Connection getCon() {
		return con;
	}
	public ResultSet getRes() {
		return res;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	
	public Model()
	{
		try
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection(url, un, pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	boolean login()
	{
		try
		{
			pstmt=con.prepareStatement("select * from BANK where CUSTOMERID=? and PASSWORD=?");
			pstmt.setInt(1, customerid);
			pstmt.setString(2, password);
	
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				name=res.getString(5);
				accno=res.getInt(1);
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	boolean transfer()
	{
		try
		{
			pstmt=con.prepareStatement("update  BANK set BALANCE=BALANCE-? where ACCNO=?");
			pstmt.setInt(1, transamt);
			pstmt.setInt(2, accno);
			pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("update  BANK set BALANCE=BALANCE+? where ACCNO=?");
			pstmt.setInt(1, transamt);
			pstmt.setInt(2, tpaccno);
			pstmt.executeUpdate();
			
			return true;
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	boolean checkBalance()
	{
		try
		{
			pstmt=con.prepareStatement("select * from BANK where ACCNO=?");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				balance=res.getInt(9);
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
