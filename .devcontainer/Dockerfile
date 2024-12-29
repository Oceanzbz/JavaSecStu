# 基础镜像，使用官方的 Ubuntu 镜像
FROM ubuntu:20.04

# 设置时区环境变量并避免用户交互
ENV DEBIAN_FRONTEND=noninteractive
ENV TZ=Etc/UTC

# 更新软件包并安装必要的工具
RUN apt-get update && apt-get install -y \
    software-properties-common \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg2 \
    lsb-release

# 添加 OpenJDK PPA 并安装 OpenJDK 8
RUN add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \
    apt-get install -y openjdk-8-jdk

# 设置 JAVA_HOME 环境变量
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# 安装 Maven
RUN apt-get install -y maven

# 安装 Tomcat
RUN apt-get install -y wget && \
    wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.65/bin/apache-tomcat-9.0.65.tar.gz -O /tmp/tomcat.tar.gz && \
    tar xzvf /tmp/tomcat.tar.gz -C /opt && \
    mv /opt/apache-tomcat-9.0.65 /opt/tomcat && \
    rm /tmp/tomcat.tar.gz

# 设置 Tomcat 环境变量
ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$CATALINA_HOME/bin:$PATH

# 暴露 Tomcat 的默认端口
EXPOSE 8080

# 复制项目代码到容器中
WORKDIR /workspace
COPY . /workspace

# 启动 Tomcat
CMD ["catalina.sh", "run"]

