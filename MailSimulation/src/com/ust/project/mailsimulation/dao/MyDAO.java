package com.ust.project.mailsimulation.dao;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ust.project.mailsimulation.model.Mail_Info;
import com.ust.project.mailsimulation.model.User_Info;




public interface MyDAO {
	public void register(User_Info ui);
	public User_Info login(User_Info ui);
	public boolean compose(HttpServletRequest req);
	List<Mail_Info> getdraft();
	List<Mail_Info> sentmail();
	List<Mail_Info> getinbox();

	public boolean changePass(User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req);
    public boolean delete(int id);
    public List<Mail_Info> getdeletemessage();
    public Mail_Info showinbox(int id);
    public Mail_Info showSent(int id);
   public boolean editCompose(HttpServletRequest req);
    public boolean forget1(User_Info ui,HttpServletResponse res,HttpSession session,HttpServletRequest req);
   public Mail_Info composeEdit(int id);
    public boolean permDel(int id);
    
}
