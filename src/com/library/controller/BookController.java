package com.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.Books;
import com.library.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	/*@RequestMapping(value = "/addBook")
	public String addBook(Model model) {
		model.addAttribute("addBook", new Books());
		return "BookManagement";
	}*/
	
	@RequestMapping(value = "/bookmanagement", method = RequestMethod.GET)
	public String getAllBook(Model model, HttpServletRequest request) {
		List<Books> list = bookService.getAllBook();
		model.addAttribute("listbook", list);
		request.setAttribute("addBook", new Books());
		return "BookManagement";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ModelAndView addBook(ModelMap model, HttpServletRequest request, @ModelAttribute("addBook") Books book) {
		bookService.insertBook(book);
		List<Books> list = bookService.getAllBook();
		model.addAttribute("listbook", list);
		return new ModelAndView("redirect:/bookmanagement", model);
	}
	
	@RequestMapping("/deleteBook{bookID}")
	public String deleteBook(@PathVariable("bookID") int bookID) {
		
		Books book = bookService.getBookByID(bookID);
		bookService.deleteBook(book);
		return "redirect:/bookmanagement";
	}
	@RequestMapping(value ="/updatebook", method = RequestMethod.POST)
	public String updateBook(Model model,  HttpServletRequest request) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").toString());
		String title = request.getParameter("updatetitle");
		String author = request.getParameter("updateauthor");
		String category = request.getParameter("updatecategory");		
		String updateisbn = request.getParameter("updateisbn");		
		int updateprice = Integer.parseInt(request.getParameter("updateprice"));
		int updatequantity = Integer.parseInt(request.getParameter("updatequantity"));
		int updateremain = Integer.parseInt(request.getParameter("updateremain"));
		Books b = new Books();
		b.setBookID(id);
		b.setBookTitle(title);
		b.setAuthor(author);
		b.setCategory(category);
		b.setIsbnNumber(updateisbn);
		b.setPrice(updateprice);
		b.setQuantity(updatequantity);
		b.setRemain(updateremain);
		bookService.updateBook(b);
		List<Books> list = bookService.getAllBook();
		model.addAttribute("listbook",list);
		return "redirect:/bookmanagement";		
	}
}
