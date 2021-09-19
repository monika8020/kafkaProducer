FROM openjdk:8
ADD target/docker-spring-boot.jar docker-spring-boot.jar
Expose 8085
ENTRYPOINT ["Java", "-jar" ,"docker-spring-boot.jar"]