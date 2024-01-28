package edu.escuelaing.arem.ASE.app;

import edu.escuelaing.arem.ASE.app.Taller1.ApiConection;
import edu.escuelaing.arem.ASE.app.Taller1.HttpServer;
import org.junit.Test;


import java.util.HashMap;

import static org.junit.Assert.*;

public class HttpServerTest {
    @Test

    public void testNameFixer() {

        String uriName = "Frozen%20II";

        String expected = "Frozen II";

        String actual = HttpServer.nameFixer(uriName);

        assertEquals(expected, actual);

    }

    @Test
    public void ShouldHandleMultipleEncodedSpaces() {
        HttpServer httpServer = new HttpServer();
        String codificationName = "The%20Lord%20of%20the%20Rings";
        String rightOne = "The Lord of the Rings";
        codificationName = httpServer.nameFixer(codificationName);
        assertEquals(rightOne, codificationName);
    }
    @Test
    public void ShouldHandleMissingKeysInJson() {
        HttpServer httpServer = new HttpServer();
        String jsonTest = "{\"Title\":\"The Matrix\",\"Year\":\"1999\",\"Runtime\":\"136 min\"}"; // Missing some keys
        httpServer.movieSetter(jsonTest);
        HashMap<String, Object> map = httpServer.getMovieData();
        assertFalse(map.containsKey("Genre"));
        assertNull(map.get("Director"));
    }



}