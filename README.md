# Serverless IP Weather & Location Status Page with Spring
## Demo Project for Online Stream #2 (English)

Application is build with Spring Boot.

It runs live on AWS Lambda and is accessible via API Gateway at this URL: https://bit.ly/ip-wth-loc-spring

## Access to Online Stream

You can view the online stream on YouTube after making a donation to support my 
volunteering initiative to help Ukrainian Armed Forces.

:coffee: Please, visit the [Buy Me a Coffee](https://www.buymeacoffee.com/ytkach/e/214224).

Thank you in advance for your support! Слава Україні! :ukraine:

## Running the application in dev mode

You can run your application locally coding using:
```shell script
./mvnw spring-boot:run
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `demo-2-en-status-page-spring-0.0.1-SNAPSHOT-aws.jar` file in the `target` directory.

The application, packaged as an _über-jar_, is now deployable to AWS Lambda.
