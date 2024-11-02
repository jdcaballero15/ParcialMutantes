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

![image](https://github.com/user-attachments/assets/d7beccca-61d4-413f-87d3-e24d1821edca)

Si en Body enviamos una secuencia de ADN que si contenga ADN mutante como la siguiente:

![image](https://github.com/user-attachments/assets/fb9ce0e5-5163-4e8b-9cf4-63795098b277)

El resultado de la peticion sera "200 ok" y se mostrata el mensaje "Mutant detected", como podemos ver a continuacion:

![image](https://github.com/user-attachments/assets/0adbbb38-adb1-4060-9915-f34be90f2174)
