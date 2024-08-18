import java.util.ArrayList;
import java.util.List;

class SchedulingSystem {
    private List<Courses> courses;
    private List<Instructors> instructors;
    private List<Classrooms> classrooms;

    public SchedulingSystem() {
        courses = new ArrayList<>();
        instructors = new ArrayList<>();
        classrooms = new ArrayList<>();
    }

    // Course Management
    public void addCourse(Courses course) {
        courses.add(course);
    }

    public void removeCourse(String courseId) {
        courses.removeIf(course -> course.id.equals(courseId));
    }

    // Linear search algorithm to find courses by their attributes
    public List<Courses> searchCourses(String attribute, String value) {
        ArrayList<Object> result = new ArrayList<>();
        for (Courses course : courses) {
            if (!(!course.name.contains(value) && !course.id.contains(value))) {
                result.add(courses);
            }
        }
        return null;
    }

    // Insertion sort to organize courses by their time slots
    public void sortCoursesByTimeSlot() {
        for (int i = 1; i < courses.size(); i++) {
            Courses key = courses.get(i);
            int j = i - 1;
            while (j >= 0 && courses.get(j).timeSlot > key.timeSlot) {
                courses.set(j + 1, courses.get(j));
                j--;
            }
            courses.set(j + 1, key);
        }
    }

    // Instructor Management
    public void addInstructor(Instructors instructor) {
        instructors.add(instructor);
    }

    public void removeInstructor(String instructorId) {
        instructors.removeIf(instructor -> instructor.id.equals(instructorId));
    }

    // Linear search to find instructors by their name or ID
    public Instructors searchInstructor(String nameOrId) {
        for (Instructors instructor : instructors) {
            if (instructor.name.equals(nameOrId) || instructor.id.equals(nameOrId)) {
                return instructor;
            }
        }
        return null;
    }

    // Classroom Management
    public void addClassroom(Classrooms classroom) {
        classrooms.add(classroom);
    }

    // Allocate classroom to a course
    public boolean allocateClassroom(String classroomName, Courses course) {
        for (Classrooms classroom : classrooms) {
            if (classroom.name.equals(classroomName)) {
                // Check for conflicts
                if (!classroom.schedule.containsKey(course.timeSlot)) {
                    classroom.schedule.put(course.timeSlot, course);
                    return true;
                }
            }
        }
        return false;
    }

    // Check for scheduling conflicts
    public boolean hasConflict(Classrooms classroom, Courses course) {
        return classroom.schedule.containsKey(course.timeSlot);
    }

    // Main method to demonstrate the system
    public static void main(String[] args) {
        SchedulingSystem system = new SchedulingSystem();

        // Add courses
        system.addCourse(new Courses("Math 101", "MATH101", 1));
        system.addCourse(new Courses("Physics 201", "PHYS201", 2));
        system.addCourse(new Courses("Computer Science 301", "CS301", 3));

        // Add instructors
        Instructors instructor1 = new Instructors("John Doe", "INST001");
        instructor1.availableTimes.add(1);
        instructor1.availableTimes.add(2);
        system.addInstructor(instructor1);

        // Add classrooms
        system.addClassroom(new Classrooms("Room A"));
        system.addClassroom(new Classrooms("Room B"));

        // Demonstrate course search
        List<Courses> searchResult = system.searchCourses("name", "Math");
        System.out.println("Search results for 'Math':");
        for (Courses course : searchResult) {
            System.out.println(course.name);
        }

        // Sort courses
        system.sortCoursesByTimeSlot();
        System.out.println("\nSorted courses:");
        for (Courses course : system.courses) {
            System.out.println(course.name + " - Time slot: " + course.timeSlot);
        }

        // Allocate classrooms
        boolean allocated = system.allocateClassroom("Room A", system.courses.get(0));
        System.out.println("\nAllocation successful: " + allocated);

        // Check for conflicts
        boolean hasConflict = system.hasConflict(system.classrooms.get(0), system.courses.get(1));
        System.out.println("Conflict detected: " + hasConflict);
    }
}