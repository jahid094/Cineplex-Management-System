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
public class AdminShowPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminShowPanel
     */
    public AdminShowPanel() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)ShowTable.getModel();
        model.setRowCount(0);  
        show_Show();
        jTextField1.setText("");
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
    
    public void show_Show(){
        ArrayList<AdminShows> list = showList();
        DefaultTableModel model = (DefaultTableModel)ShowTable.getModel();
        Object[] row = new Object[11];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getShowId();
            row[1] = list.get(i).getMovieId();
            row[2] = list.get(i).getTheatreId();
            row[3] = list.get(i).getDate();
            row[4] = list.get(i).getShowTime();
            row[5] = list.get(i).getMovieName();
            row[6] = list.get(i).getTheatreName();
            row[7] = list.get(i).getHall();
            row[8] = list.get(i).getPlatinum();
            row[9] = list.get(i).getGold();
            row[10] = list.get(i).getSilver();
            model.addRow(row); 
        }
    }
    
    public void show_ShowUsingDate(){
        ArrayList<AdminShows> list = showListUsingDate();
        DefaultTableModel model = (DefaultTableModel)ShowTable.getModel();
        Object[] row = new Object[11];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getShowId();
            row[1] = list.get(i).getMovieId();
            row[2] = list.get(i).getTheatreId();
            row[3] = list.get(i).getDate();
            row[4] = list.get(i).getShowTime();
            row[5] = list.get(i).getMovieName();
            row[6] = list.get(i).getTheatreName();
            row[7] = list.get(i).getHall();
            row[8] = list.get(i).getPlatinum();
            row[9] = list.get(i).getGold();
            row[10] = list.get(i).getSilver();
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShowTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        dateChooser1.setButton(jButton3);
        dateChooser1.setTextRefernce(jTextField1);

        setPreferredSize(new java.awt.Dimension(0, 0));
        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(82, 82, 82));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setToolTipText("");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Shows:");

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Create Show");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Remove Show");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ShowTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ShowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Show Id", "Movie Id", "Theatre Id", "Date", "Show Time", "Movie Name", "Theatre Name", "Hall", "Platinum", "Gold", "Silver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ShowTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ShowTable.setMinimumSize(new java.awt.Dimension(170, 240));
        ShowTable.setRowHeight(26);
        jScrollPane1.setViewportView(ShowTable);
        if (ShowTable.getColumnModel().getColumnCount() > 0) {
            ShowTable.getColumnModel().getColumn(0).setHeaderValue("Show Id");
            ShowTable.getColumnModel().getColumn(1).setHeaderValue("Movie Id");
            ShowTable.getColumnModel().getColumn(2).setHeaderValue("Theatre Id");
            ShowTable.getColumnModel().getColumn(3).setHeaderValue("Date");
            ShowTable.getColumnModel().getColumn(4).setHeaderValue("Show Time");
            ShowTable.getColumnModel().getColumn(5).setHeaderValue("Movie Name");
            ShowTable.getColumnModel().getColumn(6).setHeaderValue("Theatre Name");
            ShowTable.getColumnModel().getColumn(7).setHeaderValue("Hall");
            ShowTable.getColumnModel().getColumn(8).setHeaderValue("Platinum");
            ShowTable.getColumnModel().getColumn(9).setHeaderValue("Gold");
            ShowTable.getColumnModel().getColumn(10).setHeaderValue("Silver");
        }

        jTextField1.setBackground(new java.awt.Color(82, 82, 82));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("...");
        jButton3.setContentAreaFilled(false);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 96, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addGap(56, 56, 56)
                .addComponent(jButton5)
                .addGap(80, 80, 80))
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(0, 0, 1107, 688);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel)ShowTable.getModel();
        model.setRowCount(0);  
        show_Show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new RegisterAShow().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager
                .getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

                int i = ShowTable.getSelectedRow();
                TableModel model = ShowTable.getModel();
                String showId = model.getValueAt(i, 0).toString();

                String sql = "Delete From SHOW where ShowId="+showId;
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();
                DefaultTableModel Model = (DefaultTableModel)ShowTable.getModel();
                Model.setRowCount(0);
                show_Show();
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //String date = jTextField1.getText();
        /*DefaultTableModel model = (DefaultTableModel)ShowTable.getModel();
        model.setRowCount(0);  
        show_ShowUsingDate();*/
        /*try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

            String sql = "Select * from SHOW where Date = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, date);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String TheaterName = rs.getString("TheatreName");
                theaterName.setText(TheaterName);
                String hall = rs.getString("Hall");
                Hall.setText(hall);
            }
            else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel model = (DefaultTableModel)ShowTable.getModel();
        model.setRowCount(0);
        show_ShowUsingDate();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ShowTable;
    private cambodia.raven.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
