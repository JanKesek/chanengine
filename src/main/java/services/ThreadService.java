package services;

import models.SessionUtils;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ThreadService {
    private Session session=SessionUtils.getSession();
    public List<Thread> getAllThreads(String shortName) {
        Query query=session.createQuery("FROM thread where shorter= '" +shortName+ "'");

    }
}
