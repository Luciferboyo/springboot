package com.vtxlab.bootcamp.bootcampsbforum.Mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.request.PostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;


// When server starts,
// Spring ensures modelMapper is ready before creating GovMapper object
@Component // -> Bean
public class PostMapper {

  @Autowired
  private ModelMapper modelMapper;

  public PostEntity mapEntity(PostRequestDTO dto) {
    return new PostEntity(null, //
        dto.getTitle(), //
        dto.getBody(), //
        null);
  }

}