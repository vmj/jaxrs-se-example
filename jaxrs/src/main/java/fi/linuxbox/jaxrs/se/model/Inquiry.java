package fi.linuxbox.jaxrs.se.model;

/**
 *
 */
public class Inquiry
{
    private String text;

    public String getText()
    {
        return text;
    }

    public void setText(final String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "Inquiry{" +
                "text='" + text + '\'' +
                '}';
    }
}
