package services;


import models.Board;
import models.SessionUtils;
import org.hibernate.Session;

import org.hibernate.query.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Singleton
public class BoardService {
    //private Board boardbean;
    //@Inject
    //public BoardService(Board board) { this.boardbean=board;}
    //public BoardService(){}
    //@PersistenceContext
    //private Session session=SessionUtils.getSession();
    private static Session session = new SessionUtils().getSession();
    public static List<Board> getAllBoards() {
        Map<String, String> boardIds=new HashMap<>();
        Query query=session.createQuery("FROM board");
        return (List<Board>)query.list();
    }
    public static Board getBoardById(long id) {
        Board board=session.get(Board.class,id);
        return board;
    }
}
