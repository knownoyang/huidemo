package com.etc.dao;

import java.util.List;

import com.etc.cms.util.BaseDao;
import com.etc.cms.util.PageData;
import com.etc.entity.Emp;

public class EmpDao {

	public PageData<Emp> getEmpByPage(int page, int pageSize, String pename) {
		String sql = "select * from emp where ename like ?";
		return BaseDao.getOraclePage(sql, page, pageSize, Emp.class, "%"
				+ pename + "%");
	}
	
	
	public List<Emp> getEmp() {
		String sql = "select * from emp";
		return (List<Emp>) BaseDao.select(sql, Emp.class);
	}

}
