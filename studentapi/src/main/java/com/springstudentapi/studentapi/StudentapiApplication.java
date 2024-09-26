package com.springstudentapi.studentapi;
  
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class StudentapiApplication {
 
    private static final Logger logger = LogManager.getLogger(StudentapiApplication.class);
    public static void main(String[] args) {
                 SpringApplication.run(StudentapiApplication.class, args);
    System.out.println( "Hello, user!" ); 
        logger.info("We've just greeted the user!"); 
    }
}
