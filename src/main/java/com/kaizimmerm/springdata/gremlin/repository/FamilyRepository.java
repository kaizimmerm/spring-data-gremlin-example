
package com.kaizimmerm.springdata.gremlin.repository;

import org.springframework.stereotype.Repository;
import com.kaizimmerm.springdata.gremlin.model.Family;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;

@Repository
public interface FamilyRepository extends GremlinRepository<Family, String> {
}
