package fi.linuxbox.jaxrs.se.model;

/**
 *
 */
public class Article
{
    private String title;
    private String body;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(final String body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return "Article{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
