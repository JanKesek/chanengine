package controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Post;
import models.Thread;
import services.ThreadService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/boards")
//@RequestScoped
public class ThreadController {

    @GET
    @Path("/{id}")
    @JsonIgnore
    @Produces({MediaType.APPLICATION_JSON})
    public Response getThreadsByID(@PathParam("id") long id) {
        List<Thread> threads=ThreadService.getAllThreadsFromBoard(id);
        List<String> ops=new ArrayList<>();
        //for(Thread t : threads) ops.add(t.getContent());
        //for(Thread t: threads) {
         //   t.setBoard(null);
        //    t.setPosts(null);
        //}
        return Response.ok(threads).build();
    }
    @POST
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response postThreadToBoard(@PathParam("id") long id, Thread threadIn) {
        ThreadService.insertThreadToBoard(id,threadIn);
        return Response.ok(getThreadsByID(id)).build();
    }
}
