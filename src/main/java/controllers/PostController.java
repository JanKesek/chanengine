package controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Post;
import services.ImageService;
import services.PostService;

import javax.annotation.security.RolesAllowed;
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
        //for(Post p:posts) {
        //    p.setThread(null);
        //}
        return Response.ok(posts).build();
    }

    @Path("/{id1}/{id2}")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postToThread(@PathParam("id2") long threadId, Post postIn) throws IOException {
        PostService.createPost(threadId, postIn);
        List<Post> responseData=PostService.getAllPostsByThreadID(threadId);
        //for(Post p: responseData) {
        //    p.setThread(null);
        //}
        return Response.ok(responseData).build();
    }
    @Path("/delete/{id1}/{id2}/{id3}")
    @DELETE
    @Produces("application/json")
    @RolesAllowed("User")
    public Response deletePost(@PathParam("id2") long threadId,@PathParam("id3") long postId) {
        PostService.deletePost(postId);
        List<Post> responseData=PostService.getAllPostsByThreadID(threadId);
        return Response.ok(responseData).build();
    }
}
