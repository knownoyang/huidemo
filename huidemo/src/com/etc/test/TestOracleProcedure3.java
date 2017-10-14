package com.etc.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestOracleProcedure3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//用户的生日 从前台接收过来可能是一个字符串类型，此时oracle需要接收的类型是java.sql.Date
		String mydate = "1993-01-01";
		//这里注意一下时间格式yyyy.MM.dd 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date date = null;
		try {
			 date=sdf.parse(mydate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.9.250:1521:orcl", "scott",
					"tiger");

			// 创建和调用存储过程有关的对象
			// {call <procedure-name>[(<arg1>,<arg2>, ...)]}
			CallableStatement cstmt = conn
					.prepareCall("{call PROC_ADDEMP2(?,?,?,?,?,?,?,?)}");

			// 补充参数
			cstmt.setInt(1, 1229);
			cstmt.setString(2, "小8");
			cstmt.setString(3, "秘书");
			cstmt.setInt(4, 1234);

			// 我们注意到5应该是一个时间格式所以这里
			// Sets the designated parameter to the given java.sql.Date
			//cstmt.setDate(5, new Date(System.currentTimeMillis()));// 当前时间
			
			//解决方案1 to_date 
			//王松学长去写
			
			//解决方案2
			cstmt.setDate(5, new Date(date.getTime()));

			
			cstmt.setInt(6, 9999);

			cstmt.setInt(7, 1);
			cstmt.setInt(8, 30);

			// 调用过程
			cstmt.executeUpdate();

			// 输出
			System.out.println("执行完毕");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 释放资源

		}

	}

}
