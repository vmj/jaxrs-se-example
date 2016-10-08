package fi.linuxbox.jaxrs.se.resteasy.jdk

import com.sun.net.httpserver.*
import fi.linuxbox.jaxrs.se.resources.*
import groovy.util.logging.*
import org.jboss.resteasy.plugins.server.sun.http.*

@Slf4j
class Boot
{
    static void main(String[] args)
            throws IOException, InterruptedException
    {
        log.debug("Setting up JDK HTTP server and RestEasy")
        final HttpServer httpServer = HttpServer.create(new InetSocketAddress(9000), 0)

        final HttpContextBuilder contextBuilder = new HttpContextBuilder()

        contextBuilder.deployment.actualResourceClasses.add(IndexResource)

        final HttpContext context = contextBuilder.bind(httpServer)

        log.debug("Starting HTTP server")
        httpServer.start()

        addShutdownHook {
            log.debug("Shutting down...")
            contextBuilder.cleanup()
            httpServer.stop(0)
        }

        final Object lock = new Object()
        synchronized (lock) { lock.wait() }
    }
}
