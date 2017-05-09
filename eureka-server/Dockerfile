FROM java:8-jdk
VOLUME /tmp
ADD target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
RUN sh -c 'touch /eureka-server.jar'
EXPOSE 8010
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar eureka-server.jar" ]
