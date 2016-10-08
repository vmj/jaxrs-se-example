package fi.linuxbox.jaxrs.se.jersey.jdk;

import com.sun.net.httpserver.*;
import fi.linuxbox.jaxrs.se.resources.*;
import java.net.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.jdkhttp.*;
import org.glassfish.jersey.server.*;
import org.slf4j.*;

public class Boot {
    private final static Logger log = LoggerFactory.getLogger(Boot.class);

    public static void main(String[] args) {
        log.debug("Setting up JDK HTTP server and Jersey");
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9000).build();
        ResourceConfig resourceConfig = new ResourceConfig(IndexResource.class);
        final HttpServer httpServer = JdkHttpServerFactory.createHttpServer(baseUri, resourceConfig, false);

        log.debug("Starting HTTP server");
        httpServer.start();
    }
}
