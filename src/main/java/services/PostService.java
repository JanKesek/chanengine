package services;

import models.Post;
import models.SessionUtils;
import org.hibernate.Session;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import models.Thread;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Named
@RequestScoped
public class PostService {
    private static Session session= new SessionUtils().getSession();
    public static List<Post> getAllPostsByThreadID(long id) {
        //session.joinTransaction();
        Thread thread= session.get(Thread.class,id);
        return thread.getPosts();
    }
    public static void createPost(long id, Post post) throws IOException {
        post.setImagefilename(ImageService.saveBase64ToFile(post.getImagefilename()));
        Thread foreignKey=ThreadService.getThreadById(id, session);
        post.setThread(foreignKey);
        List<Post> thread_posts=foreignKey.getPosts();
        thread_posts.add(post);
        foreignKey.setPosts(thread_posts);
        //THERE IS NON-NULL CONSTRAINT VIOLATION WITHOUT THAT
        //post.setThread_id(foreignKey.getId());
        session.beginTransaction();
        session.save(post);
        session.save(foreignKey);
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
    //@Transactional
    public static void deletePost(long id) {
        Transaction txn=session.beginTransaction();
        Query query = session.createNativeQuery("DELETE from post where id=:id");
        query.setParameter("id",id);
        //session.joinTransaction();
        query.executeUpdate();
        txn.commit();
    }
    public static long getLastId() {
        Query query=session.createQuery("select max(id) from post");
        return (long)query.setMaxResults(1).list().get(0);
    }
}
