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
public class Profile {
    int UserId,ContactNumber;
    String UserName , FullName , EmailId , Password; 
    
    
    public Profile(int UserId , String UserName , String FullName , String EmailId , String Password ,int ContactNumber)
    {
        this.UserId =UserId;
        this.UserName =UserName ;
        this.FullName = FullName;
        this.EmailId = EmailId;
        this.Password = Password;
        this.ContactNumber = ContactNumber;     
        
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
