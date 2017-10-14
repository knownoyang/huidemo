package com.etc.service;

import java.util.List;

import com.etc.cms.util.BaseDao;
import com.etc.cms.util.PageData;
import com.etc.dao.EmpDao;
import com.etc.entity.Emp;

public class EmpService {

	EmpDao ed = new EmpDao();

	public PageData<Emp> getEmpByPage(int page, int pageSize, String pename) {
		return ed.getEmpByPage(page, pageSize, pename);
	}
	
	public List<Emp> getEmp() {
		
		return (List<Emp>)ed.getEmp();
	}

}
