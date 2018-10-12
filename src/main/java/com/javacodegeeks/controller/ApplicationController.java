package com.javacodegeeks.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
//import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import com.shiva.model.User;
import com.shiva.model.UserDetails;
	 

@Controller

// @RequestMapping("/")
public class ApplicationController {
	 

	@RequestMapping(value="/Test", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
	model.addAttribute("msgArgument", "Maven Java Web Application Project: Success!");

	 
		return "index";

  }	 

	 @RequestMapping(value="/Print/{arg}", method = RequestMethod.GET)	
	 public String welcomeName(@PathVariable String arg, ModelMap model) {	
	
		 model.addAttribute("msgArgument", "Maven Java Web Application Project: " + arg);
	 
	 	return "index";

  }
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String home(Locale locale, ModelMap model) {
		
			Date date = new Date();
			
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

			String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate);

			return "login";
			
 }

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
        String user1 = "postgres";
        String password = "newpass";
        String name=null;
        Connection con=null;
        
        String query = "SELECT employee_id, first_name FROM employees";
        
            try {
				Class.forName("org.postgresql.Driver");
				
				} catch (ClassNotFoundException e) {
				
		        System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
				e.printStackTrace();
			}
        	
			try {
				con = DriverManager.getConnection(url, user1, password);
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(": ");
					name=rs.getString(2);
					System.out.println(rs.getString(2));
				
				}
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {}
				}
			}
		        	
			model.addAttribute("userName",name);
		  		
				return "user";
}
	
	
	
	  @RequestMapping(value = "/newlogin", method = RequestMethod.GET)
	  public String init(Model model) {
	    model.addAttribute("msg", "Please Enter Your Login Details");
	    return "newlogin";
	  }
	  
	  
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("userDetails") UserDetails userDetails ) {
		  	
		  	String url = "jdbc:postgresql://localhost:5432/postgres";
	        String user1 = "postgres";
	        String password = "newpass";
	        //String name=null;
	        Connection con= null;
	        
	        
            try {
				Class.forName("org.postgresql.Driver");
				
				} catch (ClassNotFoundException e) {
				
		        System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
				e.printStackTrace();
			}	
            
            try {
				con = DriverManager.getConnection(url, user1, password);
		        PreparedStatement pst = con.prepareStatement("select * from user_details where first_name = ? and user_pass = ?");    
		        
		        pst.setString(1, userDetails.getFirstName());   
		        pst.setString(2, userDetails.getPass());   
		        
		       // System.out.println(userDetails.getFirstName());
		      //  System.out.println(userDetails.getPass());
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					
			    model.addAttribute("msg", "Wellcome "+"<font color=\"637472\"><b>"+userDetails.getFirstName()+"</b></font>");
			      return "newsuccess";
					
				}else {
					
			        model.addAttribute("error", "Invalid Details");
			        return "newlogin";
			      }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {}
				}
			}
    	  
	  return "newlogin";
	  
//	    if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
//      if (loginBean.getUserName().equals("shiva") && loginBean.getPassword().equals("123")) {
//    	  
//    	  System.out.println(loginBean.getUserName());
//    	  model.addAttribute("msg", loginBean.getUserName()+" Wellcome");
//        return "newsuccess";
//      } else {
//    	  System.out.println(loginBean.getUserName());
//        model.addAttribute("error", "Invalid Details");
//        return "newlogin";
//      }
//    } else {
//      model.addAttribute("error", "Please enter Details");
//      return "newlogin";
//    }
	
}
}

	
//	public static Properties readProperties() {
//
//        Properties props = new Properties();
//        Path myPath = Paths.get("src/main/resources/database.properties");
//        System.out.println(myPath);
//        
//        try {
//            BufferedReader bf = Files.newBufferedReader(myPath, 
//                StandardCharsets.UTF_8);
//
//            props.load(bf);
//        } catch (IOException ex) {
//        	ex.getMessage();
//        }
//        System.out.println(props);
//
//        return props;
//    }
//	
//	
	
	
	
//	 public static void main(String[] args) {
//
//	        Properties props = readProperties();
//
//	        String url = props.getProperty("db.url");
//	        String user = props.getProperty("db.user");
//	        String passwd = props.getProperty("db.passwd");
//
//	        	Connection con;
//				try {
//					con = DriverManager.getConnection(url, user, passwd);
//					 PreparedStatement pst = con.prepareStatement("SELECT * FROM Authors");
//		                ResultSet rs = pst.executeQuery();
//		                
//		                while (rs.next()) {
//			                System.out.print(rs.getInt(1));
//			                System.out.print(": ");
//			                System.out.println(rs.getString(2));
//			            }    
//				
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        		
//		            
//	                }

	    



