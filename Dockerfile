FROM frolvlad/alpine-oraclejdk8
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/' /etc/apk/repositories
# 设置时区,ubuntu用下面的 RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
VOLUME /tmp
ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
RUN echo $(date) > /image_built_at
EXPOSE 8281
ENTRYPOINT ["java","-Xmx500m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]