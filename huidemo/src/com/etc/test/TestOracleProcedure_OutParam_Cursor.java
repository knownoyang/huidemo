package com.etc.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import oracle.jdbc.internal.OracleTypes;

public class TestOracleProcedure_OutParam_Cursor {

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

			// 创建和调用存储过程有关的对象
			// {call <procedure-name>[(<arg1>,<arg2>, ...)]}
			//参数1 为输入参数，模糊查询的姓名部分
			//参数2 为输出参数 类型是cursor
			CallableStatement cstmt = conn
					.prepareCall("{call  package8.s(?,?)}");

			// 补充参数
			cstmt.setString(1, "S");
			
			//第二个参数是一个输出 参数
			//注意点1  OracleTypes.CURSOR
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);

			// 调用过程
			cstmt.execute();
			
			//注意点2 去获取输出参数 类型是一个cusor 此时要获取的对象转换为ResultSet
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next())
			{
				// 输出
				System.out.println("ename :"+rs.getString("ename")+", sal:"+rs.getFloat("sal"));
			}

			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 释放资源
			// rs cstmt conn 

		}

	}

}
