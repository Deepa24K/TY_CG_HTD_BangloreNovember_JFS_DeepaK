package com.cg.assessement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.cg.assessement.bean.ContactBean;

public class ContactDAOImpl implements ContactDAO{
	Scanner sc=new Scanner(System.in);
	Connection conn=null;
	PreparedStatement pstmt=null;
	FileReader reader;
	Properties prop;
	ContactBean bean;


	public ContactDAOImpl() {
		try {
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ContactBean> showAllContacts() {
		List<ContactBean>list=new ArrayList<ContactBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("showAllQuery"))){
			while(rs.next()) {
				bean=new ContactBean();
				bean.setName(rs.getString(1));
				bean.setNumber(rs.getInt(2));
				bean.setCgroup(rs.getString(3));
				list.add(bean);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ContactBean searchContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("searchQuery"));
				)
		{
			pstmt.setString(1, bean.getName());
			
			int count=pstmt.executeUpdate();
			if(count>0) {
				return bean;
		}
		}catch(Exception e) {
				e.printStackTrace();
			}
        return null;
	}

	@Override
	public boolean addContact(ContactBean bean) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("insertQuery"));
				)
		{
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getCgroup());

			int count=pstmt.executeUpdate();

			if(count>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("deleteQuery"));
				){
			pstmt.setString(1,name);

			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifyContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("modifyQuery"));
				){
			pstmt.setString(1, name);
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getCgroup());

			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}