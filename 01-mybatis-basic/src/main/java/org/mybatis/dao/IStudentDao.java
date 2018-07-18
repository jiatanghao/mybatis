package org.mybatis.dao;

import org.mybatis.bean.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    boolean insertStudent(Student student);

    boolean insertStudentCachedId(Student student);

    boolean deleteStudentById(int id);

    boolean updateStudent(Student student);

    List<Student> selectAllStudents();

    Map<String, Object> selectAllStudentsMap();

    Student selectStudentById(int id);

    List<Student> selectStudentByName(String name);

}
