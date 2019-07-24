GRPC Test client

to compile and run Junit:
mvn test

to compile and package without running Junit:
mvn clean package -Dmaven.test.skip=true



to run (will read parameters from config\application.yml and execurte main method):
java -jar target\grpc-test-client-1.0.jar