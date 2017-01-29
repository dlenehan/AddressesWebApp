package com.deirdre.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deirdre.dao.ContactDAO;
import com.deirdre.model.Contact;

@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/contact.jsp";
	private static String LIST_CONTACT = "/listContact.jsp";
	private ContactDAO dao;
	
	
public ContactController() {
	super();
	dao = new ContactDAO();
}
	


@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String forward="";
    String action = request.getParameter("action");

    if (action.equalsIgnoreCase("delete")){
        int userId = Integer.parseInt(request.getParameter("userId"));
        dao.deleteContact(userId);
        forward = LIST_CONTACT;
        request.setAttribute("contacts", dao.getAllContacts());    
    } else if (action.equalsIgnoreCase("edit")){
        forward = INSERT_OR_EDIT;
        int userId = Integer.parseInt(request.getParameter("userId"));
        Contact contact = dao.getContactById(userId);
        request.setAttribute("contact", contact);
    } else if (action.equalsIgnoreCase("listContact")){
        forward = LIST_CONTACT;
        request.setAttribute("contacts", dao.getAllContacts());
    } else {
        forward = INSERT_OR_EDIT;
    }

    RequestDispatcher view = request.getRequestDispatcher(forward);
    view.forward(request, response);
}




protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Contact contact = new Contact();
	contact.setFirstname(request.getParameter("firstname"));
	contact.setLastname(request.getParameter("lastname"));
	contact.setDob(request.getParameter("dob"));
    contact.setEmail(request.getParameter("email"));
    String userid = request.getParameter("userid");
    if (userid == null ||	userid.isEmpty())
    {
    	dao.addContact(contact);
    }
    else
    {
    	contact.setUserid(Integer.parseInt(userid));
    	dao.updateContact(contact);
    }
    
    RequestDispatcher view = request.getRequestDispatcher(LIST_CONTACT);
    request.setAttribute("contacts",dao.getAllContacts());
    view.forward(request, response);
    }
}
	


	
	