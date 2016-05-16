
package com;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.IOException;


public class GeocodeService extends Service<GeocodeConfiguration> {
    public static void main(String[] args) throws Exception {
        new GeocodeService().run(args);
    }

    @Override
    public void initialize(Bootstrap<GeocodeConfiguration> geocodeConfigurationBootstrap) {
    }

    @Override
    public void run(GeocodeConfiguration config, Environment environment) throws IOException, JSONException  {
        String gurl = config.getgoogleURL();
        String aurl = config.getarcgisURL();
        GeocodeResource geocodeResource = new GeocodeResource(aurl,gurl);
        environment.addResource(geocodeResource);

    }

 }
