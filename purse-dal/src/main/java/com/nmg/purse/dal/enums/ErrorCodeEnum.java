package com.nmg.purse.dal.enums;

import com.zhuoqitech.common.support.entity.IErrCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: renzhengbin
 * @Date: 19/6/17 18:37
 * @Version 1.0
 */
public enum ErrorCodeEnum implements IErrCode {

    SUCCESS(0, "成功"),

    /** 10打头，数据校验异常 */
    DATA_CHECK_EXCEPTION(1000, "{}"),
    DATA_CHECK_NOT_EXIST(1001, "[{}]不存在"),
    DATA_CHECK_EMPTY(1002, "[{}]不能为空"),

    /** 2打头，业务异常 */
    /** 20打头，短信异常 */
    SMS_SEND_ERROR(2000, "短信发送异常"),

    /** 3打头，数据库问题 */
    DATABASE_INSERT_FAILED(3000, "数据插入异常"),

    SYSTEM_ERROR(9999, "内部系统异常");


    private int code;
    private String desc;

    ErrorCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ErrorCodeEnum getEnum(int code) {
        for (ErrorCodeEnum loan : ErrorCodeEnum.values()) {
            if (loan.getCode() == code) {
                return loan;
            }
        }

        return null;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getDesc(Integer code) {
        for (ErrorCodeEnum p : ErrorCodeEnum.values()) {
            if (Integer.valueOf(p.getCode()).equals(code)) {
                return p.getDesc();
            }
        }
        return code + "没有对应的说明信息";
    }

    public IErrCode getReplacedDescError(final String replacedStr) {
        final String desc = this.getDesc();
        final int code = this.getCode();

        return new IErrCode() {
            @Override
            public Integer getCode() {
                return code;
            }

            @Override
            public String getDesc() {
                return StringUtils.replaceEachRepeatedly(desc, new String[]{"{}"}, new String[]{replacedStr});
            }

            @Override
            public String getDesc(Integer code) {
                return null;
            }
        };

    }
}
