package com.ust.project.mailsimulation.controller;


import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ust.project.mailsimulation.model.Mail_Info;
import com.ust.project.mailsimulation.model.User_Info;
import com.ust.project.mailsimulation.service.MyService;

@Component
@RequestMapping("/")
public class MyControllerMail {
	@Autowired
	MyService ms;
	@Autowired
	HttpSession hp;

	@RequestMapping("/login")
	public String login() {
		return "login";

	}
	
		@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req){
		
		if(hp.getAttribute("email")!=null){
			//hp.invalidate();
			hp.setAttribute("email", null);
			return new ModelAndView("login","msg","logout success");
		}
		else{
			return new ModelAndView("login","msg","logout success");
		}
		
	}
	


	@RequestMapping("/delMessage")
	public ModelAndView delMessage() {
		List<Mail_Info> mlist=ms.getdeletemessage();
		if(hp.getAttribute("email")!=null){
		return new ModelAndView("delete","msg",mlist);}
		else{
			return new ModelAndView( "login","msg","Login First");
		}

	}

	@RequestMapping("/compose")
	public String composeMail() {
		return "compose";

	}
@RequestMapping("/editCompose")
	public String editcomp1() {
		return "editCompose";

	}
	
	
	@RequestMapping("/draftMail")
	public ModelAndView draft() {
		List<Mail_Info> mlist=ms.getdraft();
		if(hp.getAttribute("email")!=null){
		
		return new ModelAndView( "draft","msg",mlist);
		}
		else{
			return new ModelAndView( "login","msg","Login First");

		}

	}
	
	@RequestMapping("/sentMail")
	public ModelAndView sent() {
		List<Mail_Info> mlist=ms.sentmail();
		if(hp.getAttribute("email")!=null){
		
		return new ModelAndView( "sent","msg",mlist);
		}
		else{
			return new ModelAndView( "login","msg","Login First");

		}

	}
	
	@RequestMapping("/inboxMail")
	public ModelAndView inbox() {
		List<Mail_Info> mlist=ms.getinbox();
		if(hp.getAttribute("email")!=null){
		
		return new ModelAndView( "inbox","msg",mlist);
		}
		else{
			return new ModelAndView( "login","msg","Login First");

		}
		

	}
	
	@RequestMapping("/registration")
	public String registration() {
		return "registration";

	}
	@RequestMapping("/changePass")
	public String changePass() {
		return "changePass";

	}
	@RequestMapping("/forget")
	public String forget() {
		return "forget";

	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		boolean b=ms.delete(id);
		if(b){
			return new ModelAndView("menu","msg","deleted message succefull");
		}else{
			return new ModelAndView("menu","msg","deleted not message succefull");
		}

	}
	
	
	@RequestMapping(value="/loginvalidation",method=RequestMethod.POST)
	public ModelAndView loginvalidation(@ModelAttribute User_Info ui,HttpSession hn) {
		
		System.out.println("inside controller");
		User_Info uinf=ms.login(ui);
		if(uinf!=null) {
			hn.setAttribute("email", uinf.getEmail());
		
			System.out.println("login success");
			return new ModelAndView("menu","dto",uinf);
		}else {
			System.out.println("login failed");
			return new ModelAndView( "login");
		}


	}


	@RequestMapping(value="/registrationData",method=RequestMethod.POST)
	public String registrationData(@ModelAttribute User_Info ui) {

		System.out.println("inside controller");
		ms.register(ui);
		return "registration";
	}
	
	@RequestMapping(value="/composemail",method=RequestMethod.POST)
	public ModelAndView composemail(HttpServletRequest req) {

		System.out.println("inside controller");
	boolean b=	ms.compose(req);
	if(b) {
		return new  ModelAndView("menu","msg","Mail has been sent");
	}else {
		return new  ModelAndView("menu","msg","Mail saved as draft");
	}
	}
	
	
	
	@RequestMapping(value="/composeRe")
	public ModelAndView editCompose(HttpServletRequest req) {

		System.out.println("inside controller");
	boolean b=	ms.editCompose(req);
	if(b) {
		return new  ModelAndView("menu","msg","Mail has been sent");
	}else {
		return new  ModelAndView("menu","msg","Mail saved as draft");
	}
	}
	
	@RequestMapping("/composeEdit")
	public ModelAndView composeEdit(@RequestParam int id){
		Mail_Info dto=ms.composeEdit(id);System.out.println(dto.getDraft_message());
		return new ModelAndView("editCompose","dto",dto);
	}
	
	@RequestMapping(value="/changePass",method=RequestMethod.POST)
	public String changePass(@ModelAttribute User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req) {

		System.out.println("inside controller");
		ms.changePass(ui,res,session,req);
		return "login";
	}
	
	@RequestMapping(value="/forget",method=RequestMethod.POST)
	public String forget(@ModelAttribute User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req) {

		System.out.println("inside controller");
		boolean b=ms.forget1(ui,res,session,req);
		if (b) {
			return "login";
		} else {
			return "forget";
		}
	}
	@RequestMapping("/showInbox")
	public ModelAndView showInbox(@RequestParam int id){
		Mail_Info dto=ms.showinbox(id);
		if(dto!=null){
		return new ModelAndView("showInbox","dto",dto);
		}else{
			return new ModelAndView();
		}
	}
	
	
	@RequestMapping("/showSent")
	public ModelAndView showSent(@RequestParam int id){
		Mail_Info dto=ms.showSent(id);
		if(dto!=null){
		return new ModelAndView("showSent","dto",dto);
		}else{
			return new ModelAndView();
		}
	}
	@RequestMapping("/permaDel")
	public ModelAndView permaDel(@RequestParam int id)
	{
		boolean b=ms.permDel(id);
		if(b){
			return new ModelAndView("menu","msg","permanent delete succeefully");
		}
		else{
			return new ModelAndView("menu","msg","permanent not delete succeefully");
		}
		
	}

	
	
}