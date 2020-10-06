package views;

import models.Thread;
import services.ThreadService;
import sun.jvm.hotspot.runtime.Threads;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

@ManagedBean
@SessionScoped
@Named(value = "threadsByBoard")
public class ThreadsByBoard {
    public String id;
    private List<Thread> threads;
    public ThreadsByBoard(){}
    public List<Thread> getThreads() {
        threads= ThreadService.getAllThreadsFromBoard( Long.parseLong(id));
        System.out.println("DUUUUUUUUUPPPPPPPPPAAAAAAAAAAAaa "+threads.size());
        for(Thread t :threads) {
            System.out.println(t.getContent());
        }
        return threads;
    }
    public String getId() {return id;}
    public void setId(String id) {this.id=id;}
    public String outcome() {return "board";}
}
