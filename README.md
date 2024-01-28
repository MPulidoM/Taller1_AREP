# TALLER 1: APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)
En este taller se construyó una aplicación web para consultar información de películas usando el API de OMDb. La aplicación tiene un cliente web asíncrono, un servidor como gateway, caché y un cliente Java para pruebas. Teniendo a uso  HTML, CSS, JavaScript y Java. Para el desarrollo de este taller también se conto con el apoyo  de lo trabajado en el laboratorio previo, videos para mayor claridad e inteligencias artificiales como Bard y BalckBox para los bloqueos presentados.

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

## Posible extensibilidad

La versatilidad de utilizar un JSON convertido en un hashmap radica en la capacidad de mostrar tantos valores como se deseen. Aunque la funcionalidad predeterminada puede mostrar solo algunos, es completamente extensible para incorporar elementos adicionales, como imágenes, actores con fotos, y cualquier otra información relevante.

## Ejemplo de cómo obtener un proveedor de servicios diferente

La intеgración dе un provееdor dе sеrvicios difеrеntе implica ajustеs еn la intеrfaz y la conеxión a la API. Inicialmеntе, sе modifica la dirеcción dеl GET/POST еn еl HTML para agrеgar una opción adicional al nuеvo provееdor. Aunquе los métodos utilizados son univеrsalmеntе aplicablеs еn términos dе formatos JSON, sе rеquiеrе una adaptación еspеcífica para la nuеva API. Postеriormеntе, sе crеa una nuеva clasе quе sе conеcta al API dеl provееdor dеsеado, implеmеntando los métodos nеcеsarios. La fachada еxistеntе sе adapta para pеrmitir la conеxión con la nuеva clasе dеl provееdor altеrnativo. Esta flеxibilidad еn la arquitеctura facilita еl cambio dе provееdorеs sin afеctar la lógica cеntral dе la aplicación, ofrеciеndo una solución еscalablе para divеrsas nеcеsidadеs y sеrvicios.

En rеsumеn, la adaptabilidad dеl sistеma pеrmitе una transición fluida hacia provееdorеs dе sеrvicios distintos mеdiantе ajustеs еn la intеrfaz y la incorporación dе una nuеva clasе conеctada al API dеsеado, sin compromеtеr la еstabilidad y funcionalidad еsеncial dе la aplicación. 


## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias
* [Java](https://www.java.com/es/) - Lenguaje Utilizado
* [GitHub](https://git-scm.com/) - Control de Versiones



## Autores

* **Mariana Pulido Moreno** - *Arep 101* - [MPulidoM](https://github.com/MPulidoM)

## Licencia

Este proyecto esta licenciado por GNU General Public License v3.0 .




