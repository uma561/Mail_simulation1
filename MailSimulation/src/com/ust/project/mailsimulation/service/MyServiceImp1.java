package com.ust.project.mailsimulation.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.ust.project.mailsimulation.dao.MyDAO;
import com.ust.project.mailsimulation.model.Mail_Info;
import com.ust.project.mailsimulation.model.User_Info;



@Component
public class MyServiceImp1 implements MyService {
	@Autowired
	MyDAO md;
	
	
	
	
	@Override
	public Mail_Info showSent(int id) {
		Mail_Info m=md.showSent(id);
		return m;
	}
	@Override
	public Mail_Info showinbox(int id) {
		Mail_Info m=md.showinbox(id);
		return m;
	}
	@Override
	public List<Mail_Info> getdeletemessage() {
		List<Mail_Info > m=md.getdeletemessage();
		return m;
	}
	@Override
	
	public boolean delete(int id) {
		boolean b=md.delete(id);
		return b;
	}
	@Override
	public boolean forget1(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		boolean b=md.forget1(ui, res, session, req);
		return b;
	}
	@Override
	public boolean changePass(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		md.changePass(ui, res, session, req);
		return false;
	}
	@Override
	public void register(User_Info ui) {

		System.out.println("inside service");
		md.register(ui);
	}
	@Override
	public User_Info login(User_Info ui) {
		System.out.println("inside service");
		User_Info b=md.login(ui);
	return b;
	}
//	@Override
//	public List<Mail_Info> getinbox() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public boolean compose(HttpServletRequest req) {
		
		return md.compose(req);
	}
	
	
	
@Override
	public boolean editCompose(HttpServletRequest req) {
		boolean b=md.editCompose(req);
		return b;
}
	@Override
	public List<Mail_Info> getdraft() {
		List<Mail_Info> mlist=md.getdraft();
		return mlist;
	}
	@Override
	public List<Mail_Info> sentmail() {
		List<Mail_Info> mlist=md.sentmail();
		return mlist;
	}
	@Override
	public List<Mail_Info> getinbox() {
		List<Mail_Info> mlist=md.getinbox();
		return mlist;
	}
	
	@Override
	public Mail_Info composeEdit(int id) {
		
		return md.composeEdit(id);
	}
	@Override
	public boolean permDel(int id) {
		
		return md.permDel(id);
	}
	
}
