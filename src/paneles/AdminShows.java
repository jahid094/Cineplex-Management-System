/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

/**
 *
 * @author samsu
 */
public class AdminShows {
    private int ShowId,MovieId,TheatreId;
    private String Date,ShowTime,MovieName,TheatreName,Hall;
    private int Platinum,Gold,Silver;

    public AdminShows() {
        
    }

    public AdminShows(int ShowId, int MovieId, int TheatreId, String Date, String ShowTime, String MovieName, String TheatreName, String Hall, int Platinum, int Gold, int Silver) {
        this.ShowId = ShowId;
        this.MovieId = MovieId;
        this.TheatreId = TheatreId;
        this.Date = Date;
        this.ShowTime = ShowTime;
        this.MovieName = MovieName;
        this.TheatreName = TheatreName;
        this.Hall = Hall;
        this.Platinum = Platinum;
        this.Gold = Gold;
        this.Silver = Silver;
    }

    public int getShowId() {
        return ShowId;
    }

    public void setShowId(int ShowId) {
        this.ShowId = ShowId;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }

    public int getTheatreId() {
        return TheatreId;
    }

    public void setTheatreId(int TheatreId) {
        this.TheatreId = TheatreId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getShowTime() {
        return ShowTime;
    }

    public void setShowTime(String ShowTime) {
        this.ShowTime = ShowTime;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public String getTheatreName() {
        return TheatreName;
    }

    public void setTheatreName(String TheatreName) {
        this.TheatreName = TheatreName;
    }

    public String getHall() {
        return Hall;
    }

    public void setHall(String Hall) {
        this.Hall = Hall;
    }

    public int getPlatinum() {
        return Platinum;
    }

    public void setPlatinum(int Platinum) {
        this.Platinum = Platinum;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int Gold) {
        this.Gold = Gold;
    }

    public int getSilver() {
        return Silver;
    }

    public void setSilver(int Silver) {
        this.Silver = Silver;
    }

    
    
    
    
}
