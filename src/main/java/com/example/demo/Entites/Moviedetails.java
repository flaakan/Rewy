package com.example.demo.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Moviedetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private String description;
    private String poster;
    private double imdb;
    private double rotten_tomatoes;
    private float rewy;
    
    public Moviedetails(){
        
    }
    public Moviedetails(String name,String description){
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public double getRotten_tomatoes() {
        return rotten_tomatoes;
    }

    public void setRotten_tomatoes(double rotten_tomatoes) {
        this.rotten_tomatoes = rotten_tomatoes;
    }

    public float getRewy() {
        return rewy;
    }

    public void setRewy(float rewy) {
        this.rewy = rewy;
    }
    
    
    
}
