package org.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.bean.Student;
import org.mybatis.dao.IStudentDao;
import org.mybatis.utils.MyBatisUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements IStudentDao {
    private SqlSession sqlSession = null;

    @Override
    public boolean insertStudent(Student student) {
        boolean ret;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            int result = sqlSession.insert("insertStudent", student);
            sqlSession.commit();
            ret = result > 0;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return ret;
    }

    @Override
    public boolean insertStudentCachedId(Student student) {
        boolean ret;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            int result = sqlSession.insert("insertStudentCachedId", student);
            sqlSession.commit();
            ret = result > 0;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return ret;
    }

    @Override
    public boolean deleteStudentById(int id) {
        boolean ret;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            int result = sqlSession.insert("deleteStudentById", id);
            sqlSession.commit();
            ret = result > 0;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return ret;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean ret;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            int result = sqlSession.update("updateStudent", student);
            sqlSession.commit();
            ret = result > 0;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return ret;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            students = sqlSession.selectList("selectAllStudents");
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return students;
    }

    @Override
    public Map<String, Object> selectAllStudentsMap() {
        Map<String, Object> map;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            map = sqlSession.selectMap("selectAllStudents", "id");
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return map;
    }

    @Override
    public Student selectStudentById(int id) {
        Student student;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            student = sqlSession.selectOne("selectStudentById", 1);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return student;
    }

    @Override
    public List<Student> selectStudentByName(String name) {
        List<Student> students;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            students = sqlSession.selectList("selectStudentByName", name);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return students;
    }
}
