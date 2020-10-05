package models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private String content;
    @Column
    private Timestamp timestamp;
    @ManyToOne
    @JoinColumn(name="board_id",nullable = false)
    private Board board;
}
