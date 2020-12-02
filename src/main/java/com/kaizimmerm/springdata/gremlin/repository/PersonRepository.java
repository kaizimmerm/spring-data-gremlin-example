package com.kaizimmerm.springdata.gremlin.repository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import com.kaizimmerm.springdata.gremlin.model.Person;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;

@Repository
@RepositoryRestController
public interface PersonRepository extends GremlinRepository<Person, String> {
}
