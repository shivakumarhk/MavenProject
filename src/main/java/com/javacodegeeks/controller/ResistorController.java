package com.javacodegeeks.controller;

//import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shiva.model.UserDetails;


@Controller
public class ResistorController {
	
	
@RequestMapping(value="/",method=RequestMethod.GET)
public String userWellcome(ModelMap model) {
	
	model.addAttribute("msg", "Enter Details For Registor");
	
	
	 return "registor";
}

@RequestMapping(value="/registor",method=RequestMethod.POST)
public String addUser(Model model,@ModelAttribute("userDetails") UserDetails userDetails ) {
		
	String url = "jdbc:postgresql://localhost:5432/postgres";
    String user1 = "postgres";
    String password = "newpass";
    
    Connection con=null;
    
    if(userDetails.getFirstName().length()!=0) {
    
    String query="INSERT INTO user_details(first_name,last_name,email_id,dob,user_pass) VALUES(?,?,?,?,?)";
    try {
		Class.forName("org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
		
        System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
		e.printStackTrace();
	}
    try {
		con = DriverManager.getConnection(url, user1, password);
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, userDetails.getFirstName());
		pst.setString(2, userDetails.getLastName());
		pst.setString(3, userDetails.getEmail());
		pst.setString(4, userDetails.getDob());
		pst.setString(5, userDetails.getPass());
		
		pst.executeUpdate();
		
		if(pst !=null) {
			model.addAttribute("useAdd", "User Added SuccesFully");
			return "newsuccess";
		}		
		else {
	        model.addAttribute("error", "Please Enter valid Details");
	        return "registor";

		}
    }catch (SQLException e) {
		// TODO: handle exception
    	e.printStackTrace();
    	
	}}
    else {
        model.addAttribute("error", "Enter Please Enter All Details");
        return "registor";

	}
	
	 return "registor";
}


@RequestMapping(value="/useractivelist",method=RequestMethod.GET)
public String getUser(Model model ) {
		
	String url = "jdbc:postgresql://localhost:5432/postgres";
    String user1 = "postgres";
    String password = "newpass";
    
    Connection con=null;
   // List list = new List();
    Statement pst = null;
  //  ArrayList<String>  wholeList=null;
    
   
        String query=null;

    try {
		Class.forName("org.postgresql.Driver");
		
		} catch (ClassNotFoundException e) {
		
        System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
		e.printStackTrace();
	}
    try {
    	  query = "SELECT id,first_name,last_name,email_id,dob FROM user_details";
    	  
		con = DriverManager.getConnection(url, user1, password);
		
	
		
		pst = con.createStatement();
		 ResultSet resultSet=  pst.executeQuery(query);
		 ResultSetMetaData rsmd = resultSet.getMetaData(); 
		 int columnCount = rsmd.getColumnCount();
		 System.out.println(columnCount);
		// wholeList = new ArrayList<String>();
		 String str1 = "";
		 int i = 1;
		while(resultSet.next()) {
			
			
			
				
				 //System.out.println(resultSet.getString("first_name"));
				 str1+= "</tr><td>"+i+"</td>"+
				 "<td>"+resultSet.getString("first_name")+"</td>"+
				 "<td>"+resultSet.getString("last_name")+"</td>"+
				 "<td>"+resultSet.getString("email_id")+"</td>"+
				 "<td>"+resultSet.getString("dob") +"</td>"+

				 "</tr>";
			i++;
				 
			
			//int i = 1;
			// while(i <= columnCount) {
			
			//wholeList.add(resultSet.getString(i++));
			
			//System.out.println(resultSet.getString("first_name"));
			
			//wholeList.add(i,resultSet.getString("first_name"));
			//System.out.println(i);
			//i++;
			//System.out.println(wholeList);}


		}
		//System.out.println(str1);
		model.addAttribute("list",str1);
		
		
		
    }catch (SQLException e) {
		// TODO: handle exception
    	e.printStackTrace();
    	
	}
	
	 return "userlist";
}


}
