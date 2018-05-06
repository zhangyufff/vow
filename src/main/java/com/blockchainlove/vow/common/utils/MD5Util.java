/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.blockchainlove.vow.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ʹ��½Ң�Ǳ߸��ļ��ܹ�����
 *
 * @author zhangyu
 * @version $Id: MD5Util.java, v 0.1 2018��04��30�� ����9:17 zhangyu Exp $
 */
public class MD5Util {

    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                'E', 'F' };
        byte[] btInput = s.getBytes();
        // ���MD5ժҪ�㷨�� MessageDigest ����
        MessageDigest msgDigest = null;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }

        // ʹ��ָ�����ֽڸ���ժҪ
        msgDigest.update(btInput);
        // �������
        byte[] md = msgDigest.digest();
        // ������ת����ʮ�����Ƶ��ַ�����ʽ
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

}
