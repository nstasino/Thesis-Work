package json2java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
//import java.lang.Math;

//import org.json.JSONException;      // JSON library from http://www.json.org/java/
import org.json.JSONObject;

public class Google {

    public double NGD(String term1, String term2) {
        Long M = 10000000000L; //8058044651L
        double freqx = logResults(term1);
        double freqy = logResults(term2);
        String xy = term1.concat("+").concat(term2);
        double freqxy = logResults(xy);
        if (freqx == Double.NEGATIVE_INFINITY || freqy == Double.NEGATIVE_INFINITY) {
            return 100000;
        } else {
            double num = Math.max(freqx, freqy) - freqxy;
            double den = Math.log10(M) - Math.min(freqx, freqy);

            double formula = num / den;
            return formula;
        }
    }

    // // Put your website here
// private final String HTTP_REFERER = "http://www.example.com/";
    public double logResults(String term) {
        System.out.println(term + "\t" + Math.log10(makeQuery(term)));
        return Math.log10(makeQuery(term));

    }

    private long makeQuery(String query) {

//        System.out.println("\nQuerying for " + query);
        try {
            // Convert spaces to +, etc. to make a valid URL
            query = URLEncoder.encode(query, "UTF-8");

            URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=" + query);
            URLConnection connection = url.openConnection();

            // Get the JSON response
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(//remember to remove InputStreamReader for perfomance tweak, even more for bufferedreader
                    new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            String response = builder.toString();
            JSONObject json = new JSONObject(response);

            if (json.getJSONObject("responseData").getJSONObject("cursor").has("estimatedResultCount")) {
                long results = Long.valueOf(json.getJSONObject("responseData").getJSONObject("cursor").getString("estimatedResultCount"));
                return results;
            } else {
                long results = 0;
                return results;
            }
        } catch (Exception e) {
            System.err.println("Something went wrong...");
            e.printStackTrace();
            long results = -1;
            return results;
        }
    }
}
