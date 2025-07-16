package com.project.Utils;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomLogger {
    private final Logger LOGGER;
    private Class<?> clazz;

    public CustomLogger(Class<?> clazz) {
        this.clazz = clazz;
        this.LOGGER = LoggerFactory.getLogger(clazz);
    }

    public void log (String var1, Object... var2) {
        log(LogType.info, var1, var2);
    }

    public void log (LogType logType, String var1, Object... var2) {
        switch (logType) {
            case info:
                this.LOGGER.info(var1, var2);
                break;
            case warn:
                this.LOGGER.warn(var1, var2);
                break;
            case error:
                this.LOGGER.error(var1, var2);
                break;
        }
    }

    public void log (Throwable throwable, String var1, Object... var2) {
        this.LOGGER.error(String.format("Error occurred: %s", var1), var2);
        this.LOGGER.error(ExceptionUtils.getStackTrace(throwable));
        try {
        } catch (Exception e) {
            System.out.println("Error occurred while saving error to database" + e.getMessage());
            e.printStackTrace();
        }
    }

}
