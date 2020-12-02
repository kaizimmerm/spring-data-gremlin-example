package com.kaizimmerm.springdata.gremlin.model;

import org.springframework.data.annotation.Id;
import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Edge
@AllArgsConstructor
@NoArgsConstructor
public class Relation {

  @Id
  private String id;

  private String name;

  @EdgeFrom
  private Person personFrom;

  @EdgeTo
  private Person personTo;
}
