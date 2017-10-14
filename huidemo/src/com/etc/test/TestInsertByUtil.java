package com.etc.test;

import com.etc.cms.util.BaseDao;

public class TestInsertByUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String sql = "insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values(1238,'ÀÏÍõ','SALESMAN',7979,to_date('2017-9-25','YYYY-MM-DD'),1000,0,99)";
		int n = BaseDao.execute(sql, null);

		if (n > 0)
			System.out.println("success");
		else
			System.out.println("error");

	}

}
