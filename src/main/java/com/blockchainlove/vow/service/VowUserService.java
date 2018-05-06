/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.blockchainlove.vow.service;

/**
 *
 * @author zhangyu
 * @version $Id: VowUserService.java, v 0.1 2018年05月05日 下午11:29 zhangyu Exp $
 */
public interface VowUserService {

    /**
     * 更新验证码到表中
     *
     * @param phone
     * @return
     */
    String updateAuthCodeByPhone(String authCode, String phone);

}