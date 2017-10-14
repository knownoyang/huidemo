package com.etc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			PreparedStatement pstmt = conn
					.prepareStatement("insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values(1236,'ÖìÕð','SALESMAN',7979,to_date('2017-9-25','YYYY-MM-DD'),1000,0,99)");

			int n = pstmt.executeUpdate();

			if (n > 0)
				System.out.println("success");
			else
				System.out.println("error");
			
			//ÊÍ·Å×ÊÔ´
			pstmt.close();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
