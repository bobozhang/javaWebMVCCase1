package com.bo.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 String method = request.getParameter("method");
//		 switch(method){
//		 	 case "add":add(request,response);break;
//		 	 case "query":query(request,response);break;
//		 	 case "delete":delete(request,response);break;
//		 }
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.获取servletPath:/edit.do 或addCustomer.do
		String servletPath = req.getServletPath();
		//2.去除 / 和 .do
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0,methodName.length()-3);
		try {
			//3.利用反射获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			//4.利用反射调用对应的方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.sendRedirect("error.jsp");
		}  
  	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add");
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("query");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete");
	}
}
