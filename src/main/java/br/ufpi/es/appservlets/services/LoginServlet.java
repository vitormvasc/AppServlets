package br.ufpi.es.appservlets.services;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufpi.es.appservlets.controllers.UsersController;
import br.ufpi.es.appservlets.data.*;
import br.ufpi.es.appservlets.entities.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositoryListUsers repository;
	private UsersController controller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        repository = new RepositoryListUsers();
        repository.populateUsers();
        controller = new UsersController(repository);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") != null){
			response.sendRedirect("main");
		}else{
			response.sendRedirect("loginForm.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		
		login = request.getParameter("login");
		password = request.getParameter("password");
		User user = controller.search(login, password);
		
		if (user != null){
			HttpSession session = request.getSession();
			session.setAttribute("email", user.getEmail());
			Date createUserSession = new Date(session.getCreationTime());
			session.setAttribute("user", user);
			System.out.println("User " + session.getAttribute("email") + " logged at: " + createUserSession);
			response.sendRedirect("MainServlet");
		}else{
			response.sendRedirect("loginForm.jsp");
		}
	}

}
