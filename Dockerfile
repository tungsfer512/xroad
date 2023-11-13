FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies
RUN apt update
RUN apt upgrade -y
RUN apt install -y sudo curl nano wget git
RUN sudo apt-get install -y openjdk-11-jdk
RUN sudo apt-get install -y build-essential
RUN sudo apt-get install -y apt-transport-https
RUN sudo apt-get install -y ca-certificates
RUN sudo apt-get install -y software-properties-common
RUN sudo apt-get install -y dh-make
RUN sudo apt-get install -y devscripts
RUN curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
RUN sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
RUN apt-cache policy docker-ce
RUN sudo apt install -y docker-ce
RUN sudo apt update

RUN git clone https://github.com/nordic-institute/X-Road.git
RUN apt-get install -y openssh-server
RUN echo 'root:root' | chpasswd
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/g' /etc/ssh/sshd_config
RUN service ssh start
EXPOSE 22
CMD ["/usr/sbin/sshd","-D"]