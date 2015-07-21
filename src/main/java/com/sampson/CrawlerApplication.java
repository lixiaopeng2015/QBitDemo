package com.sampson;

import com.sampson.services.SiteService;
import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lixiaopeng on 2015/7/15.
 */
public class CrawlerApplication {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerApplication.class);

    public static void main(String... args) {
        try {
            ServiceEndpointServer server = EndpointServerBuilder.endpointServerBuilder().setHost("localhost")
                    .setPort(7700).build();

            server.initServices(new SiteService()).startServer();
            logger.info("QBit Service start success at " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        } catch (Exception e) {
            logger.info("QBit Service start failure at " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }
}
