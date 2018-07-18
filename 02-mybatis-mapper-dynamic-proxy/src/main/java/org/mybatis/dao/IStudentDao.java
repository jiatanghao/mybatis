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

    Student selectStudentById(int id);

    List<Student> selectStudentByName(String name);

    List<Student> selectStudentsByCondition(Map<String, Object> conditions);

    List<Student> selectStudentsByIndex(String name, int age);

}
