/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import cambodia.raven.DateChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.TextAlignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jahid
 */
public class UserHistoryPanel extends javax.swing.JPanel {
    String UserName, theatreName, theatreAddress;
    Integer UserId;
    /**
     * Creates new form UserHistoryPanel
     */
    public UserHistoryPanel() {
        initComponents();
    }
    
    public UserHistoryPanel(String userName) {
        initComponents();
        UserName = userName;
        DefaultTableModel model = (DefaultTableModel)HistoryTable.getModel();
        model.setRowCount(0);  
        show_history();
        jTextField1.setText("");
    }
    
    public void find_userId(){
        String userName = UserName;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Select * from REGISTRATION where UserName = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                UserId = rs.getInt("UserId");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void find_theatreDeatils(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Select * from THEATRE where TheatreName = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, theatreName);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                theatreAddress = rs.getString("TheatreAddress");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<UserHistoryShows> historyList(){
        find_userId();
        ArrayList<UserHistoryShows> historyList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");


            String sql = "Select * from HISTORY where UserId="+UserId;  
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            UserHistoryShows histories;
            while(rs.next()){
                histories = new UserHistoryShows(rs.getInt("UserId"),rs.getInt("OrderId"),rs.getString("Date"),rs.getString("ShowTime"),rs.getString("MovieName"),rs.getString("TheatreName"),rs.getString("Hall"),rs.getString("Tickets"),rs.getString("Category"),rs.getInt("Price"),rs.getString("BookingTime")); 
                historyList.add(histories);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyList;
    }
    
    public ArrayList<UserHistoryShows> historyListUsingDate(){
        find_userId();
        String month1 = dateChooser1.getSelectedDate(DateChooser.GET_MONTH);
        if (Integer.valueOf(month1) < 10){
            month1 = "0"+dateChooser1.getSelectedDate(DateChooser.GET_MONTH);
        }
        String s = dateChooser1.getSelectedDate(DateChooser.GET_YEAR)+"-"+month1+"-"+dateChooser1.getSelectedDate(DateChooser.GET_DAY);
        ArrayList<UserHistoryShows> historyList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");


            String sql = "Select * from HISTORY where UserId = ? AND Date = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, UserId);
            pst.setString(2, s);
            ResultSet rs = pst.executeQuery();
            UserHistoryShows histories;
            while(rs.next()){
                histories = new UserHistoryShows(rs.getInt("UserId"),rs.getInt("OrderId"),rs.getString("Date"),rs.getString("ShowTime"),rs.getString("MovieName"),rs.getString("TheatreName"),rs.getString("Hall"),rs.getString("Tickets"),rs.getString("Category"),rs.getInt("Price"),rs.getString("BookingTime")); 
                historyList.add(histories);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyList;
    }
    
    public void show_history(){
        ArrayList<UserHistoryShows> list = historyList();
        DefaultTableModel model = (DefaultTableModel)HistoryTable.getModel();
        Object[] row = new Object[10];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getOrderId();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getShowTime();
            row[3] = list.get(i).getMovieName();
            row[4] = list.get(i).getTheatreName();
            theatreName = list.get(i).getTheatreName();
            row[5] = list.get(i).getHall();
            row[6] = list.get(i).getTickets();
            row[7] = list.get(i).getCategory();
            row[8] = list.get(i).getPrice();
            row[9] = list.get(i).getBookingTime();
            model.addRow(row); 
        }
    }
    
    public void show_historyUsingDate(){
        ArrayList<UserHistoryShows> list = historyListUsingDate();
        DefaultTableModel model = (DefaultTableModel)HistoryTable.getModel();
        Object[] row = new Object[10];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getOrderId();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getShowTime();
            row[3] = list.get(i).getMovieName();
            row[4] = list.get(i).getTheatreName();
            row[5] = list.get(i).getHall();
            row[6] = list.get(i).getTickets();
            row[7] = list.get(i).getCategory();
            row[8] = list.get(i).getPrice();
            row[9] = list.get(i).getBookingTime();
            model.addRow(row); 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new cambodia.raven.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HistoryTable = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        dateChooser1.setButton(jButton3);
        dateChooser1.setTextRefernce(jTextField1);

        setPreferredSize(new java.awt.Dimension(1001, 765));

        jPanel2.setBackground(new java.awt.Color(82, 82, 82));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setToolTipText("");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("History");

        HistoryTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order Id", "Date", "Show time", "Movie name", "Theatre Name", "Hall", "Tickets", "Category", "Price", "Booking Time"
            }
        ));
        HistoryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HistoryTable.setRowHeight(26);
        jScrollPane1.setViewportView(HistoryTable);

        jButton6.setBackground(new java.awt.Color(153, 255, 153));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Search");
        jButton6.setContentAreaFilled(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(82, 82, 82));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("...");
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Generate Tickets");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel)HistoryTable.getModel();
        model.setRowCount(0);  
        show_historyUsingDate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 25, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
    Font redFont = FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 25, Font.BOLD, new CMYKColor(0, 0, 255, 0));

        
        
        
    int i = HistoryTable.getSelectedRow();
        TableModel model = HistoryTable.getModel();
        String OrderId = model.getValueAt(i, 0).toString();
        String movieName = model.getValueAt(i, 3).toString();
        String theatreName = model.getValueAt(i, 4).toString();
        String hall = model.getValueAt(i, 5).toString();
        String date = model.getValueAt(i, 1).toString();
        String time = model.getValueAt(i, 2).toString();
        find_theatreDeatils();
        System.out.println(theatreAddress);

    try
    {
        String file_name="E:\\generate_pdf.pdf";
        Document document = new Document();
        
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        
        document.open();
        
        
        
        
        
        Paragraph para= new Paragraph("Order Id:" , redFont);
        Paragraph para1= new Paragraph(OrderId , blueFont);
        Paragraph para2= new Paragraph("User Name:" , redFont);
        Paragraph para3= new Paragraph(UserName , blueFont);
        
        Paragraph para4= new Paragraph("Theatre Name:", redFont);
        Paragraph para5= new Paragraph(theatreName , blueFont);
        Paragraph para6= new Paragraph("Movie Name:", redFont);
        Paragraph para7= new Paragraph(movieName , blueFont);
        Paragraph para8= new Paragraph("Hall Nam:", redFont);
        Paragraph para9= new Paragraph(hall , blueFont);
        Paragraph para10= new Paragraph("Date:", redFont);
        Paragraph para11= new Paragraph(date , blueFont);
        Paragraph para12= new Paragraph("Time:", redFont);
        Paragraph para13= new Paragraph(time , blueFont);
        Paragraph para14= new Paragraph("Theatre Address:", redFont);
        Paragraph para15= new Paragraph(theatreAddress , blueFont);

        document.add(para);
        document.add(para1);
        document.add(para2);
        document.add(para3);
        document.add(para4);
        document.add(para5);
        document.add(para6);
        document.add(para7);
        document.add(para8);
        document.add(para9);
        document.add(para10);
        document.add(para11);
        document.add(para12);
        document.add(para13);
        document.add(para14);
        document.add(para15);
        
        
        document.close();
        
        System.out.println("Finished");
        JOptionPane.showMessageDialog(null,"Ticket Generated Successfully");
        
        
    } catch (Exception e)
    {
        e.printStackTrace();
    } 
    
    
    
        
        
        /*int i = HistoryTable.getSelectedRow();
        TableModel model = HistoryTable.getModel();
        String OrderId = model.getValueAt(i, 0).toString();
        String movieName = model.getValueAt(i, 3).toString();
        String theatreName = model.getValueAt(i, 4).toString();
        String hall = model.getValueAt(i, 5).toString();
        String date = model.getValueAt(i, 1).toString();
        String time = model.getValueAt(i, 2).toString();
        find_theatreDeatils();
        new PrintTicket(OrderId,UserName, movieName, theatreName, hall, theatreAddress,  date,  time).setVisible(true);
        /*PrintTicket printTicket = new PrintTicket(OrderId,UserName, movieName, theatreName, hall, theatreAddress,  date,  time);*/
        
        //JFrame yourComponent = new JFrame();
        /*PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat) {
            //Set print component
            pjob.setPrintable(new Printer(printTicket), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(UserHistoryPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }*/
       /* System.out.println(" "+OrderId);
        System.out.println(" "+movieName);
        System.out.println(" "+theatreName);
        System.out.println(" "+hall);
        System.out.println(" "+theatreAddress);
        System.out.println(" "+date);
        System.out.println(" "+time);
  

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Cineplex Management System");
        
        job.setPrintable(new Printable(){
        public int print(Graphics pg,PageFormat pf, int pageNum){
            pf.setOrientation(PageFormat.LANDSCAPE);
            if(pageNum>0){
                return Printable.NO_SUCH_PAGE;
            }
                
            Graphics2D g2 = (Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(1,1.1);
            
            JPanel jPanel1 = new PrintTicket().getjPanel1();
            jPanel1.paint(g2);        
               
            return Printable.PAGE_EXISTS;   
            }
        });
         
        boolean ok = job.printDialog();
        if(ok){
            try{ 
                job.print();
            }
            catch (PrinterException ex){
            }
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel)HistoryTable.getModel();
        model.setRowCount(0);  
        show_history();
        jTextField1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HistoryTable;
    private cambodia.raven.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
