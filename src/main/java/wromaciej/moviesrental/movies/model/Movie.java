package wromaciej.moviesrental.movies.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "film", schema = "public")
public class Movie {


    @Id
    @Column(name = "film_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "rental_rate")
    private Double rentalRate;

    @ManyToMany(mappedBy = "movies")
    public Collection<Actor> actors = new ArrayList<Actor>();


    public Movie() {
    }

    public Movie(Integer id, String title, Double rentalRate) {
        this.id = id;
        this.title = title;
        this.rentalRate = rentalRate;
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


    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }
}