package org.mybatis.dao;

import org.mybatis.bean.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> selectStudentByIf(Student student);

    List<Student> selectStudentsByWhere(Student student);

    List<Student> selectStudentsByChoose(Student student);

    List<Student> selectStudentsByForEach(int ... ids);

    List<Student> selectStudentsByForEachList(List<Integer> list);
}
