package org.jb.grpc.client;

import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.jb.grpc.Person;
import org.jb.grpc.PersonDetails;
import org.jb.grpc.PersonServiceGrpc;

@Component
public class GrpcClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private PersonServiceGrpc.PersonServiceBlockingStub personServiceBlockingStub;

  //localhost
  @Value("${grpc.host}")
  private String grpcServer;

  //6565
  @Value("${grpc.port}")
  private int grpcPort;
  
  @PostConstruct
  private void init() {
	LOGGER.info("--- Initialize gRPC channel to {} : {}", grpcServer, grpcPort);
    //ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(grpcServer, grpcPort).usePlaintext().build();
    personServiceBlockingStub = PersonServiceGrpc.newBlockingStub(managedChannel);
  }

  public PersonDetails getDetails(long id, String name) {
//    long id = Long.valueOf(RandomStringUtils.randomNumeric(1,5));
//    String name = RandomStringUtils.randomAlphanumeric(5, 10);

    Person person = Person.newBuilder().setId(id).setName(name).build();
    //LOGGER.info("client sending {}", person);

    PersonDetails details = personServiceBlockingStub.getPersonDetails(person);
    //LOGGER.info("client received {}", greeting);

    return details;
  }
}
