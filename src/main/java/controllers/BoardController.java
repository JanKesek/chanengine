package controllers;

import models.Board;
import services.BoardService;
import services.ThreadService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class BoardController {

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllBoardsREST() {
        List<Board> boards = BoardService.getAllBoards();
        for(Board b : boards) b.setThreads(null);
        return Response.ok(boards).header("Access-Control-Allow-Origin","http://localhost:5000").build();
    }
}
