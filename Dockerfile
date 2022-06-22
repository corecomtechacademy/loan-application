# Install Maven container
FROM maven:3.6.1-jdk-11

LABEL creator="Rajan Aggarwal <rajan.aggarwal@ten10.com> & Nathanial Sydenham <nathanial.sydenham@ten10.com>"

# Update package list and download dependencies
RUN apt-get update && apt-get install -y git \
    mysql-server \
    mysql-client \
    dos2unix

# Set up MySQL and add springboot user as per springboot configuration
RUN service mysql start \
    && mysql -uroot -e 'USE mysql; CREATE USER "springuser" IDENTIFIED BY "ThePassword"; CREATE database db_loanapp; grant all on db_loanapp.* to "springuser";'

# Copy project files into image
COPY . /project/loan-application

# Build Maven Project
WORKDIR /project/loan-application
RUN mvn package

# Set scripts as the directory to convert sh script to linux line-endings
WORKDIR /project/loan-application/scripts
RUN dos2unix run-springboot.sh
RUN chmod +x run-springboot.sh

WORKDIR /project/loan-application
ENTRYPOINT [ "/project/loan-application/scripts/run-springboot.sh" ]