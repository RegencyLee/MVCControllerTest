package com.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12354L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	private void process(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		String dispatchUrl = null;
		if(action.equals("product_input.action")){
			InputProductController inputController = new InputProductController();
			dispatchUrl = inputController.handleRequest(req, resp);
		}
		else if(action.equals("product_save.action")){
			SaveProductController saveProduct = new SaveProductController();
			dispatchUrl = saveProduct.handleRequest(req, resp);
		}
		
		if(dispatchUrl != null){
			RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
			rd.forward(req, resp);
		}
	}
	
}
