package org.jb.grpc;

//import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
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
    //boolean useLetters = true;
    //boolean useNumbers = false;
    //String firstName = RandomStringUtils.random(length, useLetters, useNumbers);

    int size = 10000;
    int msgCount = 10000;
    PersonDetails response;

    Long id;
    String name;
    
    LOGGER.info("===== Sending {} messages to gRPC (size: {}) =====", msgCount, size);
    long startTime = System.currentTimeMillis();

    for(int i=0; i<msgCount; i++) {
      id = Long.valueOf(RandomStringUtils.randomNumeric(1, 5));
      name = RandomStringUtils.randomAlphabetic(size);
      response = grpcClient.getDetails(id, name);
    }
    LOGGER.info("===== Completed in {} sec. =====", ((System.currentTimeMillis()-startTime)/1000F));

    //assertThat(StringUtils.startsWith(response.getDescr(), "Details for : "));
  }
  
}
