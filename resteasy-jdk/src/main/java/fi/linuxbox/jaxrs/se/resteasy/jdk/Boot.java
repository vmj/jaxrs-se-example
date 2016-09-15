package fi.linuxbox.jaxrs.se.resteasy.jdk;

import com.sun.net.httpserver.*;
import fi.linuxbox.jaxrs.se.resources.*;
import java.io.*;
import java.net.*;
import org.jboss.resteasy.plugins.server.sun.http.*;
import org.slf4j.*;

public class Boot
{
    private static Logger log = LoggerFactory.getLogger(Boot.class);



    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        log.debug("Setting up JDK HTTP server and RestEasy");
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(9000), 0);

        final HttpContextBuilder contextBuilder = new HttpContextBuilder();

        contextBuilder.getDeployment().getActualResourceClasses().add(IndexResource.class);

        final HttpContext context = contextBuilder.bind(httpServer);

        log.debug("Starting HTTP server");
        httpServer.start();

        Runtime.getRuntime().addShutdownHook(new RestEasyCleanup(contextBuilder, httpServer));

        final Object lock = new Object();
        synchronized (lock) { lock.wait(); }
    }

    private static class RestEasyCleanup extends Thread {
        private final Logger log = LoggerFactory.getLogger(RestEasyCleanup.class);

        private final HttpContextBuilder httpContextBuilder;
        private final HttpServer httpServer;

        public RestEasyCleanup(final HttpContextBuilder httpContextBuilder, final HttpServer httpServer)
        {
            this.httpContextBuilder = httpContextBuilder;
            this.httpServer = httpServer;
        }

        @Override
        public void run()
        {
            log.debug("Shutting down...");
            httpContextBuilder.cleanup();
            httpServer.stop(0);
        }
    }
}
