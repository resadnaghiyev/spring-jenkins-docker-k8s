FROM openjdk:11
EXPOSE 8080
ADD target/spring-crud-k8s.jar spring-crud-k8s.jar
ENTRYPOINT ["java","-jar","/spring-crud-k8s.jar"]