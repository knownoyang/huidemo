package com.etc.test;

import java.util.List;

import com.etc.cms.util.BaseDao;
import com.etc.entity.Emp;

public class TestQueryByUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String sql = "select * from emp";
		List<Emp> list = (List<Emp>) BaseDao.select(sql, Emp.class, null);

		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
