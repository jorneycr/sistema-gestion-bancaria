
# spring-api-rest-coffeshop

## Base de datos MySql

**Se utilizo mysql con la version *8.0.28*, el nombre de la base de datos utilizada es _coffeshop_, para cambiar la base de datos, abrimos el proyecto y buscamos la carpeta src/main/resorces dentro hay un archivo llamado application.properties, la linea para cambiar nuestra bd es spring.datasource.url, en la parte que pone coffeshop colocamos el nombre de la nueva base de datos que queramos utilizar**

Cuando se ejecuta el proyecto automaticamente, crea dos tablas en la base de datos.

## Nota

**Puerto de MySql = 3306**

**Version de apache requerida = 11.0.13**

Links de descarga de requisitos para abrir el proyecto


- _JDK 17_ = *https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html*


- _MySql 8_ = *https://dev.mysql.com/downloads/mysql/*



# End-Points Products

**Method POST**

- Add Product = *http://localhost:8080/api/products*


**Method GET**

- Get Products = *http://localhost:8080/api/products*


**Method DELETE**

- Delete Product = *http://localhost:8080/api/products/{id}*


**Method PUT**

- Edit Product = *http://localhost:8080/api/products/{id}*


# End-Poinst Orders

**Method POST**

- Add Order = *http://localhost:8080/api/orders*


**Method GET**

- Get Orders = *http://localhost:8080/api/orders*



**Method PUT**

- Edit Order = *http://localhost:8080/api/orders/{id}*




mvn clean install

mvn spring-boot:run