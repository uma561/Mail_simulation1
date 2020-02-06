package com.ust.project.mailsimulation.dao;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.project.mailsimulation.model.Mail_Info;
import com.ust.project.mailsimulation.model.User_Info;

@Component
public class MyDAOimp1 implements MyDAO {
@Autowired
SessionFactory sf;
@Autowired
HttpSession hn;
HttpServletRequest req;
@Override
public boolean delete(int id) {
	Session ss=sf.openSession();
	Criteria cr=ss.createCriteria(Mail_Info.class);
	cr.add(Restrictions.eq("mid", id));
	
	Mail_Info md=(Mail_Info) cr.uniqueResult();
	if(md!=null){
		md.setMailStatus("delMessage");
		ss.saveOrUpdate(md);
		ss.beginTransaction().commit();
		ss.close();
		return true;
		
		
	}else{
	return false;
	}
}
@Override
public boolean forget1(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
	Session ss=sf.openSession();
	String email=req.getParameter("email");
	String question=req.getParameter("question");
	String answer=req.getParameter("answer");
	String newpas=req.getParameter("newpassword");
	
	
	Criteria cr=ss.createCriteria(User_Info.class);
	cr.add(Restrictions.eq("email", email));
	cr.add(Restrictions.eq("question", question));
	cr.add(Restrictions.eq("answer", answer));
	User_Info udto=(User_Info) cr.uniqueResult();
	
	if(udto!=null){
		udto.setPassword(newpas);
		ss.saveOrUpdate(udto);
		ss.beginTransaction().commit();
		ss.close();
	
		return true;
	}
	else{
	
System.out.println("hel");
return false;
	}

	
	
}
	@Override
public boolean changePass(User_Info ui, HttpServletResponse res, HttpSession session, HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String oldpass=req.getParameter("oldpassword");
		String newpass=req.getParameter("newpassword");
		
		Criteria cr=ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", oldpass));
		User_Info udto=(User_Info) cr.uniqueResult();
		if(udto!=null){
			udto.setPassword(newpass);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else{
		

	return false;
		}
}
	@Override
	public void register(User_Info ui) {
		Session ss=sf.openSession();
		ss.save(ui);
		ss.beginTransaction().commit();
		ss.close();
		
	}
	@Override
	public User_Info login(User_Info ui) {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_Info.class);
	cr.add(Restrictions.eq("username", ui.getUsername()));
	cr.add(Restrictions.eq("password", ui.getPassword()));
	User_Info uui=(User_Info) cr.uniqueResult();
		
		ss.close();
		
			return uui;
			
		
	}
	@Override
	public boolean compose(HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("to");
		String msg=req.getParameter("msg");
		this.hn=req.getSession();
		String sentby=(String) hn.getAttribute("email");
		Mail_Info min=null;
		Criteria cr=ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", to));
		User_Info uinf=(User_Info) cr.uniqueResult();
		
		if(uinf!=null) {
			min=new Mail_Info(); 	
			min.setInbox(msg);
			min.setSent(to);
			min.setSentBy(sentby);
			Criteria cr1=ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", sentby));
			User_Info uin=(User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist1=uin.getMlist();
			mlist1.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
			min=new Mail_Info();
			min.setDraft(to);
			min.setSentBy(sentby);
			min.setDraft_message(msg);
			Criteria cr1=ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", sentby));
			User_Info uin=(User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist=uin.getMlist();
			mlist.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
			ss.close();

			return false;
		}
		
	}
	public List<Mail_Info> getdraft() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sentBy", sentby));
		System.out.println("my em"+sentby);
		cr.add(Restrictions.isNull("sent"));
		cr.add(Restrictions.isNotNull("draft"));
		cr.add(Restrictions.isNotNull("draft_message"));
		List<Mail_Info> mlist=cr.list();
		
		return mlist;
	}  

//@Override
public boolean editCompose(HttpServletRequest req) {
	Session ss=sf.openSession();
	String to=req.getParameter("to");
	String smid=req.getParameter("id");
	int mid=Integer.parseInt(smid);
	String msg=req.getParameter("msg");
	this.hn=req.getSession();
	String sentby=(String) hn.getAttribute("email");
	Mail_Info min=null;
	Criteria cr=ss.createCriteria(User_Info.class);
	//cr.add(Restrictions.eq("uid", mid));
	cr.add(Restrictions.eq("email", to));
	User_Info uinf=(User_Info) cr.uniqueResult();
System.out.println(mid);
	Mail_Info mdto=ss.load(Mail_Info.class, mid);
	
	
	if(uinf!=null) {
		 
		mdto.setInbox(msg);
		mdto.setSent(to);
		mdto.setSentBy(sentby);
		mdto.setDraft(null);
	
		List<Mail_Info> mlist1=uinf.getMlist();
		mlist1.add(mdto);
		ss.update(uinf);
		ss.beginTransaction().commit();
		ss.close();
		return true;
	}else {
		mdto.setInbox(msg);
		mdto.setSent(to);
		mdto.setSentBy(sentby);
		mdto.setDraft(msg);
		Criteria cr2=ss.createCriteria(User_Info.class);
		cr2.add(Restrictions.eq("email", sentby));
		User_Info uin=(User_Info) cr2.uniqueResult();
		List<Mail_Info> mlist=uin.getMlist();
		mlist.add(min);
		ss.saveOrUpdate(uin);
		ss.beginTransaction().commit();
		ss.close();

		return false;
	}
	}
	@Override
	public List<Mail_Info> sentmail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sentBy", sentby));
		cr.add(Restrictions.isNotNull("sent"));
		cr.add(Restrictions.isNull("draft"));  
		cr.add(Restrictions.isNull("mailStatus"));
		//User_Info uin=(User_Info) cr.uniqueResult();
		
		List<Mail_Info> mlist=cr.list();
		return mlist;
	}
	@Override
	public List<Mail_Info> getinbox() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sent", sentby));
		cr.add(Restrictions.eq("sent", sentby));
		cr.add(Restrictions.isNull("mailStatus"));
		
		
		List<Mail_Info> mlist=cr.list();
		return mlist;
	}
	
	@Override
	public List<Mail_Info> getdeletemessage() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sent", sentby));
		cr.add(Restrictions.eq("sent", sentby));
		cr.add(Restrictions.eq("mailStatus", "delMessage"));
		List<Mail_Info> mlist=cr.list();
		return mlist;
		
		
	}
	
	@Override
	public Mail_Info showinbox(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info m=(Mail_Info)cr.uniqueResult();
		return m;
		
		
	}
	@Override
	public Mail_Info showSent(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info m=(Mail_Info) cr.uniqueResult();
		return m;
	}
@Override
	public Mail_Info composeEdit(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info dto=(Mail_Info) cr.uniqueResult();System.out.println(dto.getDraft_message());
		return dto;
	}
	@Override
	public boolean permDel(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info mdto =(Mail_Info)cr.uniqueResult();
		if(mdto!=null)
		{
			ss.save(mdto);
			ss.delete(mdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else
		return false;
	}
	


		
		

	}
	

	



