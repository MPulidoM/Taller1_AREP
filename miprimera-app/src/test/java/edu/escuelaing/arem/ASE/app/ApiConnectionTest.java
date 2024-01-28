package edu.escuelaing.arem.ASE.app;

import edu.escuelaing.arem.ASE.app.Taller1.ApiConection;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiConnectionTest {
    @Test
    public void TestMovieNameFormatting(){
        ApiConection httpApiConection = new ApiConection();
        httpApiConection.movieNameSetter("TinkerBell");
        String name = httpApiConection.getMovieName();
        assertEquals("TinkerBell",name);
    }
    @Test
    public void TestUrlBuilding(){
        ApiConection httpApiConection = new ApiConection();
        httpApiConection.movieNameSetter("Iron" + " "  + "Man");
        String url = httpApiConection.fullUrlBuilder();
        assertEquals("http://www.omdbapi.com/?t=Iron+Man&apikey=db788e57", url);
    }
    @Test

    public void testExecute() throws IOException {

        ApiConection.execute();

        String actual = ApiConection.getMessage();

        assertNotNull(actual);

    }

    @Test

    public void testMakeGetRequest() throws IOException {

        String urlString = "https://www.omdbapi.com/?t=Frozen&apikey=db788e57";

        String actual = ApiConection.makeGetRequest(urlString);

        assertNotNull(actual);

    }


}
