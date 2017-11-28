## Installation
### Prerequisites
Java (1.8.0  or newer)\
Postgresql Server (8.4 or newer)\
Maven (3.3.x or newer)

### Where is the installation
Build folder: ```~/ddrs/```\
Install folder: ```/opt/ddrs/```

### Clone repository
In the build folder for DDRS run
```git clone https://github.com/DARIAH-ERIC/ddrs```

### Database (names, users and passwords should be changed on servers)
Create a database called *ddrs* which will work with UTF8:\
*CREATE DATABASE ddrs WITH ENCODING "UTF8";*\
\
Create a user called *ddrs_user* with a password *ddrs_pwd*:\
*CREATE USER ddrs_user WITH PASSWORD "ddrs_pwd";*\
\
Grants privileges to this user on this database:\
*GRANT ALL PRIVILEGES ON DATABASE "ddrs" TO ddrs_user;*

### Copy and edit the configuration file
Make a copy of the configuration template ``install-files/application.properties``, fill it in with the appropriate data and add it to the install folder.\
You can of course overwrite any of the default properties, such as database connection:
- spring.datasource.url=CHANGE TO YOURS
- spring.datasource.username=CHANGE TO YOURS
- spring.datasource.password=CHANGE TO YOURS

### Extra configuration file
Make a copy of the configuration template ``install-files/ddrs.conf`` and add it to the install folder.\
This is in order to let the init.d script use extra property files for your server.\

### Create executable
In the build folder:\
mvn -Dspring.config.location=file:/opt/ddrs/application.properties clean package

Copy the executable (```.jar```) to the installation folder.

Create a symbolic link (ln -s) from /opt/ddrs/ddrs.jar to /etc/init.d/ddrs to be able to launch the tool as a service (usable for centos 6.x servers).

### Start the service
```service ddrs start```\
```service httpd restart```

The server should now listen on the port 8080 by default:\
```http://localhost:8080/ddrs/```

### Redirect from Apache HTTPD to our own DDRS Service
Here is an example of a conf file for apache httpd using SSL and redirection from the port 443 (SSL) to our application running on port 8080.\
The port 80 is also redirected to 443 and therefore to 8443 when used.

```xml
NameVirtualHost *:80
NameVirtualHost *:443

<VirtualHost *:443>
    SSLEngine on
    SSLProxyEngine On
    SSLCertificateFile /etc/letsencrypt/live/ddrs-dev.dariah.eu/cert.pem
    SSLCertificateKeyFile /etc/letsencrypt/live/ddrs-dev.dariah.eu/privkey.pem
    SSLCertificateChainFile /etc/letsencrypt/live/ddrs-dev.dariah.eu/chain.pem
    ServerName https://ddrs-dev.dariah.eu/
    Redirect / https://ddrs-dev.dariah.eu/ddrs/
    ProxyPass /ddrs/ http://localhost:8080/ddrs/
    ProxyPassReverse /ddrs/ http://localhost:8080/ddrs/
</VirtualHost>
<VirtualHost *:80>
    ServerName http://ddrs-dev.dariah.eu/
    DocumentRoot /var/www/
    ErrorLog /var/log/httpd/ddrs_error_log
    CustomLog /var/log/httpd/ddrs_access_log combined
    Redirect / https://ddrs-dev.dariah.eu/
</VirtualHost>
```