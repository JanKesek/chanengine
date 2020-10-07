package controllers;

import models.Post;
import services.ImageService;
import services.PostService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/boards")
public class PostController {
    @Path("/{id1}/{id2}")
    @GET
    @Produces("application/json")
    public Response getAllPostsFromThread(@PathParam("id1") long boardId, @PathParam("id2") long threadId) {
        List<Post> posts= PostService.getAllPostsByThreadID(threadId);
        for(Post p:posts) {
            p.setThread(null);
        }
        return Response.ok(posts)
                .header("Access-Control-Allow-Origin","http://localhost:5000")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
                .header("Access-Control-Allow-Headers", "Authorization, Content-Type")
                .header("Content-Type", "application/json").build();
    }
    @Path("/{id1}/{id2}")
    @OPTIONS
    @Consumes("application/json")
    public Response corsHeaders() {
        return Response.ok()
                .header("Access-Control-Allow-Origin","http://localhost:5000")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
                .header("Access-Control-Allow-Headers", "Authorization, Content-Type")
                .header("Content-Type", "application/json").build();
    }
    @Path("/{id1}/{id2}")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postToThread(@PathParam("id2") long threadId, Post postIn) throws IOException {
        PostService.createPost(threadId, postIn);
        return Response.ok(PostService.getAllPostsByThreadID(threadId))
                .header("Access-Control-Allow-Origin","http://localhost:5000")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
                .header("Access-Control-Allow-Headers", "Authorization, Content-Type")
                .header("Content-Type", "application/json").build();
    }
}
