package com.cg.assessement.dao;

import java.util.List;

import com.cg.assessement.bean.ContactBean;

public interface ContactDAO {
	public List<ContactBean> showAllContacts();
	ContactBean searchContact(String name);
	boolean addContact(ContactBean bean);
	boolean deleteContact(String name);
	public boolean modifyContact(String name);
}
