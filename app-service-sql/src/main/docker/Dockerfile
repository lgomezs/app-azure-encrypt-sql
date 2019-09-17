FROM openjdk:8-jre-alpine

VOLUME /tmp
ADD target/appencryptsql-*.jar app.jar

CMD exec java -Duser.timezone=America/Lima -jar app.jar