package controllers;

import models.Board;
import services.BoardService;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.util.List;

@Named
@SessionScoped
public class BoardControlerJSF {
    @EJB
    private BoardService boardService;
    private List<Board> boards;
    public List<Board> getAllBoards() {
        //List<Board> boards=new BoardService().getAllBoards();
        boards=new BoardService().getAllBoards();
        return boards;
        //return Response.ok(boards).build();
    }

}
