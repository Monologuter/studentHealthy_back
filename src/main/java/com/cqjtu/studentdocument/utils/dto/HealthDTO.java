package com.cqjtu.studentdocument.utils.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HealthDTO {

    private Double bim;

    private String suggestion;
}
