package model;

import java.util.List;

/**
 * Created by DiZi on 25.11.2015.
 */
public class OptionalCourse {

    private long id;
    private String name;
    private List<Student> listOfStudents;
    private Lecturer lecturer;
    private String courseDescription;

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
