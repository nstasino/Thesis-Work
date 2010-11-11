package json2java;

import java.io.IOException;
import java.io.File;
import java.io.StringWriter;

import org.codehaus.jackson.*;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.JsonGenerator;

/**
 * Core decoding class using the Jackson API
 * 
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0720
 * @since       1.6
 */
public class DecodeJSON {

    private ObjectMapper mapper = new ObjectMapper(); // call jackson objectmapper
    private JsonFactory jf = new JsonFactory();

    /**
     * Use JsonMapper to get data from JSON file
     *
     * @param f JSON file to read from
     * @return Ticket Object with the Data
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     * */
    public Ticket decode(File f) throws JsonMappingException, JsonParseException, IOException {

        return mapper.readValue(f, Ticket.class);
    }

    /**
     * 
     * @param pojo Bean to be transcribed
     * @param prettyPrint Boolean Value, true to have a human readable JSON output
     * @return String with the exact content of the JSON File
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @throws IOException
     */
    public String toJson(Object pojo, boolean prettyPrint)
            throws JsonMappingException, JsonGenerationException, IOException {

        StringWriter sw = new StringWriter();
        JsonGenerator jg = jf.createJsonGenerator(sw);
        if (prettyPrint) {
            jg.useDefaultPrettyPrinter();
        }
        mapper.writeValue(jg, pojo);
        return sw.toString();
    }
///**
//     * Obsolete functions
//     */
//    void decode3() {
//
//        JsonFactory f = new MappingJsonFactory();
//        try {
//            JsonParser jp = f.createJsonParser(s);
//
//            JsonToken current;
//
//            current = jp.nextToken();
//            if (current != JsonToken.START_OBJECT) {
//                System.out.println("Error: root should be object: quiting.");
//                return;
//            }
//
//            while (jp.nextToken() != JsonToken.END_OBJECT) {
//                String fieldName = jp.getCurrentName();
//                current = jp.nextToken();
//                if (fieldName.equals("records")) {
//                    if (current == JsonToken.START_ARRAY) {
//                        while (jp.nextToken() != JsonToken.END_ARRAY) {
//                            JsonNode node = jp.readValueAsTree();
//                            System.out.println("field1: " + node.get("field1").getValueAsText());
//                            System.out.println("field2: " + node.get("field2").getValueAsText());
//
//                        }
//                    } else {
//                        System.out.println("Error: records should be an array: skipping.");
//                        jp.skipChildren();
//                    }
//                } else if (fieldName.equals("special message")) {
//
//                    System.out.println("special message : " + jp.getText());
//                    jp.skipChildren();
//                } else {
//                    System.out.println("Unprocessed property: " + fieldName);
//                    jp.skipChildren();
//                }
//
//            }
//        } catch (IOException e) {
//            System.out.println("No input given!");
//        }
//    }
}
