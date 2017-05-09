FROM java:8-jdk
VOLUME /tmp
ADD target/admin-dashboard-0.0.1-SNAPSHOT.jar admin-dashboard.jar
RUN sh -c 'touch /admin-dashboard.jar'
EXPOSE 8040
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar admin-dashboard.jar" ]
