#FROM xqdocker/ubuntu-oracle-java
#FROM jamesbusyqa/alpinejavamysql

# (1) add user "new user" have to use sudo to excute startup.sh, but no sudo there
#RUN apk --update add bash wget dpkg-dev sudo
#RUN addgroup -S myawesomegroup
#RUN adduser -S myawesomeuser -G myawesomegroup sudo
#USER myawesomeuser

#RUN adduser -D user
#RUN usermod -a -G sudo user
#USER user

# (2) mysql, tow service must integrate in the shell
#WORKDIR /app
#VOLUME /app
#COPY startup.sh /startup.sh
#RUN apk --update add mysql mysql-client && rm -f /var/cache/apk/*
#COPY my.cnf /etc/mysql/my.cnf
#EXPOSE 3306
#CMD ["/startup.sh"]


################################################################
FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]



#CMD java -jar /app.jar
