package fi.linuxbox.jaxrs.se.jersey.jdk

import com.sun.net.httpserver.*
import fi.linuxbox.jaxrs.se.resources.*
import groovy.transform.CompileStatic
import groovy.util.logging.*
import javax.ws.rs.core.*
import org.glassfish.jersey.jdkhttp.*
import org.glassfish.jersey.server.*

@CompileStatic
@Slf4j
class Boot {
    static void main(String[] args) {
        log.debug("Setting up JDK HTTP server and Jersey")
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9000).build()
        ResourceConfig resourceConfig = new ResourceConfig(IndexResource)
        final HttpServer httpServer = JdkHttpServerFactory.createHttpServer(baseUri, resourceConfig, false)

        log.debug("Starting HTTP server")
        httpServer.start()
    }
}
