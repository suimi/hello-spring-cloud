FROM java:8-jdk
VOLUME /tmp
ADD target/service-a-0.0.1-SNAPSHOT.jar service-a.jar
RUN sh -c 'touch /service-a.jar'
EXPOSE 8020
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar service-a.jar" ]
