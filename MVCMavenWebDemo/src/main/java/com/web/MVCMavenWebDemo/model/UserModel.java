package com.web.MVCMavenWebDemo.model;

public class UserModel {
	
	private int id;
	private String name;
	
	public UserModel() {
		
	} 
	public UserModel(String name) {
		this.name = name;
	} 
	public UserModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}
	@Override
	public String toString() {
		return "ModelBean [id=" + id + ", name=" + name + "]";
	}  
	
	
/*	public boolean validate(){  
	    if(id>0){  
	        return true;  
	    }  
	    else{  
	        return false;  
	    }  
	}  */


}
