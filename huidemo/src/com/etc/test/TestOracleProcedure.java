package com.etc.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestOracleProcedure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.9.250:1521:orcl", "scott",
					"tiger");
			
			//创建和调用存储过程有关的对象
			//{call <procedure-name>[(<arg1>,<arg2>, ...)]}
			CallableStatement cstmt = conn.prepareCall("{call PROC_ADDEMP2(?,?,?,?,?,?,?)}");
			
			//补充参数
			cstmt.setInt(1, 1212);
			cstmt.setString(2, "小二");
			cstmt.setString(3, "秘书");
			cstmt.setInt(4, 1234);
			cstmt.setInt(5, 9999);
			cstmt.setInt(6, 1);
			cstmt.setInt(7, 30);
			
			
			//调用过程
			cstmt.executeUpdate();
			
			//输出
			System.out.println("执行完毕");
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
