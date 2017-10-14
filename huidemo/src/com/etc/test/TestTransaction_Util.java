package com.etc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.etc.cms.util.BaseDao;

public class TestTransaction_Util {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		try {

			conn = BaseDao.getConn();
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

			BaseDao.execute(sql1, conn, null);
			BaseDao.execute(sql2, conn, null);
			BaseDao.execute(sql3, conn, null);
			// 此处异常了
			//System.out.println(1 / 0);

			// 手动提交
			conn.commit();
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// 回滚
			try {
				// 这里回滚的意义是什么?
				 conn.rollback();
				 System.out.println("执行出错，事务自动回滚");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			conn.close();
		}

	}

}
