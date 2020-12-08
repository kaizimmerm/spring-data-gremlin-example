/*
 * Copyright © 2020 Kai Zimmermann (kaizimmerm.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
