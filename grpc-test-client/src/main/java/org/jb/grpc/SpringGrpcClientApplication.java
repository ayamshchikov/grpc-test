package org.jb.grpc;

import java.lang.invoke.MethodHandles;

import org.apache.commons.lang3.RandomStringUtils;
import org.jb.grpc.client.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringGrpcClientApplication implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  private GrpcClient grpcClient;

  @Value("${message.count}")
  private int msgCount;

  @Value("${message.size}")
  private int msgSize;

  public static void main(String[] args) {
    SpringApplication.run(SpringGrpcClientApplication.class, args);
  }
  
  @Override
  public void run(String... args) throws Exception {
	  LOGGER.info("===== Start GRPC client =====");
	  sendGrpcMsg(msgCount, msgSize);
  }
  
  
  private void sendGrpcMsg(int msgCount, int msgSize) {
    PersonDetails response;

    Long id;
    String name;
    
    LOGGER.info("===== Sending {} messages to gRPC (size: {}) =====", msgCount, msgSize);
    long startTime = System.currentTimeMillis();

    for(int i=0; i<msgCount; i++) {
      id = Long.valueOf(RandomStringUtils.randomNumeric(1, 5));
      name = RandomStringUtils.randomAlphabetic(msgSize);
      response = grpcClient.getDetails(id, name);
    }
    LOGGER.info("===== Completed in {} sec. =====", ((System.currentTimeMillis()-startTime)/1000F));

  }
  
}
