package json2java;

/**
 *
 * @author nikos
 */
import java.io.IOException;
import org.htmlcleaner.*;

public class StripHTMLTags {

    /**
     * Strips original_body_html attribute to formatted sentences using
     * htmlcleaner API
     * 
     * @param html
     * @return
     * @throws IOException
     * @throws XPatherException
     */
    public String stripHTMLtags(String html) throws IOException, XPatherException {

        // create an instance of HtmlCleaner
        HtmlCleaner cleaner = new HtmlCleaner();

// take default cleaner properties
        CleanerProperties props = cleaner.getProperties();

// customize cleaner's behaviour with property setters
//props.setXXX(...);

//Saving the day here
        if (html == null) {
            html = "";
        }

        TagNode root = cleaner.clean(html); //Order the cleanup

        String str = "";
        Object[] found = root.evaluateXPath("//div/p");//search for new sentences (eg <p> tags) usoing XPath notation
        if ((found.length > 0)) {
            for (int i = 0; i < found.length; i++) {

                TagNode node = (TagNode) found[i];
                str = str + (node.getText().toString()) + "\n";
            }

        } else {
//            System.out.println("*******"+found.length);
        }
        return str;
    }
}