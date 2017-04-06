package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }
        if (!studentNr.matches("^\\d+$")) {
            System.err.println("Argument must be an integer");
            return;
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("opiskelijanumero: " + studentNr);
        int totalHours = 0, totalDone = 0;
        
        for (Submission submission : subs) {
            totalHours += submission.getHours();
            totalDone += submission.getDoneExcercises().size();
            
            System.out.println(submission);
        }
        System.out.println("yhteensä: " + totalDone + " tehtävää " + totalHours + " tuntia");
    }
}
