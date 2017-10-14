package com.etc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.9.250:1521:orcl", "scott",
					"tiger");

			// java中设置不自动提交
			conn.setAutoCommit(false);// 默认为true 自动提交

			// 1 学长 转钱 给学妹
			// 学长的钱扣了 -balance
			String sql1 = "update t_account set balance = balance -2 where accountId=1";

			// 2学妹的钱 加了 +balance
			String sql2 = "update t_account set balance = balance +2 where accountId=2";
			// 3交易记录增加一条
			// insert
			String sql3 = "insert into t_transrecord(transid,fromid,toid,transmoney) values(10,1,2,2)";

			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);

			int n1 = pstmt1.executeUpdate();

			// 此处异常了
			System.out.println(1 / 0);

			int n2 = pstmt2.executeUpdate();
			int n3 = pstmt3.executeUpdate();

			// 手动提交
			conn.commit();

			System.out.println("n1: " + n1 + ",n2: " + n2 + ",n3 : " + n3);

			// 释放资源
			pstmt1.close();
			pstmt2.close();
			pstmt3.close();

			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// 回滚
			try {
				//这里回滚的意义是什么?
				//conn.rollback();
				//System.out.println("执行出错，事务自动回滚");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
