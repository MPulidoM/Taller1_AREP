package edu.escuelaing.arem.ASE.app.ClassExercise.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLParser {
    public static void   main (String[] args) throws MalformedURLException {
        URL myUrl = null;

        myUrl = new URL("https://campusvirtual.escuelaing.edu.co:5678/moodle/pluginfile.php/126053/mod_resource/content/0/TallerMVNGIT.pdf?val=235#ayuda");

        System.out.println("Host: " + myUrl.getHost());
        System.out.println("Authority " + myUrl.getAuthority());
        System.out.println("Path " + myUrl.getPath());
        System.out.println("Protocol " + myUrl.getProtocol());
        System.out.println("Port: " + myUrl.getPort());
        System.out.println("Query " + myUrl.getQuery());
        System.out.println("Ref " + myUrl.getRef());
        System.out.println("File " + myUrl.getFile());




    }
}
