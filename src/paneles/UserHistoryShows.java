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
public class UserHistoryShows {
    int UserId,OrderId;
    String Date,ShowTime,MovieName,TheatreName,Hall,Tickets,Category;
    int Price;
    String BookingTime;

    public UserHistoryShows(int UserId, int OrderId, String Date, String ShowTime, String MovieName, String TheatreName, String Hall, String Tickets, String Category, int Price, String BookingTime) {
        this.UserId = UserId;
        this.OrderId = OrderId;
        this.Date = Date;
        this.ShowTime = ShowTime;
        this.MovieName = MovieName;
        this.TheatreName = TheatreName;
        this.Hall = Hall;
        this.Tickets = Tickets;
        this.Category = Category;
        this.Price = Price;
        this.BookingTime = BookingTime;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
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

    public String getTickets() {
        return Tickets;
    }

    public void setTickets(String Tickets) {
        this.Tickets = Tickets;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getBookingTime() {
        return BookingTime;
    }

    public void setBookingTime(String BookingTime) {
        this.BookingTime = BookingTime;
    }
    
    
}
