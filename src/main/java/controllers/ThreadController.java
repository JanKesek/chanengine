package controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Thread;
import services.ThreadService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
//@RequestScoped
public class ThreadController {
    //
    //
    //@Inject
    ThreadService threadService=new ThreadService();
    @GET
    @Path("/{id}")
    @JsonIgnore
    @Produces({MediaType.APPLICATION_JSON})
    public Response getThreadsByID(@PathParam("id") long id) {
        List<Thread> threads=threadService.getAllThreadsFromBoard(id);
        List<String> ops=new ArrayList<>();
        //for(Thread t : threads) ops.add(t.getContent());
        for(Thread t: threads) t.setBoard(null);
        return Response.ok(threads).build();
    }
}
