package services;

import models.Board;
import models.Post;
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
@RequestScoped
//@SessionScoped
public class ThreadService {

    private static Session session=new SessionUtils().getSession();
    //private Session session=SessionUtils.getSession();
    //@Inject
    private static Board board;
    //public ThreadService() {}
    public static List<Thread> getAllThreadsFromBoard(long id) {
        //Query query=session.createQuery("FROM thread where shorter= '" +shortName+ "'");
        board=session.get(Board.class, id);
        return board.getThreads();
    }
    public static void insertThreadToBoard(long board_id, Thread thread) {
        thread.setBoard(BoardService.getBoardById(board_id));
        PostService.createOP(thread);
        session.beginTransaction();
        session.save(thread);
        session.getTransaction().commit();
    }
    public static Thread getThreadById(long id, Session shared) {
        //session.beginTransaction();
        Thread thread= shared.get(Thread.class,id);
        //ession.getTransaction().commit();
        return thread;
    }
}
