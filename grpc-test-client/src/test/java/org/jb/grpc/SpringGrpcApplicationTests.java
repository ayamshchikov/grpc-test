package org.jb.grpc;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.jb.grpc.client.GrpcClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringGrpcApplicationTests {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//  @Autowired
//  private HelloWorldClient helloWorldClient;

/*
  @Test
  public void testSayHello() {
    int length = 10;
    boolean useLetters = true;
    boolean useNumbers = false;

    String firstName = RandomStringUtils.random(length, useLetters, useNumbers);
    String lastName = RandomStringUtils.randomAlphabetic(length);

//    String firstName = RandomStringUtils.randomAlphabetic(length);
//    String lastName = RandomStringUtils.randomAlphanumeric(length);

    int msgLimit = 10;
    String response;


    LOGGER.info("===== Sending {} messages to gRPC =====", msgLimit);
    long startTime = System.currentTimeMillis();

    for(int i=0; i<msgLimit; i++) {
      response = helloWorldClient.sayHello(firstName, lastName);
    }
    LOGGER.info("===== Completed in {} sec. =====", ((System.currentTimeMillis()-startTime)/1000F));

    //assertThat(helloWorldClient.sayHello("John", "Doe")).isEqualTo("Hello John Doe!");
  }
*/  
}
