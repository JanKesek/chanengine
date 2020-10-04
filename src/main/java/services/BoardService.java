package services;


import models.Board;
import models.SessionUtils;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.query.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Singleton
public class BoardService {
    private Board boardbean;
    @Inject
    public BoardService(Board board) { this.boardbean=board;}
    public BoardService(){}
    public  List<Board> getAllBoards() {
        Map<String, String> boardIds=new HashMap<>();
        Session session= SessionUtils.getSession();
        Query query=session.createQuery("FROM board");
        return (List<Board>)query.list();
    }
}
