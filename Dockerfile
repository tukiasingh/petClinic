# Base Image JDK
FROM openjdk:17

# Create a directory by the name of PetClinicApp
RUN mkdir /app

COPY target/ /app

WORKDIR /app

# Lets create an argument which conatins the jar file path
#ARG JAR_FILE=target/*.jar

# copy jar file as petClinic.jar
#COPY ${JAR_FILE} petClinic.jar

#Execute the java command -> java PetClinicApp
CMD ["java", "-jar", "petclinic-0.0.1-SNAPSHOT.jar"]
