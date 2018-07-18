package org.mybatis.dao.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.bean.Student;
import org.mybatis.dao.IStudentDao;
import org.mybatis.utils.MyBatisUtils;

import java.util.Arrays;
import java.util.List;

public class StudentDaoTest {
    private IStudentDao studentDao;
    private SqlSession sqlSession;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        studentDao = sqlSession.getMapper(IStudentDao.class);
    }

    @Test
    public void testIf() {
        Student student = new Student();
        student.setName("王");
        student.setAge(27);
        List<Student> students = studentDao.selectStudentByIf(student);
        students.forEach(System.out::println);
    }

    @Test
    public void testWhere() {
        Student student = new Student();
        /*student.setName("      ");
        student.setAge(27);*/
        List<Student> students = studentDao.selectStudentsByWhere(student);
        students.forEach(System.out::println);
    }

    @Test
    public void testChoose() {
        Student student = new Student();
        List<Student> students = studentDao.selectStudentsByChoose(student);
        Assert.assertEquals(0, students.size());
        student.setAge(27);
        students = studentDao.selectStudentsByChoose(student);
        students.forEach(System.out::println);
        student.setName("王");
        students = studentDao.selectStudentsByChoose(student);
        students.forEach(System.out::println);

    }

    @Test
    public void testForEach() {
        int[] ids = {1, 3, 5};
        List<Student> students = studentDao.selectStudentsByForEach(ids);
        students.forEach(System.out::println);

    }

    @Test
    public void testForEachList() {
        List<Integer> list = Arrays.asList(1, 3, 5);
        List<Student> students = studentDao.selectStudentsByForEachList(list);
        students.forEach(System.out::println);
    }

    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();
    }
}
