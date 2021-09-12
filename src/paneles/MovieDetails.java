package paneles;

import java.awt.Image;
import javax.swing.ImageIcon;



/**
 *
 * @author Jahid
 */
public class MovieDetails extends javax.swing.JFrame {

    /**
     * Creates new form MovieDetails
     */
    public MovieDetails() {
        initComponents();
    }

    public MovieDetails(String movieId, String movieName, String director, String Cast, String details, String rating, byte[] image) {
        initComponents();
        MovieId.setText(movieId);
        MovieId.setVisible(false);
        jLabel3.setVisible(false);
        MovieName.setText(movieName);
        Director.setText(director);
        CastName.setText(Cast);
        Details.setText(details);
        Rating.setText(rating);
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(Picture.getWidth(), Picture.getHeight(), Image.SCALE_SMOOTH));
        Picture.setIcon(imageIcon);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Picture = new javax.swing.JLabel();
        MovieId = new javax.swing.JLabel();
        MovieName = new javax.swing.JLabel();
        Director = new javax.swing.JLabel();
        Rating = new javax.swing.JLabel();
        CastName = new javax.swing.JLabel();
        Details = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 960));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(49, 49, 49));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Movie Details");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(4, 4, 4))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 850, 75);

        jPanel2.setBackground(new java.awt.Color(82, 82, 82));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(801, 720));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Movie Id:");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(160, 460, 120, 34);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Movie Name:");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(160, 520, 120, 34);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Director:");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(190, 570, 90, 26);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rating:");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel6);
        jLabel6.setBounds(200, 620, 80, 27);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("cast");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(170, 730, 110, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Movie Deatils:");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 680, 130, 30);

        Picture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(Picture);
        Picture.setBounds(233, 15, 380, 410);

        MovieId.setBackground(new java.awt.Color(204, 204, 255));
        MovieId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MovieId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(MovieId);
        MovieId.setBounds(304, 460, 300, 30);

        MovieName.setBackground(new java.awt.Color(204, 204, 255));
        MovieName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MovieName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(MovieName);
        MovieName.setBounds(304, 520, 310, 30);

        Director.setBackground(new java.awt.Color(204, 204, 255));
        Director.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Director.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Director);
        Director.setBounds(310, 570, 304, 30);

        Rating.setBackground(new java.awt.Color(204, 204, 255));
        Rating.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Rating.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Rating);
        Rating.setBounds(310, 620, 304, 30);

        CastName.setBackground(new java.awt.Color(204, 204, 255));
        CastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CastName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(CastName);
        CastName.setBounds(310, 670, 304, 30);

        Details.setBackground(new java.awt.Color(204, 204, 255));
        Details.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Details.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Details);
        Details.setBounds(310, 730, 304, 30);

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(380, 791, 110, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 82, 850, 860);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(MovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieDetails().setVisible(true);
                
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CastName;
    private javax.swing.JLabel Details;
    private javax.swing.JLabel Director;
    private javax.swing.JLabel MovieId;
    private javax.swing.JLabel MovieName;
    private javax.swing.JLabel Picture;
    private javax.swing.JLabel Rating;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
