package com.nextgestion.bjlb.aspects;


import java.util.logging.Logger;

import com.nextgestion.bjlb.main.VertxServer;

public aspect Logging {

    private static final Logger logger = Logger.getLogger(VertxServer.GLOBAL_LOGGER);

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
