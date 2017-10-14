package com.etc.test;

import com.etc.cms.util.BaseDao;
import com.etc.cms.util.PageData;
import com.etc.entity.Emp;

public class TestOracleByPage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int page = 1;
		int pageSize = 5;
		String sql = "select * from emp";

		PageData<Emp> pd = BaseDao.getOraclePage(sql, page, pageSize,
				Emp.class, null);
		
		
		for (Emp emp : pd.getData()) {
			System.out.println(emp);
		}
		
		System.out.println("×ÜÒ³Êý : "+pd.getTotalPage());

	}

}
