package com.cqjtu.studentdocument.service;

import com.cqjtu.studentdocument.entity.Resources;
import com.cqjtu.studentdocument.utils.vo.ResourceVO;

import java.util.List;

public interface ResourcesService extends BaseService<Resources> {

    List<ResourceVO> getResourceTreeByRoleId(Integer roleId, Integer typeId);

    List<ResourceVO> getResourceTreeByUserId(Integer userId,Integer typeId);
}
