package com.zhuoqitech.timetravel.dal.mapper;

import com.zhuoqitech.timetravel.dal.entity.${entity}DO;
import ${superMapperClassPackage};

/**
 * <p>
 * ${table.comment} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}DO>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}DO> {

}
</#if>
