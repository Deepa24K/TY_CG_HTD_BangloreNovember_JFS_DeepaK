package com.cg.assessement.controller;

import java.util.Scanner;

import com.cg.assessement.bean.ContactBean;
import com.cg.assessement.dao.ContactDAO;
import com.cg.assessement.daomanager.ContactDAOManager;

public class ContactMain {
	public static void main(String[] args) {
		ContactDAO dao=ContactDAOManager.getContactDAO();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 to Add,Delete or Modify the Contact");
			System.out.println("Press 2 to see the Contact List");
			System.out.println("Press 3 to search the Existing Contact");
			
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				System.out.println("Press a to Add the Contact to List");
				System.out.println("Press b to Delete the Contact from List");
				System.out.println("Press c to Modify the Contact from List");
				int choice1=sc.nextInt();
				switch(choice1) {
				case 1:
					System.out.println("Enter Contact Name");
					String name=sc.next();
					System.out.println("Enter Contact Number");
					int number=sc.nextInt();
					System.out.println("Enter the Group Name");
					String cgroup=sc.next();
					ContactBean bean=new ContactBean();
					bean.setName(name);
					bean.setNumber(number);
					bean.setCgroup(cgroup);
					boolean check=dao.addContact(bean);
					if(check) {
						System.out.println("New Contact added to list");
					}else {
						System.err.println("Contact already Exist!!!");
					}
					break;
				case 2:
					System.out.println("Enter Contact Name to Delete");
					String name1=sc.next();
					if(dao.deleteContact(name1)) {
					System.out.println("customer deleted");
					}else {
						System.err.println("not found");
					}
					break;
				case 3:
					ContactBean bean1=new ContactBean();
				System.out.println("Enter Contact Name");
				    bean1.setName(sc.next());
				    if(dao.modifyContact(bean1.getName())) 
				    {
				    	System.out.println("Contact Modified Successfully");
				    }else {
				    	System.err.println("Something Went Wrong");
				    }
				break;
			}
			case 2:
					System.out.println(dao.showAllContacts());
				    break;
			}
		}
	}
}
