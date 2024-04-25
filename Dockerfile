FROM eclipse-temurin:22-jre-alpine

WORKDIR /usr/src/app

COPY consumer/target/consumer-1.0-SNAPSHOT.jar appconsumer.jar
COPY provider/target/provider-1.0-SNAPSHOT.jar appprovider.jar
COPY service/target/service-1.0-SNAPSHOT.jar appservice.jar

ENTRYPOINT ["java","--module-path","/usr/src/app","--module","se.iths.consumer/se.iths.consumer.Main"]