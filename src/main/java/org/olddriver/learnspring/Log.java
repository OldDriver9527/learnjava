package org.olddriver.learnspring;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志
 * 20211217
 * 第五部分
 */
public class Log {
    /**
     * spring使用commons-logging作为日志门面框架，会从类路径中选择日志实现框架
     *
     * 日志实现框架
     * log4j
     * jul
     * logback
     * log4j2
     *
     * 日志门面框架
     * commons-logging
     * slf4j
     *
     * jul
     * 使用{index}作为参数占位符，用于参数替换
     */

    private static Logger logger = Logger.getLogger("org.olddriver.learnspring.Log");

    @Test
    public void testJul(){
        logger.info("this is jul's logger");
        logger.log(Level.WARNING,"this is jul's logger");
        logger.log(Level.WARNING,"当前时间为 {0}", LocalDateTime.now());
    }

}
