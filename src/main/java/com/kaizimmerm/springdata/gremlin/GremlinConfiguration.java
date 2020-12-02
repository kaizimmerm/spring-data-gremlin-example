package com.kaizimmerm.springdata.gremlin;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.microsoft.spring.data.gremlin.common.GremlinConfig;
import com.microsoft.spring.data.gremlin.config.AbstractGremlinConfiguration;
import com.microsoft.spring.data.gremlin.repository.config.EnableGremlinRepositories;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableGremlinRepositories(basePackages = "com.kaizimmerm.springdata.gremlin.repository")
@EnableConfigurationProperties(GremlinProperties.class)
@RequiredArgsConstructor
public class GremlinConfiguration extends AbstractGremlinConfiguration {

  private final GremlinProperties properties;

  @Override
  public GremlinConfig getGremlinConfig() {

    return GremlinConfig.defaultBuilder().endpoint(properties.getEndpoint())
        .port(properties.getPort()).username(properties.getUsername())
        .password(properties.getPassword()).sslEnabled(properties.isSslEnabled())
        .telemetryAllowed(properties.isTelemetryAllowed()).serializer(properties.getSerializer())
        .maxContentLength(properties.getMaxContentLength()).build();
  }
}
