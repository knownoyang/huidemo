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
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpService es = new EmpService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		int page = 1;

		int pageSize = 10;

		String pename = "";

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}

		if (request.getParameter("pename") != null) {
			pename = request.getParameter("pename");
		}

		// 调用service的分页方法返回一个pageData对象
		//PageData<Emp> pd = es.getEmpByPage(page, pageSize, pename);

		List<Emp> list = es.getEmp(); 
		// Ajax来实现
		// 返回数据最好是json格式 外部的jar包 gson
		MyData<Emp> md = new MyData<Emp>();
		md.setData(list);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(md);

		// 使用printWriter对象
		PrintWriter out = response.getWriter();

		out.print(jsonString);

		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
