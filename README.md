# test

Pasos para ejecuta la aplicación

1. Ejecutar el proyecto llamado eurekaServer-reserva: El cual se encarga de levantar un servidor para el registro de servicios
	clientes, la cual se puede validar ingresando a la dirección: http://localhost:8761/
2. Ejecutar el proyecto llamado servidorGateway: El cual se encarga de registrar la tabla de servicios del servidor de eureka 
	y proporcionar un punto unico de entrada a cada microservicio
	
3. Ejecutar el proyecto llamado customers: el cual extrae la información de los usuarios, este expone un servicio el cual se accede
   a la direccion : 
	http://localhost:8007/customer/getall
   y a traves del gateway mediante:
	http://localhost:7000/scustomer-service/customer/getall
	
	Todos del tipo GET
	
4. Ejecutar el proyecto llamado products: el cual extrae la información de los productis, este expone dos servicios el cual se accede
   a la direccion : 
	http://localhost:8008/products/getall
	http://localhost:8008/products/single/1
   y a traves del gateway mediante:
	http://localhost:7000/sproducts-service/products/getall
	http://localhost:7000/sproducts-service/products/single/1
	
	Todos del tipo GET
5. Ejecutar el proyecto llamado orders: el cual extrae la información de los productis, este expone cuatro servicios el cual se accede
   a la direccion : 
	http://localhost:8009/orders/single/1
	http://localhost:8009/orders/getall
	http://localhost:8009/orders/add
	http://localhost:8009/orders/payment  
	
	Los dos primeros del tipo GET
	Los dos ultimos del tipo POST
	
   y a traves del gateway mediante:
	http://localhost:7000/sorders-service/orders/getall
	http://localhost:7000/sorders-service/orders/single/1
	http://localhost:7000/sorders-service/orders/add
	http://localhost:7000/sorders-service/orders/single/payment
	
Importante, todos los servicios tienen autenticación basica para la cual el usuario y clave son: admin/admin