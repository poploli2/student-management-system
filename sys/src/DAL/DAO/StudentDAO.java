package DAL.DAO;

import java.util.List;
import DAL.Entity.Student;

public interface StudentDAO
{
    public boolean addStudent(Student stu);

    public boolean updateStudent(Student stu);

    public boolean deleteStudentbyID(int id);

    public Student getStudentbyID(int id);

    public List<Student> getAllStudent();

    public List<Student> getStudentbyAny(String column,String content);

}