package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();

    void addCourse(Course course);

    Course getCourseById(long id);

    void updateCourse(Course course);

    void deleteCourse(Course course);
}
