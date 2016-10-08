package fi.linuxbox.jaxrs.se.resources

import fi.linuxbox.jaxrs.se.model.*
import groovy.util.logging.*
import javax.ws.rs.*

import static javax.ws.rs.core.MediaType.*

@Slf4j
class ArticlesResource
{
    @GET
    @Produces(APPLICATION_JSON)
    Articles list() {
        log.info("Returning article list")
        new Articles(articles: [
                new Article(title: "Title 1", body: "Bla bla"),
                new Article(title: "Title 2", body: "Bla bla"),
                new Article(title: "Title 3", body: "Bla bla")
        ]);
    }
}
