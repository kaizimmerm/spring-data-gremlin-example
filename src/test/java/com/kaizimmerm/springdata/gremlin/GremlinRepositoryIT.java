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

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.kaizimmerm.springdata.gremlin.model.Person;
import com.kaizimmerm.springdata.gremlin.model.Relation;



@SpringJUnitConfig
@ContextConfiguration(classes = GremlinConfiguration.class)
class GremlinRepositoryIT extends AbstractIntegrationTest {


  @Test
  void findByIdReturnsPersonRelation() {
    final Optional<Person> personOptional = personRepo.findById(person.getId());
    assertThat(personOptional).isPresent().hasValue(person);

    final Optional<Relation> relationOptional = relationRepo.findById(relation.getId());
    assertThat(relationOptional).isPresent().hasValue(relation);
  }

  @Test
  void countIncludesEdgesVertexesButNoNetworks() {
    assertThat(personRepo.count()).isEqualTo(4);
  }



}

