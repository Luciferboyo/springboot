package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.response.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;

public interface GovOperation {

  // 1. no user found
  // 2. user found, but no posts -> empty array of posts
  @GetMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserPostDTO> getUsersFromJPH(@RequestParam(value = "id") int userId);

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<UserPostDTO>> getUsersFromJPH();

}