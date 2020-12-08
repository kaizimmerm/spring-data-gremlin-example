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

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
class SpringDataRestIT extends AbstractIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void getPersonsList() throws Exception {

    mvc.perform(get("/persons")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaTypes.HAL_JSON_VALUE))
        .andExpect(jsonPath("$._embedded.persons.[?(@.name=='" + person.getName() + "')].address",
            contains(person.getAddress())))
        .andExpect(jsonPath("$._embedded.persons.[?(@.name=='" + person.getName() + "')].birthday",
            contains(person.getBirthday().intValue())))
        .andExpect(
            jsonPath("$._embedded.persons.[?(@.name=='" + person.getName() + "')]._links.self.href",
                contains("http://localhost/persons/" + person.getId())));
  }

  @Test
  void getSinglePerson() throws Exception {

    mvc.perform(get("/persons/" + person0.getId())).andExpect(status().isOk())
        .andExpect(content().contentType(MediaTypes.HAL_JSON_VALUE))
        .andExpect(jsonPath("$.name", equalTo(person0.getName())))
        .andExpect(jsonPath("$.address", equalTo(person0.getAddress())))
        .andExpect(jsonPath("$.birthday", equalTo(person0.getBirthday().intValue()))).andExpect(
            jsonPath("$._links.self.href", equalTo("http://localhost/persons/" + person0.getId())));
  }

}
