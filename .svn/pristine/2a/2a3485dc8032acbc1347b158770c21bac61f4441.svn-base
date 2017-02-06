package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.auth.contacts.ExcludedContactsCategory;
import com.xym.bossed.db.mybatis.auth.contacts.ExcludedContactsDAO;

public class ExcludedContactsService {
	public List<String> getAllContactsCatagory() {
		ExcludedContactsDAO eco=new ExcludedContactsDAO();
		return eco.getAllContactsCatagory();
	}
	public List<ExcludedContactsCategory> getExcludedContactsCategoryByRoleId(int role_id)
	{
		ExcludedContactsDAO eco=new ExcludedContactsDAO();
		
		return eco.getExcludedContactsCategoryByRoleId(role_id);
	}
	public int insertExcludedContactsCategory(ExcludedContactsCategory ecc)
	{
		ExcludedContactsDAO eco=new ExcludedContactsDAO();
		return eco.insertExcludedContactsCategory(ecc);
	}
	public int deleteExcludedContactsCategory(ExcludedContactsCategory ecc)
	{
		ExcludedContactsDAO eco=new ExcludedContactsDAO();
		return eco.deleteExcludedContactsCategory(ecc);
	}
}
