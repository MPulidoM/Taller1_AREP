# TALLER 1: APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)
En este taller se construyó una aplicación web para consultar información de películas usando el API de OMDb. La aplicación tiene un cliente web asíncrono, un servidor como gateway, caché y un cliente Java para pruebas. Teniendo a uso  HTML, CSS, JavaScript y Java. T

## Empezando

El proyecto contiene el ejercicio previo a la realización del taller , en el cual se inicio con una introducción para poder tener las bases de las clases y en si el esqueleto para realizar está aplicación , esto se puede encontrar en lo siguiente [ClassExercise](https://github.com/MPulidoM/Taller1_AREP/tree/main/miprimera-app/src/main/java/edu/escuelaing/arem/ASE/app/ClassExercise). Para tener una guía clara se trabajo otro directorio correspondiente a lo nuevo y centrado en el desarrolllo del taller ,donde se encuentra la conexión y el servidor , [Taller 1](https://github.com/MPulidoM/Taller1_AREP/tree/main/miprimera-app/src/main/java/edu/escuelaing/arem/ASE/app/Taller1). Por últmo en el tema de la docuemntación a detalle de los metodos usados se pueden encontrar [doc](https://github.com/MPulidoM/Taller1_AREP/tree/main/miprimera-app/doc).

   
### Requisitos previos

[Maven](https://maven.apache.org/) : Con esta herramienta se creo la estructura del proyecto y se manejan las dependencias que se necesitan

[Git](https://git-scm.com/) : Se basa en un sistema de control de versiones distribuido, donde cada desarrollador tiene una copia completa del historial del proyecto.

Para asegurar una correcta instalación de Maven, es crucial confirmar que la versión del JDK de Java sea compatible. Si el JDK no está actualizado, la instalación de las versiones actuales de Maven podría fallar, generando problemas durante el uso de la herramienta.
```
java -version 
```

### Instalando

Para poder ver el funcionamiento de este taller , en si instalar este programa, debe clonar el repositorio en su mauina local. Para esrto utilice el siguiente comando y ejecutelo.

```
$ git clone https://github.com/MPulidoM/Taller1_AREP
```
Para poder ver la aplicación web , se debe inicar en el IDE Utilizado el [HTTPServer](https://github.com/MPulidoM/Taller1_AREP/blob/main/miprimera-app/src/main/java/edu/escuelaing/arem/ASE/app/Taller1/HttpServer.java). Lo siguiente es abrir el navegador , en el caso de este taller se trabajo más que todo en Google, y poner en el siguiente 
```
localhost:35000
```

## Ejecutando las pruebas

Ya teniendo el proyecto compilado sin ningún problemas utilizando 
```
mvn package
```
Utilice el siguiente comando para ver las pruebas hechas
```
mvn test
```


## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias
* [Java](https://www.java.com/es/) - Lenguaje Utilizado
* [GitHub](https://git-scm.com/) - Control de Versiones



## Autores

* **Mariana Pulido Moreno** - *Arep 101* - [MPulidoM](https://github.com/MPulidoM)

## Licencia

Este proyecto esta licenciado por GNU General Public License v3.0 .




