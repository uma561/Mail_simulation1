package com.ust.project.stockmanagement.service;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.ust.project.stockmanagement.model.ModelDTO;
import com.ust.project.stockmanagement.model.OrderDTO;
import com.ust.project.stockmanagement.model.RegistrationDTO;

public interface MyService {
	
	boolean MangerRegistration(RegistrationDTO rdto);

	boolean ManagerLogin(HttpServletRequest req);

	boolean addproduct(ModelDTO mdto);

	List<ModelDTO> allproduct();

	List<ModelDTO> searchproduct(String search,String filter);

	List<ModelDTO> updateproduct(ModelDTO mdto);

	List<ModelDTO> addtocart(ModelDTO mdto);

	List<ModelDTO> cartadded(ModelDTO mdto);

	List<OrderDTO> showCart();
}
