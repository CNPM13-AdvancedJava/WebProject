package controller;
import entities.Userkey;
import java.util.ArrayList;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ControllerLogin {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public List<Userkey> checkUser(String userName, String password) {
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username and user_password = :password";
            Query query = session.createQuery(sql);
            query.setParameter("username", userName);
            query.setParameter("password", password);
            lstUser = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstUser;
    }

    public List<Userkey> checkEmail(String email) {
        List<Userkey> lstEmail = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username";
            Query query = session.createQuery(sql);
            query.setParameter("username", email);
            lstEmail = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
        return lstEmail;
    }

    public List<Userkey> checkUserAdmin(String userName, String password) {
        List<Userkey> lstUser = new ArrayList<Userkey>();
        try {
            session.beginTransaction();
            String sql = "from Userkey where user_name = :username and user_password = :password and rank_id = :rankId";
            Query query = session.createQuery(sql);
            query.setParameter("username", userName);
            query.setParameter("password", password);
            query.setParameter("rankId", 1);
            lstUser = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstUser;
    }
}
