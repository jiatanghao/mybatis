package org.mybatis.dao.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.bean.Student;
import org.mybatis.dao.IStudentDao;
import org.mybatis.utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {
    private IStudentDao studentDao;
    private SqlSession sqlSession;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);
    }

    @Test
    public void testInsertStudent() {
        Student student = new Student("周慧敏", 31, 99.5);

        boolean result = studentDao.insertStudent(student);

        Assert.assertTrue(result);
    }

    @Test
    public void testInsertStudentCachedId() {
        Student student = new Student("周慧敏", 31, 99.5);
        System.out.println(student);
        boolean result = studentDao.insertStudentCachedId(student);
        System.out.println(student);
        Assert.assertTrue(result);
    }

    @Test
    public void testDeleteStudent() {
        boolean result = studentDao.deleteStudentById(17);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student("刘亦菲", 18, 100);
        student.setId(8);
        boolean result = studentDao.updateStudent(student);
        Assert.assertTrue(result);
    }

    @Test
    public void testSelectAllStudents() {
        List<Student> students = studentDao.selectAllStudents();
        Assert.assertEquals(12, students.size());
    }


    @Test
    public void testSelectStudentById() {
        Student student = studentDao.selectStudentById(1);
        System.out.println(student);
    }

    @Test
    public void testSelectStudentsByName() {
        List<Student> students = studentDao.selectStudentByName("王");
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectStudentsByCondition() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王");
        map.put("age", 27);
        Student student = new Student();
        student.setScore(99);
        map.put("student", student);
        List<Student> students = studentDao.selectStudentsByCondition(map);
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectStudentsByIndex() {
        List<Student> students = studentDao.selectStudentsByIndex("王", 27);
        students.forEach(System.out::println);
    }

    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}
