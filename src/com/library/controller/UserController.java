package com.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library.dao.UserDAOImp;
import com.library.entity.User;
import com.library.service.UserService;
import com.library.service.UserServiceImp;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;	
	@RequestMapping("/login")
	public String addUser(HttpServletRequest request, Model model,  HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		if(username != null && password != null) {
			User user = userService.getUserName(username, password);
			if(user != null) {
				String role = user.getRole();
				session.setAttribute("username", username);
				session.setAttribute("role", role);
				return "Admin";
				
			}else {
				model.addAttribute("sucess", "Fail!");
				return "Login";
			}
		}
		//return "Login";
		return "Fail";
		
	}
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request, Model model,  HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		return "Login";		
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		
		if(username != null) {
			User user = userService.getUserByName(username);
			if(user == null) {
				User u = new User();
				u.setUserName(username);
				u.setPassWord(password);
				u.setRole("student");
				u.setCanBorrow(0);
				u.setQuantityOfBookCanBorrow(0);
				userService.addUser(u);
				model.addAttribute("message", u);
			}else {
				model.addAttribute("message", "Fail!");
			}
		}
		return "Register";
	}
	@RequestMapping("/admin")
	public String admin(HttpServletRequest request, Model model,  HttpServletResponse response) throws ServletException, IOException {
		
		return "Admin";
		
	}
	@RequestMapping(value ="/usermanagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request, Model model,  HttpServletResponse response) throws ServletException, IOException {
		List<User> list = userService.getAllUser();
		model.addAttribute("list",list);
		return "UserManagement";		
	}
	@RequestMapping("/bookmanagement")
	public String bookManagement(HttpServletRequest request, Model model,  HttpServletResponse response) throws ServletException, IOException {
		return "BookManagement";		
	}
	@RequestMapping("/ticketmanagement")
	public String ticketManagement(HttpServletRequest request, Model model,  HttpServletResponse response) throws ServletException, IOException {
		return "TicketManagement";		
	}
	@RequestMapping(value ="/updateuser", method = RequestMethod.POST)
	public String updateUser(Model model,  HttpServletRequest request) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").toString());
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String role = request.getParameter("roless");
		int ticketnumber = Integer.parseInt(request.getParameter("ticketnumber"));
		int quantitycanborrow = Integer.parseInt(request.getParameter("quantitycanborrow"));
		int canborrow = Integer.parseInt(request.getParameter("canborrow"));
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		u.setPassWord(passWord);
		u.setRole(role);
		u.setTicketNumber(ticketnumber);
		u.setQuantityOfBookCanBorrow(quantitycanborrow);
		u.setCanBorrow(canborrow);
		userService.updateUser(u);
		List<User> list = userService.getAllUser();
		model.addAttribute("list",list);
		return "UserManagement";		
	}
	@RequestMapping(value ="/deleteuser{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id, Model model,  HttpServletRequest request) throws ServletException, IOException {
		User u = userService.findUser(id);
		userService.deleteUser(u);
		List<User> list = userService.getAllUser();
		model.addAttribute("list",list);
		return "UserManagement";		
	}
	
}
