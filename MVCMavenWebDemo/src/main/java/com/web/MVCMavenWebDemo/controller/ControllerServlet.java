package com.web.MVCMavenWebDemo.controller;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.web.MVCMavenWebDemo.dao.UserDao;
import com.web.MVCMavenWebDemo.dao.UserDaoImpl;
import com.web.MVCMavenWebDemo.model.UserModel;
 

//@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	final Logger logger = Logger.getLogger(ControllerServlet.class);
	
	public void init() {
		userDao = new UserDaoImpl();
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    //	this.doGet(request, response);

    	BasicConfigurator.configure();
    	logger.setLevel(Level.ALL);
    //	logger.info("doGet Method Started");
    //	PropertyConfigurator.configure("log4j.properties");
    	logger.debug("doGet Method Started");
    	
    	
/*        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        int id = Integer.parseInt(request.getParameter("id"));  
          
        UserModel bean=new UserModel();  
        bean.setId(id);  
        bean.setName(name);  
        request.setAttribute("bean",bean);  

        
        RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");  
        rd.forward(request, response);  */
        
        String action =request.getServletPath();
        
        switch(action) {
        case "/new":
        	showNewForm(request, response);
        	break;
        case "/insert":
        	try {
				insertUser(request, response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
        	break;
        case "/delete":
        	try {
				deleteUser(request, response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
        	break;
        case "/edit":
        	try {
				showEditForm(request, response);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        case "/update":
        	try {
				updateUser(request, response);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        case "/list":
        	try {
				listUser(request, response);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        default:
        	try {
				listUser(request, response);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        }
        
   
        logger.info("doGet Method Completed..");
      
    }  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        try {
			doPost(req, resp);
		} catch (ServletException | IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
    

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws IOException,  ServletException {
    	RequestDispatcher rd=req.getRequestDispatcher("user-form.jsp");
    	rd.forward(req, resp);
    }
    
    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
    //	int id = Integer.parseInt(req.getParameter("id"));
    	String name = req.getParameter("name");
    	UserModel user = new UserModel( name);
    	userDao.insertUser(user);
    	System.out.println(user);
    	resp.sendRedirect("list");
    }
    
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
    	int id = Integer.parseInt(req.getParameter("id"));
    	userDao.deleteUser(id);
    	resp.sendRedirect("list");
    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
    	int id = Integer.parseInt(req.getParameter("id"));
    	UserModel existingUser = userDao.selectUser(id);
    	System.out.println("Here is the "+existingUser);
    	RequestDispatcher rd=req.getRequestDispatcher("edit-form.jsp");
    	req.setAttribute("user", existingUser);
    	rd.forward(req, resp);
    }
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
    	int id = Integer.parseInt(req.getParameter("id"));
    	String name = req.getParameter("name");
    	UserModel user = new UserModel(id, name);
    	userDao.updateUser(user);
    	resp.sendRedirect("list");
    }
    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
    	List<UserModel> listUser = userDao.selectAllUser();
    	req.setAttribute("listUser", listUser);
    //	System.out.println(listUser);
    	RequestDispatcher rd=req.getRequestDispatcher("user_List.jsp");
    	rd.forward(req, resp);
    }
}
