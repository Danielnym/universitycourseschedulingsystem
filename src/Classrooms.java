import java.util.HashMap;
import java.util.Map;

class Classrooms {

    String name;
    Map<Integer, Courses> schedule;

    public Classrooms(String name) {
        this.name = name;
        this.schedule = new HashMap<>();
    }
}