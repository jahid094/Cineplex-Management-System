/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

/**
 *
 * @author Jahid
 */
public class UserMoviePanels {
    private int MovieId;
    private String MovieName,Director,CastName,Details,Rating;
    private byte[] picture;

    public UserMoviePanels(int MovieId, String MovieName, String Director, String CastName, String Details, String Rating,byte[] image) {
        this.MovieId = MovieId;
        this.MovieName = MovieName;
        this.Director = Director;
        this.CastName = CastName;
        this.Details = Details;
        this.Rating = Rating;
        this.picture = image;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getCastName() {
        return CastName;
    }

    public void setCastName(String CastName) {
        this.CastName = CastName;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }
    
    
}
