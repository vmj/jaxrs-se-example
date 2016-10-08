package fi.linuxbox.jaxrs.se.resources;

import fi.linuxbox.jaxrs.se.model.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.slf4j.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class InquiriesResource
{
    private final Logger log = LoggerFactory.getLogger(InquiriesResource.class);

    @POST
    @Consumes(APPLICATION_JSON)
    public Response send(final Inquiry inquiry) {
        log.info("Inquiry received: " + inquiry.toString());
        return Response.accepted().build();
    }
}
