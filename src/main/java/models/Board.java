package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "board")
@Table(name="board")
public class Board {
    /*
 board_id_seq
 thread_id_seq
 post_id_seq
 image_id_seq
 */
    @Id
    @SequenceGenerator(name="identifier",sequenceName = "board_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "identifier")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String shorter;
    @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<Thread> threads;
}
