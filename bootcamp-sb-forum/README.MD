### Summary
- Global Exception Handler(@RestControllerAdvice)
  -@ExceptionHandler+@ResponseStatus
- Data Transfer Object(DTO)
  - Objectives:
    - Service API Consumers(DTO = self-defined type)
    - Data Object for Receiving API Response (DTO = The type is controlled by API provider)
- Mapper
  - Self Defined Mapper(GovMapper.class)
  - ModelMapper(dependecy)
- Library(Infra)
  - ApiResponse.class
  - Syscode.class
  - BcUtil.class(utility - static method)
  - BusinessException(Exception Framework - RuntimeException & CheckException)

- RestTemplate(Call external restful APIs)
  - UriComponentBuilder(host(),path(),toUriString())
- @Value
 - Read yml config
