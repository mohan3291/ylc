package com.ylc.util;

import org.aspectj.lang.annotation.Aspect;


@Aspect
public class ServiceInterceptor
{
   /* private static Log logger = new Log(ServiceInterceptor.class);

   @Pointcut("execution(public * *(..))")
    public void anyPublicOperation() {}
    
    @Pointcut("within(com.hcsc.ep.endpoint.ws..*)")
    public void inServiceLayer() {
    }
    
    @Pointcut("within(com.hcsc.ep.channels.sales.sg.endpoint.ws..*)")
    public void inSGRServiceLayer() {
    }
    
    
    
    @Pointcut("within(com.hcsc.ep.persistence..*)")
    public void inDAOLayer() {
    }

    @Around("anyPublicOperation() && (inServiceLayer() || inDAOLayer() || inSGRServiceLayer())")
    public Object serviceMethods(ProceedingJoinPoint pjp) throws Throwable {
        String logPrefix = null;
        long start = 0;
        try {
            start = System.currentTimeMillis();
            logPrefix = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
            Object retVal = pjp.proceed();
            long end = System.currentTimeMillis();
            if (logger.isDebugEnabled()) {
                logger.debug(">>>>>>>>>>>>>>>> " + logPrefix + " Return in " + (end - start) + " ms>>>>>>>>>>>>>>>>>");
            }
            return retVal;
        }
        catch (Exception e) {
            if (logger.isDebugEnabled()) {
                long end = System.currentTimeMillis();
                logger.debug("error>>>>>>>>>>>>>>>> " + logPrefix + " Return in " + (end - start) + " ms>>>>>>>>>>>>>>>>>");
            }           
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors)); 
        //    logger.debug("error>>>>>>>>>>>>>>>> " + errors.toString());           
            throw e;
        }
    }   */
  
}
