package com.cqjtu.studentdocument.dao;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author pengyangyan
 */
@RegisterMapper
public interface BaseDao<T> extends Mapper<T> {
}
