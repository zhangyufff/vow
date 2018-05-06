/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.blockchainlove.vow.common.basemodel;

import java.util.Map;

/**
 * �������������
 *
 * @author jie.lan
 * @version $Id: ApiResult.java, v 0.1 2015-04-05 ����11:00 jie.lan Exp $
 */
public class ApiResult extends ToString {

    /** serialVersionUID */
    private static final long serialVersionUID = 2137683422670918667L;

    /** �����Ƿ�ɹ�,true:�ɹ� , false:ʧ�� */
    private boolean success = true;

    /** ͳһ���������� */
    private String              errorCode;
    /**
     * �����İ�
     */
    private String              errorMsg;
    /** ��չ��Ϣ */
    private Map<String, String> extInfos;

    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     *
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>extInfos</tt>.
     *
     * @return property value of extInfos
     */
    public Map<String, String> getExtInfos() {
        return extInfos;
    }

    /**
     * Setter method for property <tt>extInfos</tt>.
     *
     * @param extInfos value to be assigned to property extInfos
     */
    public void setExtInfos(Map<String, String> extInfos) {
        this.extInfos = extInfos;
    }

    /**
     * Getter method for property <tt>errorMsg</tt>.
     *
     * @return property value of errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Setter method for property <tt>errorMsg</tt>.
     *
     * @param errorMsg value to be assigned to property errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
