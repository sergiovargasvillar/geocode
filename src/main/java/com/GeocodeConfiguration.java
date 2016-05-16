package com;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class GeocodeConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
      private String googleURL;
      private String arcgisURL;
    
    public String getgoogleURL() { 

      return googleURL;

       }


    public String getarcgisURL() { 

      return arcgisURL;

       }
 
}
