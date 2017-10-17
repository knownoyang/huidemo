package com.etc.dao;

import java.util.List;

import com.etc.cms.util.BaseDao;
import com.etc.cms.util.PageData;
import com.etc.entity.Emp;

public class EmpDao {

	/**
	 * 物理分页查询
	 * @param page
	 * @param pageSize
	 * @param pename
	 * @return
	 */
	public PageData<Emp> getEmpByPage(int page, int pageSize, String pename) {
		String sql = "select * from emp where ename like ?";
		return BaseDao.getOraclePage(sql, page, pageSize, Emp.class, "%"
				+ pename + "%");
	}
	
	
	/**
	 * 查询
	 * @return
	 */
	public List<Emp> getEmp() {
		String sql = "select * from emp";
		return (List<Emp>) BaseDao.select(sql, Emp.class);
	}
	
	/**
	 * 增加员工
	 * @param emp
	 * @return
	 */
	public boolean addEmp(Emp emp) {
		String sql = "insert into emp(empno,ename,job,hiredate,deptno) values (?,?,?,to_date(?,'yyyy-mm-dd'),?)";
		return BaseDao.execute(sql, emp.getEMPNO(),emp.getENAME(),emp.getJOB(),emp.getHIREDATE(),emp.getDEPTNO())>0;
	}

	/**
	 * update
	 * @param emp
	 * @return
	 */
	public boolean updateEmp(Emp emp) {
		String sql = "update emp set ename=?,job=?,hiredate=to_date(?,'yyyy-mm-dd'),deptno=? where empno=?";
		return BaseDao.execute(sql, emp.getENAME(),emp.getJOB(),emp.getHIREDATE(),emp.getDEPTNO(),emp.getEMPNO())>0;
	}

}
