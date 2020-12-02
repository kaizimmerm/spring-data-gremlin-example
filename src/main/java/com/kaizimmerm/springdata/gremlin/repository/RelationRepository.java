
package com.kaizimmerm.springdata.gremlin.repository;

import org.springframework.stereotype.Repository;
import com.kaizimmerm.springdata.gremlin.model.Relation;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;

@Repository
public interface RelationRepository extends GremlinRepository<Relation, String> {
}
