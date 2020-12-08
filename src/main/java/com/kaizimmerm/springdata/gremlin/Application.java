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

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kaizimmerm.springdata.gremlin.model.Family;
import com.kaizimmerm.springdata.gremlin.model.Person;
import com.kaizimmerm.springdata.gremlin.model.Relation;
import com.kaizimmerm.springdata.gremlin.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

  private final FamilyRepository familyRepo;

  public static void main(final String... args) {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  public void setup() {

    final Person person =
        new Person("1", "My name", LocalDate.of(2015, 12, 31).toEpochDay(), "address-1");
    final Person person0 =
        new Person("2", "is unkown", LocalDate.of(1981, 2, 12).toEpochDay(), "address-2");
    final Person person1 =
        new Person("3", "but maybe", LocalDate.of(1962, 4, 30).toEpochDay(), "address-3");
    final Relation relation = new Relation("1", "relative", person0, person1);
    final Family family = new Family();

    familyRepo.deleteAll();

    family.getEdges().add(relation);
    family.getVertexes().add(person);
    family.getVertexes().add(person0);
    family.getVertexes().add(person1);

    familyRepo.save(family);
  }
}
