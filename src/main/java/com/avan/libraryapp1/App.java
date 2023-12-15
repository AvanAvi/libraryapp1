package com.avan.libraryapp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

  // Define a static logger variable so that it references the Logger instance
  private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {

    SpringApplication app = new SpringApplication(App.class);
    app.run(args);
    
    // Use the logger to log the message instead of System.out.println
    logger.info("Library App Started!");

  }

}