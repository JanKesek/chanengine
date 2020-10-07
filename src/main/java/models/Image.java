package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "image")
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String base64image;
}
