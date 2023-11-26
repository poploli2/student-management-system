package DAL.DAOimpl;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAL.DAO.ClassDAO;
import DAL.DBUtil;
import DAL.Entity.Class;
import DAL.DAO.ClassDAO;

public class ClassDAOImpl implements ClassDAO {

    @Override
    public boolean addClass(Class classObj) {
        String insert = "insert into class(class_id, class_name) "
                + "values(" + classObj.getClassId() + ",'" + classObj.getClassName() + "')";

        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateClass(Class classObj) {
        String update = "update class set class_name='" + classObj.getClassName() + "' where class_id=" + classObj.getClassId();
        try {
            DBUtil.runUpdate(update);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteClassbyID(int id) {
        String delete = "delete from class where class_id = " + id;
        try {
            DBUtil.runUpdate(delete);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Class getClassbyID(int id) {
        String select = "select * from class where class_id=" + id;
        try {
            Class classObj = new Class();
            ResultSet rs = DBUtil.runQuery(select);
            while (rs.next()) {
                classObj.setClassId(rs.getInt("classId"));
                classObj.setClassName(rs.getString("className"));
            }
            DBUtil.releaseAll();
            return classObj;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Class getClassbyName(String name) {
        String select = "select * from class where class_name='" + name + "'";
        try {
            Class classObj = new Class();
            ResultSet rs = DBUtil.runQuery(select);
            while (rs.next()) {
                classObj.setClassId(rs.getInt("classId"));
                classObj.setClassName(rs.getString("className"));
            }
            DBUtil.releaseAll();
            return classObj;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Class> getAllClass() {
        String select = "select * from class";
        try {
            List<Class> classes = new ArrayList<>();
            ResultSet rs = DBUtil.runQuery(select);
            while (rs.next()) {
                Class classObj = new Class();
                classObj.setClassId(rs.getInt("classId"));
                classObj.setClassName(rs.getString("className"));
                classes.add(classObj);
            }
            DBUtil.releaseAll();
            return classes;
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
