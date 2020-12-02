package com.kaizimmerm.springdata.gremlin.model;

import org.springframework.data.annotation.Id;
import com.microsoft.spring.data.gremlin.annotation.Vertex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Vertex
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  @Id
  private String id;

  private String name;

  private Long birthday;

  private String address; // Partition Key
}
