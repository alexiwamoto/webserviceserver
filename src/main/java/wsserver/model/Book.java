package wsserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="type",nullable=false,length=45)
    private String type;

    @Column(name="title",nullable=false,length=45)
    private String title;

    @Column(name="autor",nullable=false,length=45)
    private String autor;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
