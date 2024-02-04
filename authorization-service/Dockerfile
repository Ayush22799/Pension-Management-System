FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD "target/auth-service.jar" "auth-service.jar"
ENTRYPOINT [ "java", "-jar", "/auth-service.jar" ]