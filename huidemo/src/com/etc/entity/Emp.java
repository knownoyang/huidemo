package com.etc.entity;

/**
 * emp µÃÂ¿‡
 * 
 * @author Administrator
 * 
 */
public class Emp {

	private int EMPNO;
	private String ENAME;
	private String JOB;
	private int MGR;
	private String HIREDATE;
	private double SAL;
	private double COMM;
	private int DEPTNO;

	public int getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(int eMPNO) {
		EMPNO = eMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int mGR) {
		MGR = mGR;
	}

	public String getHIREDATE() {
		return HIREDATE.substring(0,10);
	}

	public void setHIREDATE(String hIREDATE) {
		HIREDATE = hIREDATE.substring(0,10);
	}

	public double getSAL() {
		return SAL;
	}

	public void setSAL(double sAL) {
		SAL = sAL;
	}

	public double getCOMM() {
		return COMM;
	}

	public void setCOMM(double cOMM) {
		COMM = cOMM;
	}

	public int getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(int dEPTNO) {
		DEPTNO = dEPTNO;
	}

	public Emp(int eMPNO, String eNAME, String jOB, int mGR, String hIREDATE,
			double sAL, double cOMM, int dEPTNO) {
		super();
		EMPNO = eMPNO;
		ENAME = eNAME;
		JOB = jOB;
		MGR = mGR;
		HIREDATE = hIREDATE;
		SAL = sAL;
		COMM = cOMM;
		DEPTNO = dEPTNO;
	}

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Emp [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB
				+ ", MGR=" + MGR + ", HIREDATE=" + HIREDATE + ", SAL=" + SAL
				+ ", COMM=" + COMM + ", DEPTNO=" + DEPTNO + "]";
	}

}
