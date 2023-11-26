package DAL.DAO;

import java.util.List;
import DAL.Entity.Class;

public interface ClassDAO
{
    public boolean addClass(Class cla);

    public boolean updateClass(Class cla);

    public boolean deleteClassbyID(int id);

    public Class getClassbyID(int id);

    public Class getClassbyName(String name);

    public List<Class> getAllClass();

}