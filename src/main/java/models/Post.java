package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.inject.Inject;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "post")
@Table(name="post")
public class Post {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="identifier",sequenceName = "post_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "identifier")
    private Long id;
    @Column
    private String imagefilename;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp post_time;
    @Column
    private String content;
    @Column
    private String username;
    //@Column
    //private long thread_id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "thread_id", nullable = false)
    private Thread thread;
}