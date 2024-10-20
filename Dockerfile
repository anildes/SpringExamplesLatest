FROM openjdk:8
ADD target/SpringExamplesLatest.jar SpringExamplesLatest.jar
ENTRYPOINT ["java","-jar","/SpringExamplesLatest.jar"]
