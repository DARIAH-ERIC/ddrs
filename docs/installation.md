## Installation (todo: not finished - to provide our scripts ?)
### Prerequisites
Java (1.8.0  or newer)\
Postgresql Server (8.4 or newer)\
Maven (3.3.x or newer)

### Database (names, users and passwords should be changed on servers)
Create a database called *ddrs* which will work with UTF8:\
*CREATE DATABASE ddrs WITH ENCODING "UTF8";*\
\
Create a user called *ddrs_user* with a password *ddrs_pwd*:\
*CREATE USER ddrs_user WITH PASSWORD "ddrs_pwd";*\
\
Grants privileges to this user on this database:\
*GRANT ALL PRIVILEGES ON DATABASE "ddrs" TO ddrs_user;*

### Create executable
mvn clean package

### Extra files
Installation of the tool is made in /opt/ddrs/:\
Copy the executable to the installation repertory

Create a file ddrs.conf, that will contains this line in order to let the init.d script use extra property files for your server.\
*RUN_ARGS=-Dspring.config.location=/opt/ddrs/*

Create an extra property file *application.properties* in /opt/ddrs/ to override any special properties of the tool (as database usernames, passwords or application context).

Create a symbolic link (ln -s) from /opt/ddrs/ddrs.jar to /etc/init.d/ddrs to be able to launch the tool as a service (usable for centos 6.x servers).