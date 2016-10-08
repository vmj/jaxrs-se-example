package fi.linuxbox.jaxrs.se.resources;

import javax.ws.rs.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;

@Path("/")
public class IndexResource {
    @Context
    private ResourceContext ctx;

    @Path("articles")
    public ArticlesResource publications() {
        return ctx.getResource(ArticlesResource.class);
    }

    @Path("notifications")
    public InquiriesResource notifications() {
        return ctx.getResource(InquiriesResource.class);
    }
}
