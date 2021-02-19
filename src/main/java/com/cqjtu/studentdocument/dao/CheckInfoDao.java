package com.cqjtu.studentdocument.dao;

import com.cqjtu.studentdocument.entity.CheckInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckInfoDao extends BaseDao<CheckInfo> {

    List<CheckInfo> getDataAnalysis(@Param("userId") Integer userId);

    CheckInfo getCurrentCheckInfo(@Param("userId") Integer userId);
}
