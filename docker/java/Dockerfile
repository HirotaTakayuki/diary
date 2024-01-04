FROM ubuntu:20.04
# 設定ファイルの権限を変更
RUN chmod 644 ../

RUN apt-get update
RUN apt-get -y install openjdk-17-jdk
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH
VOLUME /tmp
RUN mkdir /app
WORKDIR /app