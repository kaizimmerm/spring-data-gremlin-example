package com.kaizimmerm.springdata.gremlin;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kaizimmerm.springdata.gremlin.model.Family;
import com.kaizimmerm.springdata.gremlin.model.Person;
import com.kaizimmerm.springdata.gremlin.model.Relation;
import com.kaizimmerm.springdata.gremlin.repository.FamilyRepository;
import com.kaizimmerm.springdata.gremlin.repository.PersonRepository;
import com.kaizimmerm.springdata.gremlin.repository.RelationRepository;

@SpringBootTest
public abstract class AbstractIntegrationTest {

  private static final String PERSON_ID = "89757";
  private static final String PERSON_ID_0 = "0123456789";
  private static final String PERSON_ID_1 = "666666";
  private static final String PERSON_NAME = "person-name";
  private static final String PERSON_NAME_0 = "person-No.0";
  private static final String PERSON_NAME_1 = "person-No.1";

  private static final String RELATION_ID = "2333";
  private static final String RELATION_NAME = "brother";

  protected final Person person =
      new Person(PERSON_ID, PERSON_NAME, LocalDate.of(2015, 12, 31).toEpochDay(), "address-1");
  protected final Person person0 =
      new Person(PERSON_ID_0, PERSON_NAME_0, LocalDate.of(1981, 2, 12).toEpochDay(), "address-2");
  protected final Person person1 =
      new Person(PERSON_ID_1, PERSON_NAME_1, LocalDate.of(1962, 4, 30).toEpochDay(), "address-3");
  protected final Relation relation = new Relation(RELATION_ID, RELATION_NAME, person0, person1);
  private final Family family = new Family();

  @Autowired
  protected PersonRepository personRepo;

  @Autowired
  protected RelationRepository relationRepo;

  @Autowired
  protected FamilyRepository familyRepo;

  @BeforeEach
  public void setup() {
    familyRepo.deleteAll();

    family.getVertexes().add(person);
    family.getVertexes().add(person0);
    family.getVertexes().add(person1);
    family.getEdges().add(relation);

    familyRepo.save(family);
  }

  @AfterEach
  public void cleanup() {
    familyRepo.deleteAll();
  }

}
