/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.blockchainlove.vow.common.utils;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import com.blockchainlove.vow.common.enums.BizTypeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>ģ�淽ʽ��־��ӡ����</p>
 *
 * @author xiaochuan.zhang
 * @version $Id: LoggerUtil.java, v 0.1 2013-7-17 ����11:19:16 xiaochuan.zhang Exp $
 */
@SuppressWarnings("deprecation")
public final class LoggerUtil {
    /** logger */
    private static final Logger bizLog = LoggerFactory.getLogger("APPSTORE-BIZ-MONITOR");

    /** logger */
    private static final Logger CHECK_LOG = LoggerFactory.getLogger("APPSTORE-BIZ-CHECK");

    /** ҵ����־ǰ׺ */
    private final static String BIZ_LOG_PREFIX = "APPSTORE-BIZ-MONITOR";

    private final static String LEFT_TAG  = "[";
    private final static String RIGHT_TAG = "]";
    private final static String CONNECTOR = "|";
    private final static String COMMA     = ",";

    /** ��Ʒ���ҵ�� */
    public final static String BIZ_TYPE_COMMODITY         = "commodity";
    public final static String SUB_TYPE_COMMODITY_PUBLISH = "publish";

    /** �������ҵ�� */
    public final static String BIZ_TYPE_ORDER       = "order";
    public final static String SUB_TYPE_ORDER_BATCH = "batch";

    /** Ӫ�����ҵ�� */
    public final static String BIZ_TYPE_MARCKETING     = "marcketing";
    public final static String SUB_TYPE_MARCKETING_AAA = "aaa";

    /**
     * <p>���ɵ��Լ�����־</p>
     * <p>
     * ���ݴ���������־ģ��Ͳ������ϣ�����debug������־
     * ����������־ģ������{����}��ʾ���滻Ϊ��������־�㣬��a={0}����ʾ�ò���������indexΪ0�Ĳ����滻{0}��
     * </p>
     * @param logger        logger����
     * @param template      ����������־ģ��
     * @param parameters    ��������
     */
    public static void debug(Logger logger, String template, Object... parameters) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(template, parameters));
        }
    }

    /**
     * <p>����֪ͨ������־</p>
     * <p>
     * ���ݴ���������־ģ��Ͳ������ϣ�����info������־
     * ����������־ģ������{����}��ʾ���滻Ϊ��������־�㣬��a={0}����ʾ�ò���������indexΪ0�Ĳ����滻{0}��
     * </p>
     * @param logger        logger����
     * @param template      ����������־ģ��
     * @param parameters    ��������
     */
    public static void info(Logger logger, String template, Object... parameters) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(template, parameters));
        }
    }

    /**
     * ҵ������־ ��־����info
     * @param bizType ҵ������
     * @param template ����������־ģ��
     * @param parameters ��������
     */
    public static void biz(BizTypeEnum bizType, String template, Object... parameters) {
        biz(null, bizType, template, parameters);
    }

    /**
     * ҵ������־ ��־����info
     * @param channel ����
     * @param bizType ҵ������
     * @param template ����������־ģ��
     * @param parameters ��������
     */
    public static void biz(String channel, BizTypeEnum bizType, String template,
                           Object... parameters) {
        if (bizLog.isInfoEnabled()) {
            StringBuffer log = new StringBuffer();
            log.append(bizType.name());
            log.append(" ");
            if (StringUtils.isNotBlank(channel)) {
                log.append(channel);
            }
            log.append(" ");
            log.append(bizType.getDesc());
            log.append(" ");
            log.append(getLogString(template, parameters));
            bizLog.info(log.toString());
        }
    }

    /**
     * <p>���ɾ��漶����־</p>
     * <p>
     * ���ݴ���������־ģ��Ͳ������ϣ�����warn������־
     * ����������־ģ������{����}��ʾ���滻Ϊ��������־�㣬��a={0}����ʾ�ò���������indexΪ0�Ĳ����滻{0}��
     * </p>
     * @param logger        logger����
     * @param template      ����������־ģ��
     * @param parameters    ��������
     */
    public static void warn(Logger logger, String template, Object... parameters) {
        logger.warn(getLogString(template, parameters));
    }

    /**
     * <p>���ɾ��漶����־</p>
     * <p>
     * ���ݴ���������־ģ��Ͳ������ϣ�����warn������־
     * ����������־ģ������{����}��ʾ���滻Ϊ��������־�㣬��a={0}����ʾ�ò���������indexΪ0�Ĳ����滻{0}��
     * </p>
     * @param e             �����쳣��ջ
     * @param logger        logger����
     * @param template      ����������־ģ��
     * @param parameters    ��������
     */
    public static void warn(Throwable e, Logger logger, String template, Object... parameters) {
        String errorCode = extractErrorCodeFromEx(e);
        logger.warn(getLogString(template, parameters) + ", ErrorCode=" + errorCode, e);
    }

    /**
     * <p>���ɴ��󼶱���־</p>
     * <p>
     * ���ݴ���������־ģ��Ͳ������ϣ�����error������־
     * ����������־ģ������{����}��ʾ���滻Ϊ��������־�㣬��a={0}����ʾ�ò���������indexΪ0�Ĳ����滻{0}��
     * </p>
     * @param e             �����쳣��ջ
     * @param logger        logger����
     * @param template      ����������־ģ��
     * @param parameters    ��������
     */
    public static void error(Throwable e, Logger logger, String template, Object... parameters) {
        String errorCode = extractErrorCodeFromEx(e);
        logger.error(getLogString(template, parameters) + ", ErrorCode=" + errorCode, e);
    }

    /**
     * <p>���ɴ��󼶱���־</p>
     * <p>
     * ���ݴ���������־ģ��Ͳ������ϣ�����error������־
     * ����������־ģ������{����}��ʾ���滻Ϊ��������־�㣬��a={0}����ʾ�ò���������indexΪ0�Ĳ����滻{0}��
     * </p>
     * @param logger        logger����
     * @param template      ����������־ģ��
     * @param parameters    ��������
     */
    public static void error(Logger logger, String template, Object... parameters) {
        logger.error(getLogString(template, parameters));
    }

    public static void monitor(Logger logger, String bizType, String subBizType, String key,
                               String context) {
        StringBuffer log = new StringBuffer();
        log.append("appstore").append(COMMA).append(bizType).append(COMMA).append(subBizType);
        log.append(COMMA).append(key).append(COMMA).append(context);
        if (logger.isInfoEnabled()) {
            logger.info(log.toString());
        }
    }

    /**
     * ƴװ����
     * @param template
     * @param parameters
     * @return
     */
    private static String getLogString(String template, Object... parameters) {
        StringBuilder log = new StringBuilder();
        log.append(LEFT_TAG).append(getContextUniqueId()).append(RIGHT_TAG);
        log.append(' ');
        log.append(MessageFormat.format(template, parameters));
        return log.toString();
    }

    /**
     * ���쳣����ȡerrorCode
     */
    private static String extractErrorCodeFromEx(Throwable ex) {
        if (ex == null) {
            return StringUtils.EMPTY;
        }
        try {
            Method mt = ex.getClass().getDeclaredMethod("getErrorCode");
            if (mt != null) {
                Object obj = mt.invoke(ex);
                if (obj != null) {
                    return obj.toString();
                }
            }
        } catch (Exception e) {
            //��Ӱ����־��ӡ
            return StringUtils.EMPTY;
        }

        return StringUtils.EMPTY;
    }

    /**
     * ��ȡsofaͳһ������
     *
     * @return String ͳһ������
     */
    private static final String getContextUniqueId() {
        try {
            // ������ID
            return TracerContextUtil.getTraceId();
        } catch (Exception e) {
            // ͳһ��ȡsofa�ӿڵ������ķ���,�����ȡ��������"-",�ǹؼ���Ϣ,����쳣��Ϣ��������;
            return "-";
        }
    }

    /**
     * check��־
     *
     * @param bizType
     * @param bizKey
     * @param same
     */
    public static void logCheck(String bizType, String bizKey, boolean same) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(bizType);
        sb.append(",");
        sb.append(bizKey);
        sb.append(",");
        sb.append(same ? "Y" : "N");
        sb.append(")");

        if (CHECK_LOG.isInfoEnabled()) {
            CHECK_LOG.info(sb.toString());
        }
    }

}
