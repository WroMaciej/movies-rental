package wromaciej.moviesrental.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film", schema = "public")
public class Movie {


    @Id
    @Column(name = "film_id")
    private Integer id;

    @Column(name = "title")
    private String title;


    public Movie() {
    }

    public Movie(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}