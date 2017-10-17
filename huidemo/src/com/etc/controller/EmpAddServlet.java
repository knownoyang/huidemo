package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.cms.util.MyData;
import com.etc.entity.Emp;
import com.etc.service.EmpService;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpAddServlet")
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpService es = new EmpService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String ename = request.getParameter("ename");
		int empno = Integer.valueOf(request.getParameter("empno"));
		String job = request.getParameter("job");
		String hiredate = request.getParameter("hiredate");
		int deptno = Integer.valueOf(request.getParameter("deptno"));

		EmpService es = new EmpService();
		Emp emp = new Emp(empno, ename, job, 0, hiredate, 0, 0, deptno);
		System.out.println(emp);
		if (request.getParameter("op").equals("update")) {
			es.updateEmp(emp);
		} else {
			es.addEmp(emp);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
