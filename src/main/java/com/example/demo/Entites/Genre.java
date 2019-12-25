package com.example.demo.Entites;

import com.example.demo.Entites.Vote;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name ="moviedetails_id" ,referencedColumnName = "id")
    private Moviedetails moviedetails;
    
    private String name;

    public Genre (){
    }
    
    public Genre(Moviedetails movie, String genreName) {
        this.moviedetails = movie;
        this.name = genreName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Moviedetails getMovie() {
        return moviedetails;
    }

    public void setMovie(Moviedetails movie) {
        this.moviedetails = movie;
    }

    public String getName () {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
