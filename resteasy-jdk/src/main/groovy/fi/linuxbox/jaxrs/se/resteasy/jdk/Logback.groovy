package fi.linuxbox.jaxrs.se.resteasy.jdk

import ch.qos.logback.classic.*
import ch.qos.logback.core.status.*
import ch.qos.logback.core.util.*

import static ch.qos.logback.classic.Level.DEBUG

class Logback extends BasicConfigurator
{
    public Logback()
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
