package com.cqjtu.studentdocument.utils.dto;

import lombok.Data;

@Data
public class InfoReadDTO {

    /**
     * 状态
     */
    Integer isRead;
    /**
     * id数组
     */
    Integer[] ids;

}
