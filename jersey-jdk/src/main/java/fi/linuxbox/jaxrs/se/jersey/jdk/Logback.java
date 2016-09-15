package fi.linuxbox.jaxrs.se.jersey.jdk;

import ch.qos.logback.classic.*;
import ch.qos.logback.core.status.*;
import ch.qos.logback.core.util.*;

import static ch.qos.logback.classic.Level.*;

public class Logback
        extends BasicConfigurator
{
    public Logback()
    {
        super();
    }

    @Override
    public void configure(final LoggerContext lc) {
        super.configure(lc);
        lc.getLogger(getClass()).setLevel(DEBUG);

        StatusPrinter.print(lc);
        lc.getStatusManager().add(new OnConsoleStatusListener());
    }
}
