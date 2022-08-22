package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);

    }

    @Override
    public Course getCourseById(long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
       courseDao.updateCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
       courseDao.deleteCourse(course);
    }
}
