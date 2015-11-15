package es.juansicilia.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class EntityManagerUtil
{
	
   final static Logger logger = Logger.getLogger(EntityManagerUtil.class);
   
   public static EntityManagerFactory getEntityManagerFactory() {                                  
       
	   EntityManagerFactory emf = null;
	   try{
		   Map<String, String> dbProps = new HashMap<String, String>();        
	       Properties props = new Properties();
	       props.load(new FileInputStream("src/main/resources/configuration/database.properties"));                                                                              
	       dbProps.put("javax.persistence.jdbc.url",                                
	               props.getProperty("bd.connection.url").toString());   
	       dbProps.put("javax.persistence.jdbc.user",                                
	               props.getProperty("bd.connection.user").toString());  
	       dbProps.put("javax.persistence.jdbc.password",                                
	               props.getProperty("bd.connection.password").toString());                                                                       
	       emf = Persistence.createEntityManagerFactory("hibernate",dbProps);
	   }catch(Exception e){
			  logger.error("Error creating EntityManager",e);
	   }
       return emf;
  }
}