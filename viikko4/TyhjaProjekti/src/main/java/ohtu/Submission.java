package ohtu;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Submission {

    private String student_number;
    private Boolean a1;
    private Boolean a2;
    private Boolean a3;
    private Boolean a4;
    private Boolean a5;
    private Boolean a6;
    private Boolean a7;
    private Boolean a8;
    private Boolean a9;
    private Boolean a10;
    private Boolean a11;
    private Boolean a12;
    private Boolean a13;
    private Boolean a14;
    private Boolean a15;
    private Boolean a16;
    private Boolean a17;
    private Boolean a18;
    private Boolean a19;
    private Boolean a20;
    private Boolean a21;
    private int week;
    private int hours;
    private Set<Integer> done = new HashSet<>();

    public int getWeek() {
        return week;
    }

    public int getHours() {
        return hours;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public Set<Integer> getDoneExcercises() {
        Field[] fields = Submission.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Pattern p = Pattern.compile("^a(\\d+)$");
            Matcher m = p.matcher(fields[i].getName());
            
            try {
                if(m.matches() && fields[i].get(this) != null) {
                    done.add(Integer.parseInt(m.group(1)));
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return done;
    }

    @Override
    public String toString() {
        
        if(done.isEmpty())
            getDoneExcercises();
        
        String out = "viikko " + week
         + ": tehtyjä tehtäviä yhteensä: " + done.size()
         + ", aikaa kului "+ hours + " tuntia, tehdyt tehtävät: " + done;
        
        return out;
    }

}
