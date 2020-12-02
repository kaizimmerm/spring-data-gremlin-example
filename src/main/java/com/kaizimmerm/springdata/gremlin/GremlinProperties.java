package com.kaizimmerm.springdata.gremlin;

import org.apache.tinkerpop.gremlin.driver.ser.Serializers;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties("gremlin")
public class GremlinProperties {
  private String endpoint;

  private int port;

  private String username;

  private String password;

  private boolean sslEnabled = true;

  private boolean telemetryAllowed = true;

  private final String serializer = Serializers.GRAPHSON.toString();

  private int maxContentLength;
}
