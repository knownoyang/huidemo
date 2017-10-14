package com.etc.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import oracle.jdbc.internal.OracleTypes;

public class TestOracleProcedure_OutParam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Connection conn = null;
		int deptno = 40;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.9.250:1521:orcl", "scott",
					"tiger");

			// 创建和调用存储过程有关的对象
			// {call <procedure-name>[(<arg1>,<arg2>, ...)]}
			CallableStatement cstmt = conn
					.prepareCall("{call PROC_GETEMPCOUNTBYDEMPT(?,?)}");

			// 补充参数
			cstmt.setInt(1, deptno);
			
			//第二个参数是一个输出 参数
			//注意点1 OracleTypes.INTEGER参数类型可以指定为特殊数据类型
			cstmt.registerOutParameter(2, OracleTypes.INTEGER);

			// 调用过程
			cstmt.execute();
			
			//注意点2 去获取输出参数
			int count = cstmt.getInt(2);

			
			// 输出
			System.out.println("执行完毕 部门 "+deptno+",人数: "+count);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 释放资源
			//cstmt conn

		}

	}

}
