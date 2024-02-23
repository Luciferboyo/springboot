package com.vtxlab.bootcamp.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
  
  private String code;

  private String message;

  private T data;

  public static <E> ApiResponse<E> success(E data) {
    return new ApiResponse<>(Syscode.OK.getCode(), Syscode.OK.getMessage(), data);
  }
  
  public static <E>ApiResponse<E> fail(Syscode syscode){
    return new ApiResponse<E>(syscode.getCode(), syscode.getMessage(), null);
  }

  public static <E>ApiResponse<E> fail(String errInfor){
    return new ApiResponse<E>(Syscode.EXCEPTION.getCode(), errInfor, null);
  }
}
