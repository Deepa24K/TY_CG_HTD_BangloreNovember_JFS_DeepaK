package com.cg.assessement.daomanager;

import com.cg.assessement.dao.ContactDAO;
import com.cg.assessement.dao.ContactDAOImpl;

public class ContactDAOManager {
	public static ContactDAO getContactDAO() {
		return new ContactDAOImpl();
	}
}
