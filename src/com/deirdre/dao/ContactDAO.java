package com.deirdre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.deirdre.model.Contact;
import com.deirdre.utils.DBConnection;


public class ContactDAO {
	
	private Connection connection;
	
	public ContactDAO(){
		connection = DBConnection.getConnection();
		
	}

	
	public void addContact(Contact contact){
		try{
		PreparedStatement preparedStatement = connection.prepareStatement("insert into contacts(firstname, lastname, dob, email) values (?,?,?,?)");
		preparedStatement.setString(1,contact.getFirstname());
		preparedStatement.setString(2,contact.getLastname());
		preparedStatement.setString(3,contact.getDob());
		preparedStatement.setString(4,contact.getEmail());
		preparedStatement.executeUpdate();
	}catch (SQLException e){
		e.printStackTrace();
	}
	}
	
	public void deleteContact(int userid){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from contacts where userid = ?");
			preparedStatement.setInt(1,userid);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	public void updateContact(Contact contact){
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("update contacts set firstname=?,lastname =?, dob=?, email=? where userid =?");
			preparedStatement.setString(1,contact.getFirstname());
			preparedStatement.setString(2, contact.getLastname());
			preparedStatement.setString(3, contact.getDob());
			preparedStatement.setString(4, contact.getEmail());
			preparedStatement.setInt(5,contact.getUserid());
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e){
			e.printStackTrace();
			
		}
		
	}
	
	
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		try
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from contacts");
			while (rs.next()){
				Contact contact = new Contact();
				contact.setUserid(rs.getInt("userid"));
				contact.setFirstname(rs.getString("firstname"));
				contact.setLastname(rs.getString("lastname"));
				contact.setDob(rs.getString("dob"));
				contact.setEmail(rs.getString("email"));
				contacts.add(contact);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		
	}	
		
		return contacts;	
	}
	
	
	
	public Contact getContactById(int userId){
		Contact contact = new Contact();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("select * from contacts where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()){
				contact.setUserid(rs.getInt("userId"));
				contact.setFirstname(rs.getString("firstname"));
				contact.setLastname(rs.getString("lastname"));
				contact.setDob(rs.getString("dob"));
				contact.setEmail(rs.getString("email"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return contact;
	}
	
		
	
}
