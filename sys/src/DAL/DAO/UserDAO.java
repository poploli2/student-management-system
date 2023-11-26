package DAL.DAO;

import java.util.List;
import DAL.Entity.User;

public interface UserDAO
{
    public boolean addUser(User user);

//    public boolean updateUser(User user);

//    public User getUserbyID(int id);

//    public List<User> getallUser();
    public boolean deleteUserbyId(String id);
    public boolean certifyUser(String userId,String password);

}