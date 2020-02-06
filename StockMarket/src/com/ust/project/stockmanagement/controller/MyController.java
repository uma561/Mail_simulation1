package com.ust.project.stockmanagement.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.project.stockmanagement.model.ModelDTO;
import com.ust.project.stockmanagement.model.OrderDTO;
import com.ust.project.stockmanagement.model.RegistrationDTO;
import com.ust.project.stockmanagement.service.MyService;

@Component
@RequestMapping("/")
public class MyController {
	
	@Autowired
	MyService ms;
	HttpSession ss;
	@RequestMapping("/Register")
	public String reg() {
		return "Register";
	}

	@RequestMapping(value="/MangerRegistration",method=RequestMethod.POST)
	public ModelAndView MangerRegistration(@ModelAttribute RegistrationDTO rdto) {
		boolean b=ms.MangerRegistration(rdto);
		if(b) {
			return new ModelAndView("Register","msg","User is  registered Sucessfully......");
		}
		else
		{
			return new ModelAndView("Register","msg","User is already registered........");
		}
	}
	@RequestMapping("/Login")
	public String log() {
		return "Login";
	}


	@RequestMapping(value="/ManagerLogin",method=RequestMethod.POST)
	public ModelAndView ManagerLogin(HttpServletRequest req) {

		boolean  b=ms.ManagerLogin(req);
		if(b) {
			String email=req.getParameter("email");

			ss=req.getSession();
			ss.setAttribute("email", email);
			String user=(String) ss.getAttribute("email");
			System.out.println("Success");
			return  new ModelAndView("Home","user",user);
		}
		else {
			System.out.println("Failed");
			return new ModelAndView("Login","msg","Invalid Id or Password");
		}
	}
	
	@RequestMapping("/Home")
	public ModelAndView Home(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Home","user",email);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
	}


	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) {
		ss=req.getSession(false);
		ss.invalidate();

		return new ModelAndView("ind","logout","Logout Sucessfull......");
	}
	
	@RequestMapping("/add")
		public ModelAndView add(){
		String email=(String) ss.getAttribute("email");
		if(email!=null){
			return new ModelAndView("AddProduct");
	}else
	{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	
	@RequestMapping(value="addproduct",method=RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute ModelDTO mdto){
	System.out.println("inside Controller");
	boolean b=ms.addproduct(mdto);
	if(b){
	return new ModelAndView("AddProduct","msg","Product added Successfully...............");
	
	}else{
	return new ModelAndView("Home","msg","Product already in the cart......");
	}
	}
	
	@RequestMapping("/allproduct")
	public ModelAndView allproduct(){
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		List<ModelDTO>mlist=ms.allproduct();
		if(mlist!=null){
		return new ModelAndView("Allproducts","mlist",mlist);
	}else{
		return new ModelAndView("Allproducts","msg","No product avilable");
	}
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
}

	@RequestMapping("/search")
	public String searchProduct(HttpServletRequest req){
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return "Search";
	}else{
	 return "Login";	
	}
	}
	@RequestMapping("/searchData")
	public ModelAndView searchproduct(HttpServletRequest req){
		String search=req.getParameter("search");
		String filter=req.getParameter("searchBy");
		List<ModelDTO>mlist=ms.searchproduct(search,filter);
		if(mlist.isEmpty()){
			return new ModelAndView("Search","msg","This Product not avilable");	
	}else{
		return new ModelAndView("Search","mlist",mlist);	
		
	}
	}
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute ModelDTO mdto,HttpServletRequest req){
		ss=req.getSession(false);
		List<ModelDTO>mlist=ms.updateproduct(mdto);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Allproducts","mlist",mlist);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	@RequestMapping("/addtocart")
	public ModelAndView addtocart(@ModelAttribute ModelDTO mdto,HttpServletRequest req){
		ss=req.getSession();
		List<ModelDTO>mlist=ms.addtocart(mdto);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Addcart","mlist",mlist);
		}else{
		return new ModelAndView("Login","msg","Login First");
		}
	}
	 
	@RequestMapping("/cartadded")
	public ModelAndView cartadded(@ModelAttribute ModelDTO mdto){
	      ms.cartadded(mdto);
	return new ModelAndView("Home","mlist","Cart Added Success");
	}
	@RequestMapping("/ShowCart")
	public ModelAndView ShowCart(@ModelAttribute ModelDTO mdto,HttpServletRequest req){
		ss=req.getSession();
		List<OrderDTO>olist=ms.showCart();
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("ShowCart","olist",olist);
	}else{
		return new ModelAndView("Login","msg","Login First");

	}
}
}


