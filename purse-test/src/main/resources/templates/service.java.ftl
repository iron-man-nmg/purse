package com.zhuoqitech.timetravel.service;

import com.zhuoqitech.timetravel.dal.entity.${entity}DO;
import com.zhuoqitech.timetravel.dal.mapper.${table.mapperName};
import com.zhuoqitech.timetravel.service.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceName} : ${superServiceImplClass}<${table.mapperName}, ${entity}DO>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}DO> {

}
</#if>
