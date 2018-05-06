/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.blockchainlove.vow.common.basemodel;

/**
 * ��ֵ���Ͳ�ѯ���ؽ����֧�ַ���
 * <br>ע��Ŀǰ����ֻ����TR�ӿ���ʹ�ã�������WS�ӿ�ʹ��
 * @author sunjian
 * @version $Id: SingleQueryResult.java, v 0.1 2015��11��18�� ����7:38:07 sunjian Exp $
 */
public class SingleQueryResult<T> extends ApiResult {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2256819341557160298L;

    /**
     * ������ѯ��¼
     */
    private T value;

    /**
     * Ĭ�Ϲ��캯��
     */
    public SingleQueryResult() {
        super();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /**
     * ��ȡ�����¼��
     * @return
     */
    public int getResultSize() {
        return this.value == null ? 0 : 1;
    }
}
