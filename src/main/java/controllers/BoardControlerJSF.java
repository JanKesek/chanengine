package controllers;

import models.Board;
import services.BoardService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.util.List;

@Named(value="boardController")
@ManagedBean
@SessionScoped
//@SessionScoped
public class BoardControlerJSF {
    //@Inject
    //private BoardService boardService;
    private List<Board> boards=getAllBoards();
    public List<Board> getAllBoards() {
        //List<Board> boards=new BoardService().getAllBoards();
        //boards=new BoardService().getAllBoards();
        //boards=boardService.getAllBoards();
        //return boards;
        return new BoardService().getAllBoards();
        //return Response.ok(boards).build();
    }

}
