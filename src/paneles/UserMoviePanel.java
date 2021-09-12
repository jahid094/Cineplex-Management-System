/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import cambodia.raven.DateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jahid
 */
public class UserMoviePanel extends javax.swing.JPanel {
    String movieName,director,cast,details,rating;
    byte[] img;
    String userName;
    String TheaterID;

    public String getTheaterID() {
        return TheaterID;
    }

    public void setTheaterID() {
        int i = MovieTable.getSelectedRow();
        TableModel model = MovieTable.getModel();
        String TheaterID = model.getValueAt(i, 1).toString();
        this.TheaterID = TheaterID;
    }
    /**
     * Creates new form UserMoviePanel
     */
    public UserMoviePanel() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);  
        show_Show();
        jTextField1.setText("");
    }
    
    public UserMoviePanel(String UserName) {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);  
        show_Show();
        jTextField1.setText("");
        userName = UserName;
    }
    
    public ArrayList<AdminShows> showList(){
        ArrayList<AdminShows> showsList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");


            String sql = "Select * from SHOW";  
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            AdminShows shows;
            while(rs.next()){
                shows = new AdminShows(rs.getInt("ShowId"),rs.getInt("MovieId"),rs.getInt("TheatreId"),rs.getString("Date"),rs.getString("ShowTime"),rs.getString("MovieName"),rs.getString("TheatreName"),rs.getString("Hall"),rs.getInt("Platinum"),rs.getInt("Gold"),rs.getInt("Silver")); 
                showsList.add(shows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showsList;
    }
    
    public ArrayList<AdminShows> showListUsingDate(){
        String month1 = dateChooser1.getSelectedDate(DateChooser.GET_MONTH);
        if (Integer.valueOf(month1) < 10){
            month1 = "0"+dateChooser1.getSelectedDate(DateChooser.GET_MONTH);
        }
        String s = dateChooser1.getSelectedDate(DateChooser.GET_YEAR)+"-"+month1+"-"+dateChooser1.getSelectedDate(DateChooser.GET_DAY);
        ArrayList<AdminShows> showsList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");


            String sql = "Select * from SHOW where Date = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            AdminShows shows;
            while(rs.next()){
                shows = new AdminShows(rs.getInt("ShowId"),rs.getInt("MovieId"),rs.getInt("TheatreId"),rs.getString("Date"),rs.getString("ShowTime"),rs.getString("MovieName"),rs.getString("TheatreName"),rs.getString("Hall"),rs.getInt("Platinum"),rs.getInt("Gold"),rs.getInt("Silver")); 
                showsList.add(shows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showsList;
    }
    
    public ArrayList<AdminShows> showListUsingMovieName(String movieName){
        ArrayList<AdminShows> movieList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");


            String sql = "Select * from SHOW where MovieName LIKE '"+movieName+"%'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            AdminShows shows;
            while(rs.next()){
                shows = new AdminShows(rs.getInt("ShowId"),rs.getInt("MovieId"),rs.getInt("TheatreId"),rs.getString("Date"),rs.getString("ShowTime"),rs.getString("MovieName"),rs.getString("TheatreName"),rs.getString("Hall"),rs.getInt("Platinum"),rs.getInt("Gold"),rs.getInt("Silver")); 
                movieList.add(shows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;
    }
    
    public void show_Show(){
        ArrayList<AdminShows> list = showList();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        Object[] row = new Object[11];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getMovieId();
            row[1] = list.get(i).getTheatreId();
            row[2] = list.get(i).getDate();
            row[3] = list.get(i).getShowTime();
            row[4] = list.get(i).getMovieName();
            row[5] = list.get(i).getTheatreName();
            row[6] = list.get(i).getHall();
            row[7] = list.get(i).getPlatinum();
            row[8] = list.get(i).getGold();
            row[9] = list.get(i).getSilver();
            model.addRow(row); 
        }
    }
    
    public void show_ShowUsingDate(){
        ArrayList<AdminShows> list = showListUsingDate();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        Object[] row = new Object[11];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getMovieId();
            row[1] = list.get(i).getTheatreId();
            row[2] = list.get(i).getDate();
            row[3] = list.get(i).getShowTime();
            row[4] = list.get(i).getMovieName();
            row[5] = list.get(i).getTheatreName();
            row[6] = list.get(i).getHall();
            row[7] = list.get(i).getPlatinum();
            row[8] = list.get(i).getGold();
            row[9] = list.get(i).getSilver();
            model.addRow(row); 
        }
    }
    
    public void show_ShowUsingMovie(String movieName){
        ArrayList<AdminShows> list = showListUsingMovieName(movieName);
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        Object[] row = new Object[11];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getMovieId();
            row[1] = list.get(i).getTheatreId();
            row[2] = list.get(i).getDate();
            row[3] = list.get(i).getShowTime();
            row[4] = list.get(i).getMovieName();
            row[5] = list.get(i).getTheatreName();
            row[6] = list.get(i).getHall();
            row[7] = list.get(i).getPlatinum();
            row[8] = list.get(i).getGold();
            row[9] = list.get(i).getSilver();
            model.addRow(row); 
        }
    }
    
    public void find_movieDetails(String movieId){
        String MovieId = movieId;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Select * from MOVIE where MovieId = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, MovieId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                movieName= rs.getString("MovieName");
                director = rs.getString("Director");
                cast = rs.getString("CastName");
                details = rs.getString("Details");
                rating = rs.getString("Rating");
                img = rs.getBytes("Picture");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MovieTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchbypressed = new javax.swing.JTextField();

        dateChooser1.setButton(jButton3);
        dateChooser1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dateChooser1.setTextFocusable(false);
        dateChooser1.setTextRefernce(jTextField1);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(0, 0));
        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(82, 82, 82));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(1001, 765));
        jPanel2.setPreferredSize(new java.awt.Dimension(1001, 765));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setToolTipText("");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Movies:");

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Details");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Book");
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

        MovieTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MovieTable.setModel(new javax.swing.table.DefaultTableModel(
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
                "Movie Id", "Theatre Id", "Date", "Show Time", "Movie Name", "Theatre Name", "Hall", "Platinum", "Gold", "Silver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MovieTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MovieTable.setRowHeight(26);
        jScrollPane1.setViewportView(MovieTable);

        jTextField1.setBackground(new java.awt.Color(82, 82, 82));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search By Name:");

        searchbypressed.setBackground(new java.awt.Color(204, 204, 204));
        searchbypressed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchbypressed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbypressedKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(76, 76, 76)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbypressed, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbypressed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel2);
        jPanel2.setBounds(0, 0, 1100, 760);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int i = MovieTable.getSelectedRow();
       TableModel model = MovieTable.getModel();
       String movieId = model.getValueAt(i, 0).toString();
       find_movieDetails(movieId);
       new MovieDetails(movieId,movieName,director,cast,details,rating,img).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed





        //new RegisterAShow().setVisible(true);
        int i = MovieTable.getSelectedRow();
        TableModel model = MovieTable.getModel();
        String movieId = model.getValueAt(i, 0).toString();
        String theatreId = model.getValueAt(i, 1).toString();
        String date = model.getValueAt(i, 2).toString();
        String movieName = model.getValueAt(i, 4).toString();
        String theaterName = model.getValueAt(i, 5).toString();
        String showTime = model.getValueAt(i, 3).toString();
        String hall = model.getValueAt(i, 6).toString();
        String platinumSeat = model.getValueAt(i, 7).toString();
        String goldSeat = model.getValueAt(i, 8).toString();
        String silverSeat = model.getValueAt(i, 9).toString();
        new BookAShow(movieId,userName,date,theatreId,movieName,theaterName,showTime,hall,platinumSeat,goldSeat,silverSeat).setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);  
        show_Show();
        jTextField1.setText(""); 
        searchbypressed.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);
        show_ShowUsingDate();
        searchbypressed.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchbypressedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbypressedKeyReleased
        String query = searchbypressed.getText();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);
        show_ShowUsingMovie(query);
        jTextField1.setText("");
    }//GEN-LAST:event_searchbypressedKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MovieTable;
    private cambodia.raven.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField searchbypressed;
    // End of variables declaration//GEN-END:variables
}
