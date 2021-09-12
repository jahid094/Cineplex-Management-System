/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author samsu
 */
public class BookAShow extends javax.swing.JFrame {
    String TheatreId,PlatinumPrice,GoldPrice,SilverPrice;
    String UserName;
    Integer UserId;
    String Date, ShowTime, MovieName, TheaterName, HALL;
    Integer TheaterId;
    Integer PlatinumSeaT,GoldSeaT,SilverSeaT;
    String category;
    String MovieId;
    int ShowId;
    /**
     * Creates new form BookTicket
     */
    public BookAShow() {
        initComponents();
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(platinum);
        btnGrp.add(gold);
        btnGrp.add(silver);
    }
    
    public BookAShow(String movieId, String userName, String date, String theatreId, String movieName, String TheaterNamE, String showTime,String Hall,String platinumSeat,String goldSeat,String silverSeat) {
        initComponents();
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(platinum);
        btnGrp.add(gold);
        btnGrp.add(silver);
        TheatreId = theatreId;
        find_theatreDetails();
        MovieNamE.setText(movieName); 
        theaterName.setText(TheaterNamE); 
        hall.setText(Hall); 
        time.setText(showTime); 
        PlatinumSeat.setText(platinumSeat);
        GoldSeat.setText(goldSeat);
        SilverSeat.setText(silverSeat);
        platinumPrice.setText("Rs. "+PlatinumPrice);
        goldPrice.setText("Rs. "+GoldPrice);
        silverPrice.setText("Rs. "+SilverPrice);
        UserName = userName;
        Date = date;
        ShowTime = showTime;
        MovieName = movieName;
        TheaterName = TheaterNamE;
        HALL = Hall;
        Integer result1 = Integer.valueOf(platinumSeat);
        Integer result2 = Integer.valueOf(goldSeat);
        Integer result3 = Integer.valueOf(silverSeat);
        PlatinumSeaT = result1; 
        GoldSeaT = result2; 
        SilverSeaT = result3; 
        MovieId = movieId;
    }
    
    public void find_theatreDetails(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Select * from THEATRE where TheatreId = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, TheatreId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                PlatinumPrice= rs.getString("Platinum");
                GoldPrice = rs.getString("Gold");
                SilverPrice = rs.getString("Silver");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public void find_showId(){
        //find_theatreDetails();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Select * from SHOW where MovieId = ? AND TheatreId = ? AND Date = ? AND ShowTime = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, MovieId);
            pst.setString(2, TheatreId);
            pst.setString(3, Date);
            pst.setString(4, ShowTime);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                ShowId = rs.getInt("ShowId");
            }
            else{
                //JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update_showDetails(){
        find_showId();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Update SHOW Set Platinum = ?, Gold = ?, Silver = ? where ShowId="+ShowId;
            //String sql = "Update SHOW Set Platinum = ?, Gold = ?, Silver = ? where TheatreId="+TheaterId+" AND Date="+Date+" AND ShowTime="+ShowTime;
            PreparedStatement pst = connection.prepareStatement(sql);
 
            pst.setInt(1, PlatinumSeaT);
            pst.setInt(2, GoldSeaT);
            pst.setInt(3, SilverSeaT);
            
          
            pst.executeUpdate();
                
            JOptionPane.showMessageDialog(null,"Show updated Successfully");
            //dispose();

        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        platinumPrice = new javax.swing.JLabel();
        goldPrice = new javax.swing.JLabel();
        silverPrice = new javax.swing.JLabel();
        PlatinumSeat = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        GoldSeat = new javax.swing.JLabel();
        SilverSeat = new javax.swing.JLabel();
        MovieNamE = new javax.swing.JLabel();
        gold = new javax.swing.JRadioButton();
        silver = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        theaterName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        hall = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        platinum = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(941, 924));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(941, 952));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(82, 82, 82));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(799, 476));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Platinum:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gold:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Silver:");

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Purchase");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        platinumPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        platinumPrice.setForeground(new java.awt.Color(255, 255, 255));
        platinumPrice.setText("BDT. 200");

        goldPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        goldPrice.setForeground(new java.awt.Color(255, 255, 255));
        goldPrice.setText("BDT. 150");

        silverPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        silverPrice.setForeground(new java.awt.Color(255, 255, 255));
        silverPrice.setText("BDT. 120");

        PlatinumSeat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        PlatinumSeat.setForeground(new java.awt.Color(255, 255, 255));
        PlatinumSeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlatinumSeat.setText("*");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Price:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Remaining Seats");

        GoldSeat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        GoldSeat.setForeground(new java.awt.Color(255, 255, 255));
        GoldSeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GoldSeat.setText("*");

        SilverSeat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SilverSeat.setForeground(new java.awt.Color(255, 255, 255));
        SilverSeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SilverSeat.setText("*");

        MovieNamE.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        MovieNamE.setForeground(new java.awt.Color(204, 204, 255));
        MovieNamE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MovieNamE.setText("Movie Name");
        MovieNamE.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        gold.setBackground(new java.awt.Color(82, 82, 82));
        gold.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gold.setForeground(new java.awt.Color(204, 204, 204));
        gold.setText(" Gold");
        gold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldActionPerformed(evt);
            }
        });

        silver.setBackground(new java.awt.Color(82, 82, 82));
        silver.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        silver.setForeground(new java.awt.Color(204, 204, 204));
        silver.setText(" Silver");
        silver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silverActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Movie:");

        theaterName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        theaterName.setForeground(new java.awt.Color(204, 204, 255));
        theaterName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        theaterName.setText("Theatre Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Theater:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hall:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Show Time:");

        time.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        time.setForeground(new java.awt.Color(204, 204, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("Show time");

        hall.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hall.setForeground(new java.awt.Color(204, 204, 255));
        hall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hall.setText("Hall Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select Seat");

        platinum.setBackground(new java.awt.Color(82, 82, 82));
        platinum.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        platinum.setForeground(new java.awt.Color(204, 204, 204));
        platinum.setText(" Platinum");
        platinum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platinumActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Choose Number of Tickets:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(MovieNamE)
                        .addGap(213, 213, 213)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel6)
                                        .addGap(26, 26, 26)
                                        .addComponent(theaterName))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26)
                                        .addComponent(hall)))
                                .addGap(265, 265, 265))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(platinum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(86, 86, 86)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(gold, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(silver, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(silverPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(405, 405, 405)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PlatinumSeat, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(GoldSeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SilverSeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)
                                        .addComponent(time)
                                        .addGap(191, 191, 191)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel12))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(goldPrice)
                                    .addComponent(platinumPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MovieNamE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(platinumPrice)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(theaterName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hall)
                            .addComponent(jLabel12)
                            .addComponent(silverPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(goldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(platinum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(gold))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PlatinumSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GoldSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SilverSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(silver))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 90, 950, 850);

        jPanel2.setBackground(new java.awt.Color(49, 49, 49));

        jLabel1.setBackground(new java.awt.Color(49, 49, 49));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book your Tickets");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 940, 80);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void platinumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platinumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platinumActionPerformed

    private void silverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_silverActionPerformed

    private void goldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String tickets = jTextField1.getText();
        if(platinum.isSelected() == false && gold.isSelected() == false &&silver.isSelected() == false || tickets.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please fill all the field");
        }
        else{
            if(platinum.isSelected()){
                category = "Platinum";
            }
            else if(gold.isSelected()){
                category = "Gold";
            }
            else if(silver.isSelected()){
                category = "Silver";
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String bookingTime = dtf.format(now);

            find_userId();

            //Integer Ticket = Integer.valueOf(tickets);
            int Ticket=Integer.parseInt(tickets);
            String platinumPrice = PlatinumPrice;
            Integer PlatinumPricE = Integer.valueOf(platinumPrice);
            String goldPrice = GoldPrice;
            Integer GoldPricE = Integer.valueOf(goldPrice);
            String silverPrice = SilverPrice;
            Integer SilverPricE = Integer.valueOf(silverPrice);
            Integer price = null;
            if(platinum.isSelected() && tickets.isEmpty() == false  && PlatinumSeaT >0){
                price = Ticket * PlatinumPricE;
                PlatinumSeaT = PlatinumSeaT - Ticket;
            }
            else if(gold.isSelected() && tickets.isEmpty() == false && GoldSeaT >0){
                price = Ticket * GoldPricE;
                GoldSeaT = GoldSeaT - Ticket;
            }
            else if(silver.isSelected() && tickets.isEmpty() == false && SilverSeaT >0){
                price = Ticket * SilverPricE;
                SilverSeaT = SilverSeaT - Ticket;
            }
            //String str1 = Integer.toString(UserId);
            //int i=Integer.parseInt(UserId);
            //System.out.println(str1);

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

                String sql = "Insert into HISTORY"
                +"(UserId,Date,ShowTime,MovieName,TheatreName,Hall,Tickets,Category,Price,BookingTime)"
                +"values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, UserId);
                pst.setString(2, Date);
                pst.setString(3, ShowTime);
                pst.setString(4, MovieName);
                pst.setString(5, TheaterName);
                pst.setString(6, HALL);
                pst.setString(7, tickets);
                pst.setString(8, category);
                pst.setInt(9, price);
                pst.setString(10, bookingTime);

                pst.executeUpdate();
                update_showDetails();

                JOptionPane.showMessageDialog(null,"Ticket purchased Successfully");
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookAShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookAShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookAShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookAShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookAShow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GoldSeat;
    private javax.swing.JLabel MovieNamE;
    private javax.swing.JLabel PlatinumSeat;
    private javax.swing.JLabel SilverSeat;
    private javax.swing.JRadioButton gold;
    private javax.swing.JLabel goldPrice;
    private javax.swing.JLabel hall;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton platinum;
    private javax.swing.JLabel platinumPrice;
    private javax.swing.JRadioButton silver;
    private javax.swing.JLabel silverPrice;
    private javax.swing.JLabel theaterName;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
