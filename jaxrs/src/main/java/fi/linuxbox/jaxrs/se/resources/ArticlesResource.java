package fi.linuxbox.jaxrs.se.resources;

import fi.linuxbox.jaxrs.se.model.*;
import java.util.*;
import javax.ws.rs.*;
import org.slf4j.*;

import static javax.ws.rs.core.MediaType.*;

public class ArticlesResource
{
    private final Logger log = LoggerFactory.getLogger(ArticlesResource.class);

    @GET
    @Produces(APPLICATION_JSON)
    public Articles list() {
        log.info("Returning article list");
        return articles(
                article("Title 1", "Bla bla"),
                article("Title 2", "Bla bla"),
                article("Title 3", "Bla bla")
        );
    }

    private static Articles articles(final Article... items) {
        final Articles articles = new Articles();
        articles.setArticles(Arrays.asList(items));
        return articles;
    }

    private static Article article(final String title, final String body) {
        final Article article = new Article();
        article.setTitle(title);
        article.setBody(body);
        return article;
    }
}
