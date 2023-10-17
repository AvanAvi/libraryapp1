package com.avan.libraryapp1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;

import com.avan.libraryapp1.services.BookService;
import com.avan.libraryapp1.repository.BookRepository;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class AppTest {

  @Autowired
  private ApplicationContext context;

  @Test
  public void contextLoads() {

    System.out.println("Loaded Beans:");
    Arrays.stream(context.getBeanDefinitionNames())
      .forEach(name -> System.out.println(name));
    
    assertNotNull(context.getBean(BookService.class));
    assertNotNull(context.getBean(BookRepository.class));

  }

}