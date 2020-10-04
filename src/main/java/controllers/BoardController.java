package controllers;

import models.Board;
import services.BoardService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class BoardController {
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/")
    public Response getAllBoards() {
        List<Board> boards=new BoardService().getAllBoards();
        return Response.ok(boards).build();
    }
}
