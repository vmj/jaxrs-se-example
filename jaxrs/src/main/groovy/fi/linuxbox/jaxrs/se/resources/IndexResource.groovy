package fi.linuxbox.jaxrs.se.resources

import groovy.transform.CompileStatic
import javax.ws.rs.*
import javax.ws.rs.container.*
import javax.ws.rs.core.*

@CompileStatic
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
