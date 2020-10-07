package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity(name="thread")
@Table(name = "thread")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String imagefilename;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String content;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp thread_time;
    @OneToMany(mappedBy = "thread", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;
    @ManyToOne
    @JoinColumn(name="board_id",nullable = false)
    @JsonIgnore
    private Board board;
    //public List<Post> getPosts() { return posts;}

}
