package services;

import jdk.jfr.Name;
import models.Board;
import models.SessionUtils;
import models.Thread;
import org.hibernate.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;
import java.util.List;

@Named
//@ManagedBean
//@RequestScoped
//@SessionScoped
public class ThreadService {

    private Session session=SessionUtils.getSession();
    //private Session session=SessionUtils.getSession();
    @Inject
    private Board board;
    public ThreadService() {}
    public List<Thread> getAllThreadsFromBoard(long id) {
        //Query query=session.createQuery("FROM thread where shorter= '" +shortName+ "'");
        board=session.get(Board.class, id);
        return board.getThreads();
    }
}
