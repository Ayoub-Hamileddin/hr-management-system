package com.backend.backend.Exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FieldsError {
 private String field;
 private String message;
}
