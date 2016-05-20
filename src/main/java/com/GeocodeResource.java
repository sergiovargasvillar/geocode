package com;
import com.google.common.base.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import org.json.JSONArray;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import javax.ws.rs.core.Response;

@Path("maps/api/geocode")
@Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
//@Produces("text/plain")
public class GeocodeResource
{
    private final String gURL, aURL;
//  private final String url;
// private final JSONObject json;
    private String myaddress;
//private String type="arcgis";
    private String type="google";
    public String getmyaddress()
    {
        return myaddress;

    }

    public GeocodeResource(String aURL, String gURL)
    {
        this.aURL = aURL;
        this.gURL = gURL;

    }

    public JSONObject readjson(String add) throws IOException, JSONException
    {
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        int cp;

        is = new URL(gURL + add).openStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            while ((cp = rd.read()) != -1)
            {
                sb.append((char) cp);
            }
            String jsonText =  sb.toString();
            JSONObject geojson = new JSONObject(jsonText);

            return geojson;
        } finally {
            is.close();
        }

    }

    @Path("/json")

    @GET
// @Produces("text/plain")
    @Produces(MediaType.APPLICATION_JSON)

    public Response Resource(@QueryParam("address") String address) throws IOException, JSONException
    {
        myaddress=address;

        JSONArray array;
        JSONObject geometry = null,feature,bigJson,json;
        System.out.println("Address: " + myaddress);

        json = readjson(myaddress);
        array = json.getJSONArray("results");
        bigJson = array.getJSONObject(0);
        feature = bigJson.getJSONObject("geometry");
        geometry = feature.getJSONObject("location");

        System.out.print(geometry);
        String xy = geometry.toString();

        return Response.ok(xy).header("Access-Control-Allow-Origin", "*").build();

    }

}
