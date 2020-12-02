package com.kaizimmerm.springdata.gremlin.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.Graph;
import com.microsoft.spring.data.gremlin.annotation.VertexSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Graph
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family {

  @Id
  private String id;

  @EdgeSet
  private List<Object> edges = new ArrayList<>();

  @VertexSet
  private List<Object> vertexes = new ArrayList<>();

}
