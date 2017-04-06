package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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

        String studenJson = Request.Get(url).execute().returnContent().asString();
        String courseJson = Request.Get("https://ohtustats2017.herokuapp.com/courses/1.json").execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(studenJson, Submission[].class);
        CourseInfo course = mapper.fromJson(courseJson, CourseInfo.class);
        
        System.out.println("Kurssi: " + course + "\n");
        System.out.println("opiskelijanumero: " + studentNr + "\n");
        
        int totalHours = 0, totalDone = 0;

        for (Submission submission : subs) {
            Set<Integer> done = submission.getDoneExcercises();
            int week = submission.getWeek();
            totalHours += submission.getHours();
            totalDone += done.size();
            
            System.out.println("viikko " + week
                    + ": tehtyjä tehtäviä yhteensä: " + done.size() + " (maksimi " + course.getClass().getMethod("getWeek"+week).invoke(course) + ")"
                    + ", aikaa kului " + submission.getHours() + " tuntia, tehdyt tehtävät: " + done);
        }
        
        System.out.println("\nyhteensä: " + totalDone + " tehtävää " + totalHours + " tuntia");
    }
}
