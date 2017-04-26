
package statistics.matcher;

public class MatchBuilder {
    private Matcher matcher;

    public MatchBuilder() {
        this.matcher = new Any();
    }
    
    public MatchBuilder playsIn(String team) {
        matcher = new PlaysIn(matcher, team);
        return this;
    }
    
    public MatchBuilder hasAtLeast(int value, String property) {
        matcher = new HasAtLeast(matcher, value, property);
        return this;
    }
    
    public MatchBuilder hasFewerThan(int value, String property) {
        matcher = new HasFewerThan(matcher, value, property);
        return this;
    }
    
    public MatchBuilder not(Matcher matcher) {
        this.matcher = new Not(matcher);
        return this;
    }
    
    public MatchBuilder oneOf(Matcher ...matchers) {
        matcher = new Or(matchers);
        return this;
    }
            
    public Matcher build() {
        Matcher built = matcher;
        matcher = new Any();
        return built;
    }
}
