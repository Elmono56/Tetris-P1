
package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author chave
 */
public class PantallaJuego extends JFrame {

    private MatrizJuego matrizJuego;
    private KeyListener listener;
    private CronoThread cronometro;
    private ThreadBloque hilo;
            
    public PantallaJuego() {
        initComponents();
        fondo1.setVisible(true);//panel izq
        fondo2.setVisible(true);//panel der
        cronometro = new CronoThread(this);
        cronometro.start();
        matrizJuego=new MatrizJuego(pantalladeJuego);
        this.add(matrizJuego);
        activarListener(listener);
        this.addKeyListener(listener);
        this.lblPuntos.addKeyListener(listener);
        this.txtPuntos.addKeyListener(listener);
        this.Figura2.addKeyListener(listener);
        this.Figura3.addKeyListener(listener);
        this.txtCrono.addKeyListener(listener);
        this.lblNivel.addKeyListener(listener);
        this.txtnivel1.addKeyListener(listener);
        this.txtLineas.addKeyListener(listener);
        this.lblLineas.addKeyListener(listener);
        
        inicio();
       
    }
    
public void inicio(){
    
    this.hilo = new ThreadBloque(matrizJuego,this);
    hilo.start();
    
}
    public void actualizarPuntos(int puntos){
    
        this.txtPuntos.setText(""+puntos);
    
    }
    
    public void actualizarLineas(int lineas){
    
        this.txtLineas.setText(""+lineas);
    
    }
    public void actualizarNivel(int nivel){
        this.txtnivel1.setText(""+nivel);
    
    }

    public void setTextToCrono(String texto){
        this.txtCrono.setText(texto);
    }
    
    public void aumentarLevel(){
        this.hilo.aumentarNivel();
    }


public void activarListener(KeyListener listener){

    this.listener= new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key= e.getKeyCode();   
            if(key ==37)matrizJuego.izquierda();
            if(key ==38)matrizJuego.rotar();
            if(key ==39)matrizJuego.derecha();       
            if(key ==40)matrizJuego.caer();       
        
        }

        @Override
        public void keyReleased(KeyEvent e) {

            }
     };

    }    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pantalladeJuego = new javax.swing.JPanel();
        fondo1 = new javax.swing.JPanel();
        txtCrono = new javax.swing.JTextField();
        lblNivel = new javax.swing.JLabel();
        lblLineas = new javax.swing.JLabel();
        txtnivel1 = new javax.swing.JTextField();
        txtLineas = new javax.swing.JTextField();
        fondo2 = new javax.swing.JPanel();
        lblPuntos = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        Figura2 = new javax.swing.JPanel();
        Figura3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pantalladeJuego.setBackground(new java.awt.Color(153, 153, 153));
        pantalladeJuego.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        javax.swing.GroupLayout pantalladeJuegoLayout = new javax.swing.GroupLayout(pantalladeJuego);
        pantalladeJuego.setLayout(pantalladeJuegoLayout);
        pantalladeJuegoLayout.setHorizontalGroup(
            pantalladeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        pantalladeJuegoLayout.setVerticalGroup(
            pantalladeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        fondo1.setBackground(new java.awt.Color(0, 102, 102));
        fondo1.setPreferredSize(new java.awt.Dimension(160, 506));

        txtCrono.setEditable(false);
        txtCrono.setBackground(new java.awt.Color(0, 102, 102));
        txtCrono.setForeground(new java.awt.Color(255, 255, 255));
        txtCrono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCronoActionPerformed(evt);
            }
        });

        lblNivel.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setText("NIVEL:");

        lblLineas.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        lblLineas.setForeground(new java.awt.Color(255, 255, 255));
        lblLineas.setText("LINEAS:");

        txtnivel1.setEditable(false);
        txtnivel1.setBackground(new java.awt.Color(0, 102, 102));
        txtnivel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        txtnivel1.setForeground(new java.awt.Color(255, 255, 255));
        txtnivel1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtLineas.setEditable(false);
        txtLineas.setBackground(new java.awt.Color(0, 102, 102));
        txtLineas.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        txtLineas.setForeground(new java.awt.Color(255, 255, 255));
        txtLineas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout fondo1Layout = new javax.swing.GroupLayout(fondo1);
        fondo1.setLayout(fondo1Layout);
        fondo1Layout.setHorizontalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo1Layout.createSequentialGroup()
                .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fondo1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtnivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(fondo1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(txtCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondo1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(lblLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE)))
        );
        fondo1Layout.setVerticalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(txtLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondo1Layout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addComponent(lblLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        txtCrono.getAccessibleContext().setAccessibleParent(pantalladeJuego);
        txtnivel1.getAccessibleContext().setAccessibleParent(pantalladeJuego);
        txtLineas.getAccessibleContext().setAccessibleParent(pantalladeJuego);

        fondo2.setBackground(new java.awt.Color(0, 102, 102));

        lblPuntos.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        lblPuntos.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos.setText("PUNTOS:");

        txtPuntos.setEditable(false);
        txtPuntos.setBackground(new java.awt.Color(0, 102, 102));
        txtPuntos.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        txtPuntos.setForeground(new java.awt.Color(255, 255, 255));
        txtPuntos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout Figura2Layout = new javax.swing.GroupLayout(Figura2);
        Figura2.setLayout(Figura2Layout);
        Figura2Layout.setHorizontalGroup(
            Figura2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Figura2Layout.setVerticalGroup(
            Figura2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Figura3Layout = new javax.swing.GroupLayout(Figura3);
        Figura3.setLayout(Figura3Layout);
        Figura3Layout.setHorizontalGroup(
            Figura3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        Figura3Layout.setVerticalGroup(
            Figura3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout fondo2Layout = new javax.swing.GroupLayout(fondo2);
        fondo2.setLayout(fondo2Layout);
        fondo2Layout.setHorizontalGroup(
            fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPuntos)
                    .addGroup(fondo2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Figura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Figura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fondo2Layout.setVerticalGroup(
            fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Figura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Figura3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        lblPuntos.getAccessibleContext().setAccessibleParent(pantalladeJuego);
        txtPuntos.getAccessibleContext().setAccessibleParent(pantalladeJuego);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pantalladeJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fondo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(pantalladeJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleParent(pantalladeJuego);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCronoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCronoActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Figura2;
    private javax.swing.JPanel Figura3;
    private javax.swing.JPanel fondo1;
    private javax.swing.JPanel fondo2;
    private javax.swing.JLabel lblLineas;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JPanel pantalladeJuego;
    private javax.swing.JTextField txtCrono;
    private javax.swing.JTextField txtLineas;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtnivel1;
    // End of variables declaration//GEN-END:variables
}
