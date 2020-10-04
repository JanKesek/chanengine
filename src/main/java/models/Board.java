package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "board")
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String shorter;
    @OneToMany(mappedBy = "thread")
    private List<Thread> threads;
}
