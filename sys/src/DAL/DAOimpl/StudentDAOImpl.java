package DAL.DAOimpl;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAL.DBUtil;
import DAL.Entity.Student;
import DAL.DAO.StudentDAO;

public class StudentDAOImpl implements DAL.DAO.StudentDAO {

    @Override
    public boolean addStudent(Student stu) {
        String insert = "insert into student(student_id, name, gender, ethnicity, class_id) "
                + "values('" + stu.getStudentId() + "','" + stu.getName() + "','" + stu.getGender() + "','"
                + stu.getEthnicity() + "'," + stu.getClassId() + ")";

        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student stu) {
        String update = "update student set name='" + stu.getName() + "', gender='" + stu.getGender()
                + "', ethnicity='" + stu.getEthnicity() + "', class_id=" + stu.getClassId() + " where student_id='"
                + stu.getStudentId() + "'";
        System.out.println(update);
        try {
            DBUtil.runUpdate(update);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteStudentbyID(int id) {
        String delete = "delete from student where student_id = '" + id + "'";

        try {
            DBUtil.runUpdate(delete);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Student getStudentbyID(int id) {
        String select = "select * from student where student_id='" + id + "'";
        try {
            Student student = new Student();
            ResultSet rs = DBUtil.runQuery(select);

            if (rs.next()) {
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setEthnicity(rs.getString("ethnicity"));
                student.setClassId(rs.getInt("class_id"));
            } else {
                return null;
            }

            DBUtil.releaseAll();
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, "检索时出错", ex);
            return null;
        }
    }



    public List<Student> getStudentbyAny(String column,String content) {
        String select = "SELECT * FROM student WHERE " + column + " = '" + content + "'";

//        System.out.println(select);
        try {
            List<Student> students = new ArrayList<>();
            ResultSet rs = DBUtil.runQuery(select);
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setEthnicity(rs.getString("ethnicity"));
                student.setClassId(rs.getInt("class_id"));
                students.add(student);
            }
            DBUtil.releaseAll();
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public List<Student> getAllStudent() {
        String select = "select * from student";
        try {
            List<Student> students = new ArrayList<>();
            ResultSet rs = DBUtil.runQuery(select);
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setEthnicity(rs.getString("ethnicity"));
                student.setClassId(rs.getInt("class_id"));
                students.add(student);
            }
            DBUtil.releaseAll();
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
