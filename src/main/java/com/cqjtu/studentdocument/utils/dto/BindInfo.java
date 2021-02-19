package com.cqjtu.studentdocument.utils.dto;

import lombok.Data;

import java.util.List;

/**
 * @author pengyangyan
 */
@Data
public class BindInfo {

    private Integer resourceId;

    private List<Integer> roleList;

}
