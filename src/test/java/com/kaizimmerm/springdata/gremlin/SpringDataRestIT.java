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
