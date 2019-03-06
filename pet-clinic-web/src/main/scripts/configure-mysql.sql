## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name dev-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -v "/d/docker/docker toolbox":/d/docker/mysql -p 3306:3306 -d mysql
# connect to mysql and run as root user
#Create Databases for My Pet Clinic (Dev environment, Prod environment)
CREATE DATABASE mpc_dev;
CREATE DATABASE mpc_prod;

#Create database service accounts
CREATE USER 'mpc_dev_user'@'localhost' IDENTIFIED BY 'mpc';
CREATE USER 'mpc_prod_user'@'localhost' IDENTIFIED BY 'mpc';
CREATE USER 'mpc_dev_user'@'%' IDENTIFIED BY 'mpc';
CREATE USER 'mpc_prod_user'@'%' IDENTIFIED BY 'mpc';

#Database grants
GRANT SELECT ON mpc_dev.* to 'mpc_dev_user'@'localhost';
GRANT INSERT ON mpc_dev.* to 'mpc_dev_user'@'localhost';
GRANT DELETE ON mpc_dev.* to 'mpc_dev_user'@'localhost';
GRANT UPDATE ON mpc_dev.* to 'mpc_dev_user'@'localhost';
GRANT SELECT ON mpc_prod.* to 'mpc_prod_user'@'localhost';
GRANT INSERT ON mpc_prod.* to 'mpc_prod_user'@'localhost';
GRANT DELETE ON mpc_prod.* to 'mpc_prod_user'@'localhost';
GRANT UPDATE ON mpc_prod.* to 'mpc_prod_user'@'localhost';
GRANT SELECT ON mpc_dev.* to 'mpc_dev_user'@'%';
GRANT INSERT ON mpc_dev.* to 'mpc_dev_user'@'%';
GRANT DELETE ON mpc_dev.* to 'mpc_dev_user'@'%';
GRANT UPDATE ON mpc_dev.* to 'mpc_dev_user'@'%';
GRANT SELECT ON mpc_prod.* to 'mpc_prod_user'@'%';
GRANT INSERT ON mpc_prod.* to 'mpc_prod_user'@'%';
GRANT DELETE ON mpc_prod.* to 'mpc_prod_user'@'%';
GRANT UPDATE ON mpc_prod.* to 'mpc_prod_user'@'%';
