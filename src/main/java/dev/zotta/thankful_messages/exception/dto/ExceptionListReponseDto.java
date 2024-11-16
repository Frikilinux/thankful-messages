package dev.zotta.thankful_messages.exception.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

public record ExceptionListReponseDto(HttpStatus status, List<ValidationResponseDto> errors) {

}
