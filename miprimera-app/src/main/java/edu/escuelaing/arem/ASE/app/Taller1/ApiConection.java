package edu.escuelaing.arem.ASE.app.Taller1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiConection {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String API_KEY = "db788e57"; //needed for the api to work
    private static final String GET_URL = "http://www.omdbapi.com/";

    public static String getMovieName() {
        return movieName;
    }

    private static  String movieName = "Frozen";

    private static String responseString = " " ;

    public ApiConection(){
        movieName = "Frozen";
    }


    public static void main(String[] args) throws IOException {
        String responseString = makeGetRequest(fullUrlBuilder());
        System.out.println(responseString);
    }


    /**
     * Realiza una solicitud GET a la URL especificada y devuelve el cuerpo de la respuesta como una cadena.
     *
     * @param urlString La URL a la que se realiza la solicitud GET.
     * @return El cuerpo de la respuesta como una cadena, o null si la solicitud falla.
     * @throws IOException Si se produce un error de E/S.
     */

    public static String makeGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return readResponse(connection);
        } else {
            System.out.println("GET request not worked");
            return null;
        }
    }

    /**
     * Lee la respuesta de una conexión HttpURLConnection y la devuelve como una cadena.
     *
     * @param connection La conexión HttpURLConnection de la que se leerá la respuesta.
     * @return La respuesta como una cadena.
     * @throws IOException Si se produce un error de E/S al leer la respuesta.
     */

    private static String readResponse(HttpURLConnection connection) throws IOException {
        try (BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = responseReader.readLine()) != null) {
                responseBuilder.append(line);
            }
            return responseBuilder.toString();
        }
    }

    /**
     * Ejecuta una solicitud GET a la URL construida por `fullUrlBuilder()` y almacena la respuesta en la variable global `responseString`.
     *
     * @throws IOException Si se produce un error de E/S al realizar la solicitud o leer la respuesta.
     */
    public static void execute() throws IOException{
        URL obj = new URL(fullUrlBuilder());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;

                do {
                    inputLine = in.readLine();
                    if (inputLine != null) {
                        response.append(inputLine);
                    }
                } while (inputLine != null);

                responseString = response.toString();
            }
        }
    }

    /**
     * Construye la URL completa para la solicitud GET, incluyendo el nombre de la película y la clave API.
     *
     * @return La URL completa como una cadena.
     */
    public static String fullUrlBuilder(){
        return GET_URL + "?t=" + movieName + "&apikey=" + API_KEY;
    }

    /**
     * Establece el nombre de la película y lo codifica para su uso en una URL.
     *
     * @param name El nombre de la película que se establecerá.
     */
    public static void movieNameSetter(String name) {
        movieName = name;
        String Urlmovie = null;
        try {
            Urlmovie = URLEncoder.encode(movieName, "UTF-8");
        } catch (UnsupportedEncodingException x) {
            x.printStackTrace();
        }
        movieName = Urlmovie;
    }


    public static String getMessage(){
        return responseString.toString();
    }

}
