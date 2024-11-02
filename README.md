**Parcial Back End Desarrollo de Software**

#Instrucciones y caracteristicas:
Esta api a traves de peticiones post va a permitir detectar a traves de una secuencia de ADN si es un humano o un mutante.

### Caractristicas:
- Hosting: Utilice render como proveedor de hosting. A continuacion dejo el link de render : https://parcialmutantes-3.onrender.com
- Base de datos: Utiliza H2 como base de datos

## NIVEL 2 - API con Postman
### Peticion para detectar mutantes
 - Ruta : "/mutant"
 - Metodo : "POST"
 - Descripcion : Esta peticion nos permite verificar a traves del sericio MutantService si contiene una secuencia de ADN o no.
Para llevar esto a cabo, utilizamos Postman. En el mismo creamos un nuevo espacio de trabajo y creamos una solicitud HTTP POST en formato JSON. 
En el campo url colocamos : http://localhost:8080/mutant/. Luego en Body seleccionamos la opcion Body que nos habilitará el formato JSON en el
colocamos el siguiente body:

![image](https://github.com/user-attachments/assets/2bdfd74e-e55d-4018-bdc0-a6fa6b09071e)

Al haber enviado una secuencia de ADN que no contiene ADN mutante, el resulado de la peticion sera "403 Forbidden" como inidica a continuacion:

![image](https://github.com/user-attachments/assets/85bbfc2f-6ae4-4bbe-b208-08ac5ac357e6)


En cambio, si en el Body enviamos una secuencia de ADN que si contenga ADN mutante como la siguiente:

![image](https://github.com/user-attachments/assets/fb9ce0e5-5163-4e8b-9cf4-63795098b277)

El resultado de la peticion sera "200 ok" y se mostrata el mensaje "Mutant detected", como podemos ver a continuacion:

![image](https://github.com/user-attachments/assets/c1461deb-71a8-4f0c-8150-1421ce82151a)


## Nivel 3 - Servicio "/stats"
- Ruta : "/stats"
- Metodo : "GET"
- Con esta peticion vamos a poder obtener estadisticas generales a cerca de cuantas peticones hemos enviado con ADN mutante y cuatas con ADN no mutante.
Este nos va a devolver un body con las siguientes campos:
- ratio : Indica la proporcion entre cantida de secuencias de ADN mutante y ADN no mutante
- countMutantDna : indica la cantidad de peticiones con secuencia de ADN que enviamos a la API
- countHumanDna: indica la cantidad de peticiones con ADN humano que enviamos a la API
A continuación un ejemplo:

![image](https://github.com/user-attachments/assets/9dfd0c5e-ad38-4d02-a946-1c8922f25d08)

Esta peticion tendra la siguiente devolucion:

![image](https://github.com/user-attachments/assets/5cd1b14b-c4ea-4533-9916-9aad3216159b)

En la misma podemos observa un status "200 OK" en la cual figura countMutantDna : 2 , countHumanDna : 1 y ratio : 2.0. Esto quiere decir que hemos enviado dos peticoines
con ADN mutante y una con ADN humano
