#FROM openjdk:8-jdk-alpine
#ENV APP_FILE studymama-0.0.1-SNAPSHOT.jar
#ENV APP_HOME /usr/app
#COPY target/$APP_FILE $APP_HOME/
#WORKDIR $APP_HOME
#ENTRYPOINT ["sh", "-c"]
#CMD ["exec java -jar $APP_FILE"]

#FROM    maven:3.6.0-jdk-8 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package

#FROM openjdk:8-jdk-alpine
#COPY --from=build /home/app/target/studymama-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM maven:3.6-jdk-8 AS build  
#COPY src /usr/src/app/src  
#COPY pom.xml /usr/src/app  
#RUN mvn -f /usr/src/app/pom.xml clean install -U -DskipTests

FROM gcr.io/distroless/java  
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080  
ENTRYPOINT ["java","-jar","app.jar"]