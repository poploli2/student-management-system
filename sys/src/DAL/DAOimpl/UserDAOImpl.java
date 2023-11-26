package DAL.DAOimpl;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAL.DBUtil;
import DAL.Entity.User;
import DAL.DAO.UserDAO;

public class UserDAOImpl implements DAL.DAO.UserDAO
{

    @Override
    public boolean addUser(User user) {
        String insert="insert into user(user_id,password) values('"+user.getUserId()+"','"+user.getPassword()+"')";
        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    @Override
//    public boolean updateUser(User user) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public User getUserbyID(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public List<User> getallUser() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
public boolean deleteUserbyId(String id) {
    String delete = "delete from user where user_id = " + id;
    try {
        DBUtil.runUpdate(delete);
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}
    @Override
    public boolean certifyUser(String userId, String password) {
        String select="select * from user where user_id='"+userId+"' and password='"+password+"'";
        boolean isCertifyUser=false;
        try {
            ResultSet rs=DBUtil.runQuery(select);
            if(rs!=null)
            {
                isCertifyUser=rs.next();
                DBUtil.releaseAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCertifyUser;
    }

}