FROM public.ecr.aws/amazoncorretto/amazoncorretto:17-al2023
WORKDIR /app
COPY ./build/libs/dundie_awards-latest.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "/app/app.jar"]