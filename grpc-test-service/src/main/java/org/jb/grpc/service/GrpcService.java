package org.jb.grpc.service;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.RandomStringUtils;

import io.grpc.stub.StreamObserver;

import org.jb.grpc.Person;
import org.jb.grpc.PersonDetails;
import org.jb.grpc.PersonServiceGrpc;

@GRpcService
public class GrpcService extends PersonServiceGrpc.PersonServiceImplBase {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private final AtomicInteger userId = new AtomicInteger(); 

  @Override
  public void getPersonDetails(Person request, StreamObserver<PersonDetails> responseObserver) {
    //LOGGER.info("server received {}", request);

		//RandomStringUtils.random(length, useLetters, useNumbers);
	  
    String address = RandomStringUtils.randomAlphanumeric(10, 20);
    String phone = RandomStringUtils.randomNumeric(10);
    String dob = RandomStringUtils.randomNumeric(8);
    String descr = "Details for : " + request.getName() + " # " + request.getId();
    
    PersonDetails details = PersonDetails.newBuilder().setAddress(address).setPhone(phone).setDateOfBirth(dob).setDescr(descr).build();
    
    //LOGGER.info("server responded {}", greeting);
    //LOGGER.info("server responded ");

    responseObserver.onNext(details);
    responseObserver.onCompleted();
  }
}
