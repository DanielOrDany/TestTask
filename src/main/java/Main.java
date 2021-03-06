import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import persistant.SessionManager;
import views.IntroView;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {

    public static void main(final String[] args) {
        try (Session session = SessionManager.getSession()) {
            new IntroView(session).show();
        }
    }
}