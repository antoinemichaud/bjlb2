package com.nextgestion.bjlb.aspects;


import java.util.logging.Logger;

public aspect Logging {

    public static final String GLOBAL_LOGGER = "Global Logger";

    private static final Logger logger = Logger.getLogger(GLOBAL_LOGGER);

    private pointcut publicMethodExecuted(): execution(public * com.nextgestion.bjlb.repository.*.*(..)) ||
            execution(public * com.nextgestion.bjlb.service.*.*(..));

    before(): publicMethodExecuted() {
        final StringBuilder startingLog = new StringBuilder(String.format("%s - start ", thisJoinPoint.getSignature().toString()));

        Object[] arguments = thisJoinPoint.getArgs();
        for (Object argument : arguments) {
            if (argument != null) {
                startingLog.append(String.format("With argument of type %s and value %s. \n", argument.getClass().toString(), argument));
            }
        }

        logger.fine(startingLog.toString());
    }

    after(): publicMethodExecuted() {
        logger.fine(String.format("%s - end ", thisJoinPoint.getSignature().toString()));
    }
}
