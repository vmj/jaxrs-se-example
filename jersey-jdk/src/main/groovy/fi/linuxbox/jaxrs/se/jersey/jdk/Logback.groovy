package fi.linuxbox.jaxrs.se.jersey.jdk

import ch.qos.logback.classic.*
import ch.qos.logback.core.status.*
import ch.qos.logback.core.util.*
import groovy.transform.CompileStatic

import static ch.qos.logback.classic.Level.*

@CompileStatic
class Logback
        extends BasicConfigurator
{
    Logback()
    {
        super()
    }

    @Override
    void configure(final LoggerContext lc) {
        super.configure(lc)
        lc.getLogger(getClass()).level = DEBUG

        StatusPrinter.print(lc)
        lc.statusManager.add(new OnConsoleStatusListener())
    }
}
