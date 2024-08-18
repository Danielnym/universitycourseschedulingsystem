import java.util.HashSet;
import java.util.Set;

public class Instructors {
    String name;
    String id;
    Set<Integer> availableTimes = new HashSet<>();

    public Instructors(String name, String id) {
        this.name = name;
        this.id = id;
    }
}