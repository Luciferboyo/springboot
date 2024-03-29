package com.vtxlab.bootcamp.bootcampsbforum.dto.response.gov;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserPostDTO {

  private int id;
  
  private String username;

  private String email;

  private String phone;

  @Setter
  @JsonProperty(value = "posts") // serialization
  private List<PostDTO> postDTOs;

}