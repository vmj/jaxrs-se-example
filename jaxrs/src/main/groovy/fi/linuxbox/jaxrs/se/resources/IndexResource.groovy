package fi.linuxbox.jaxrs.se.resources

import javax.ws.rs.*
import javax.ws.rs.container.*
import javax.ws.rs.core.*

@Path("/")
class IndexResource {
    @Context
    private ResourceContext ctx

    @Path("articles")
    ArticlesResource publications() {
        ctx.getResource(ArticlesResource)
    }

    @Path("notifications")
    InquiriesResource notifications() {
        ctx.getResource(InquiriesResource)
    }
}
