package fi.linuxbox.jaxrs.se.resources

import fi.linuxbox.jaxrs.se.model.*
import groovy.util.logging.*
import javax.ws.rs.*
import javax.ws.rs.core.*

import static javax.ws.rs.core.MediaType.*

@Slf4j
class InquiriesResource
{
    @POST
    @Consumes(APPLICATION_JSON)
    Response send(final Inquiry inquiry) {
        log.info("Inquiry received: $inquiry")
        Response.accepted().build()
    }
}
