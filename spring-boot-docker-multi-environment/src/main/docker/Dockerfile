FROM openjdk:11.0.3-jdk-stretch
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
VOLUME /tmp
ADD subject-lib-0.0.1-SNAPSHOT.jar app.jar
# spring.profiles.active指定启动环境
#-c为清除以前启动的数据
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=${profiles}","-c"]








