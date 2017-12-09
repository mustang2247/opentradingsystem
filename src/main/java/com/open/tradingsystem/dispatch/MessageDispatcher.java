/**
 *
 */
package com.open.tradingsystem.dispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDispatcher {

    private static final Logger logger = LoggerFactory.getLogger( MessageDispatcher.class );
    private CommandRegistry cmdReg = null;

    /**
     * 使用线程池
     *
     * @param cmdReg
     */
    public MessageDispatcher( CommandRegistry cmdReg) {
        this.cmdReg = cmdReg;
    }

    /**
     * 如果使用了SYNC，一定要提供一个提取SynEnvBase的接口
     *
     * @param kindId
     * @param msgId
     * @param message
     */
    public void dispatch( final int kindId, final int msgId, final Object message) {

        final CommandProperties properties = cmdReg.get( kindId );
        if( properties == null ) {
            logger.error( "[MessageDispatcher::dispatch] not find kindID {} from {}", kindId );
            return;
        }

        try {

            properties.method.invoke( properties.proxyObj, new Object[]{ msgId, message } );
        }
        catch( Exception e ) {
            logger.error( e.getMessage(), e );
        }
    }

}
