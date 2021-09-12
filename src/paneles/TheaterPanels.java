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
public class TheaterPanels {
    private int TheatreId;
    private String TheatreName,Hall,TheatreAddress;
    private int Platinum,Gold,Silver;

    public TheaterPanels(int TheatreId, String TheatreName, String Hall, String TheatreAddress, int Platinum, int Gold, int Silver) {
        this.TheatreId = TheatreId;
        this.TheatreName = TheatreName;
        this.Hall = Hall;
        this.TheatreAddress = TheatreAddress;
        this.Platinum = Platinum;
        this.Gold = Gold;
        this.Silver = Silver;
    }

    public int getTheatreId() {
        return TheatreId;
    }

    public void setTheatreId(int TheatreId) {
        this.TheatreId = TheatreId;
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

    public String getTheatreAddress() {
        return TheatreAddress;
    }

    public void setTheatreAddress(String TheatreAddress) {
        this.TheatreAddress = TheatreAddress;
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
