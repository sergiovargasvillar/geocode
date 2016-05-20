package com;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import org.junit.*;
import org.mockito.Mockito;
import org.json.JSONException;
import org.json.JSONObject;

public class FirstTest
{

    @Test public void sample()
    {

        assertEquals("Gradle is gr8", "Gradle is gr8");

    }

    @Test public void readjson_getjson() throws JSONException, IOException
    {

        //  create mock
        GeocodeResource test = Mockito.mock(GeocodeResource.class);

        // define return value for method getUniqueId()
        when(test.readjson("Bolivia")).thenReturn(new JSONObject("{test: 'test'}"));

        // use mock in test....
        assertEquals("{test: 'test'}", "{test: 'test'}");

    }

}
