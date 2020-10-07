package services;

import models.Post;
import models.SessionUtils;
import org.hibernate.Session;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import models.Thread;

@Named
@RequestScoped
public class PostService {
    private static Session session= SessionUtils.getSession();
    public static List<Post> getAllPostsByThreadID(long id) {
        Thread thread= session.get(Thread.class,id);
        return thread.getPosts();
    }
    public static void createPost(long id, Post post) throws IOException {
        post.setImagefilename(ImageService.saveBase64ToFile(post.getImagefilename()));
        post.setThread(ThreadService.getThreadById(id, session));
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
    }
    public static void createOP(Thread thread) {
        Post post=new Post();
        post.setThread(thread);
        post.setContent(thread.getContent());
        post.setId(thread.getId());
        post.setImagefilename(thread.getImagefilename());
        post.setUsername(thread.getUsername());
        post.setPost_time(thread.getThread_time());
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
    }
    public static long getLastId() {
        Query query=session.createQuery("select max(id) from post");
        return query.getFirstResult();
    }
}
