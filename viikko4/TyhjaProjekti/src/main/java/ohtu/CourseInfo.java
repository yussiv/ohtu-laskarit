
package ohtu;

public class CourseInfo {
    private String name;
    private String term;
    private String week1;
    private String week2;
    private String week3;
    private String week4;
    private String week5;
    private String week6;

    public String getWeek1() {
        return week1;
    }

    public String getWeek2() {
        return week2;
    }

    public String getWeek3() {
        return week3;
    }

    public String getWeek4() {
        return week4;
    }

    public String getWeek5() {
        return week5;
    }

    public String getWeek6() {
        return week6;
    }

    @Override
    public String toString() {
        return name + ", " + term;
    }
    
}
