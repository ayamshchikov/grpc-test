package org.jb.grpc;

//import static org.assertj.core.api.Assertions.assertThat;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGrpcApplicationTests {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  private GrpcClient grpcClient;


  @Test
  public void testSayHello() {
    int length = 10000;
    //boolean useLetters = true;
    //boolean useNumbers = false;

    //String firstName = RandomStringUtils.random(length, useLetters, useNumbers);
    String name = RandomStringUtils.randomAlphabetic(length);

    Long id = Long.valueOf(RandomStringUtils.randomNumeric(1, 5));
//    String lastName = RandomStringUtils.randomAlphanumeric(length);

    int msgCount = 10000;
    PersonDetails response;


    LOGGER.info("===== Sending {} messages to gRPC =====", msgCount);
    long startTime = System.currentTimeMillis();

    for(int i=0; i<msgCount; i++) {
      response = grpcClient.getDetails(id, name);
    }
    LOGGER.info("===== Completed in {} sec. =====", ((System.currentTimeMillis()-startTime)/1000F));

    //assertThat(helloWorldClient.sayHello("John", "Doe")).isEqualTo("Hello John Doe!");
  }
  
}
