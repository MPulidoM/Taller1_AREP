package edu.escuelaing.arem.ASE.app.Taller1;
import edu.escuelaing.arem.ASE.app.Taller1.ApiConection;
import org.json.JSONObject;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HttpServer {
    private static ApiConection apiConection = new ApiConection();
    private static ConcurrentHashMap<String,String> cache = new ConcurrentHashMap<>();

    private static HashMap<String,Object> movieData = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while (running) {

            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean fLine = true;
            String uriS = "";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (fLine) {
                    fLine = false;
                    uriS = inputLine.split(" ")[1];
                }
                if (!in.ready()) {
                    break;
                }
            }

            if (uriS.startsWith("/movie?")) {
                outputLine = getMovie(uriS);
            }else if(uriS.startsWith("/moviepost")){
                outputLine = getMovie(uriS);
            }else if(uriS.startsWith("/movie?name=Close") || uriS.startsWith("/moviepost?name=Close")){
                running = false;
                outputLine = getIndexResponse();
            }
            else {
                outputLine = getIndexResponse();
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * Obtiene información de una película y genera una respuesta adecuada.
     * @param uri El URI que contiene el nombre de la película, con el formato "/movie?name=NOMBRE".
     * @return Una respuesta HTML que contiene información de la película, una lista formateada o un mensaje de error.
    */

    public static String getMovie(String uri) {
        String name = nameFixer(uri.split("=")[1]);
        String message;
        String httpList;
        try {
            message = cache.get(name.toUpperCase());
            if (message != null) {
                movieSetter(message);
                httpList = listMader();
                return htmlResponse(httpList);
            } else {
                // Cache miss: fetch data from API
                message = getApiMessage(name);
                cache.put(name.toUpperCase(), message); // Update cache
                return message;
            }
        } catch (IOException x) {
            x.printStackTrace();
            // Handle exception gracefully, e.g., return an error response

        }

        return null ;
    }
    /**
     * Obtiene información de una película a través de una API.
     * @param name El nombre de la película para la que se desea obtener información.
     * @return El mensaje obtenido de la API, que contiene la información de la película.
     * @throws IOException Si se produce un error de E/S al comunicarse con la API.
     */

    public static String getApiMessage(String name) throws IOException {
        apiConection.movieNameSetter(name);
        apiConection.execute();
        return apiConection.getMessage();
    }

    /**
     * Este método está creado para mostrar la página
     * @return código html / javascript para crear una página
     */
    public static String getIndexResponse() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Movie Hunt</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "       <style>\n" +
                "           body{\n" +
                "               background-image: url(https://i.pinimg.com/originals/75/97/e2/7597e2d95ff26556f429dcde55eec2e9.png);\n" +
                "               background-repeat: no-repeat;" +
                "               font-family: \"Ubuntu\", Impact;\n" +
                "           }\n" +
                "           h1 {\n" +
                "               text-align:center;\n" +
                "               margin-top: 50px; \n" +
                "           }\n" +
                "           label, input[type=\"text\"],input[type=\"button\"]{\n" +
                "               display: block;\n" +
                "               margin: 0 auto;\n" +
                "               text-align: center;\n" +
                "           }"+
                "       </style>" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Encuentra tu película con GET</h1>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"name\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"\"><br><br>\n" +
                "            <input type=\"button\" value=\"Go!\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/movie?name=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Encuentra tu película con POST</h1>\n" +
                "        <form action=\"/moviepost\">\n" +
                "            <label for=\"postname\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"postname\" name=\"name\" value=\"\"><br><br>\n" +
                "            <input type=\"button\" value=\"Go!\" onclick=\"loadPostMsg(postname)\">\n" +
                "        </form>\n" +
                "        \n" +
                "        <div id=\"postrespmsg\"></div>\n" +
                "        \n" +
                "        <script>\n" +
                "            function loadPostMsg(name){\n" +
                "                let url = \"/moviepost?name=\" + name.value;\n" +
                "\n" +
                "                fetch (url, {method: 'POST'})\n" +
                "                    .then(x => x.text())\n" +
                "                    .then(y => document.getElementById(\"postrespmsg\").innerHTML = y);\n" +
                "            }\n" +
                "        </script>\n" +
                "    </body>\n" +
                "</html>";
    }


    /**
     * Este método reemplaza los espacios en blanco codificados con espacios reales
     * @param uriName el nombre que contiene los espacios codificados
     * @return el nombre o la parte del URI con espacios reales
     */
    public static String nameFixer(String uriName){
        return uriName.replace("%20", " ");
    }

    /**
     * Este método tiene la función de convertir un JSON en un HashMap
     * @param jsonString Debe ser la versión del JSON en formato String
     */
    public static void movieSetter(String jsonString){
        try{
            JSONObject jsonObj = new JSONObject(jsonString);
            Iterator<String> keys = jsonObj.keys();
            while (keys.hasNext()){
                String key = keys.next();
                Object value = jsonObj.get(key);
                movieData.put(key,value);
            }
        }catch (Exception x){
            x.printStackTrace();
        }
    }

    public static HashMap<String, Object> getMovieData() {
        return movieData;
    }

    /**
     * Este método extrae los valores del diccionario donde se encuentra el mensaje JSON
     * @return la parte en HTML que muestra los datos de la película que se quiere mostrar
     */
    public static String listMader(){
        String title = (String) movieData.get("Title");
        String year = (String) movieData.get("Year");
        String genre = (String) movieData.get("Genre");
        String director = (String) movieData.get("Director");
        String sinopsis = (String) movieData.get("Plot");
        return "<ul>\n"
                +"  <li> Title: " + title + "</li>\n"
                +"  <li> Year: " + year + "</li>\n"
                +"  <li> Genre: " + genre + "</li>\n"
                +"  <li> Director: " + director + "</li>\n"
                + " <li> Sinopsis: " + sinopsis + "</li>\n"
                +"</ul>\n";
    }

    /**
     * Este método tiene la finalidad de mostrar la información de la película en formato HTML
     * @param httpList la lista en HTML con la parte de los datos de la película que se quiere utilizar
     * @return el código HTML que se mostrará en el navegador
     */
    public static String htmlResponse(String httpList){
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type:  text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + " <head>\n"
                + "     <meta charset=\"UTF-8\">\n"
                + "     <title>List</title> \n"
                + " </head>\n"
                + " <body>\n"
                + "     " + httpList
                + " </body>\n"
                +"</html>";
    }
}
