
package tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author chave
 */
public class PantallaJuego extends JFrame {

    private MatrizJuego matrizJuego;
    private KeyListener listener;
    private CronoThread cronometro;
    private ThreadBloque hilo;
    private Sonido cancion;
    private ArrayList<Integer> puntajes;
    private String jugadaspath;
    private FileManager archivo;
    private String pathMemoria;
    private String guardar;
    private FileManager datos;
    private Guardar boxGuardar;
            
    public PantallaJuego(String jugadaspath,FileManager archivo,String memoria,ArrayList<Integer> puntajes) {
        this.cronometro = new CronoThread(this);
        activarTodo(jugadaspath,archivo,puntajes);
        matrizJuego=new MatrizJuego(pantalladeJuego,JLabelFig2,JLabelFig3);
        this.add(matrizJuego);
    }
    
    public PantallaJuego(String jugadaspath,FileManager archivo,Color[][] aux,ArrayList<Integer> puntajes){
        this.cronometro = new CronoThread(this);
        activarTodo(jugadaspath,archivo,puntajes);
        matrizJuego=new MatrizJuego(pantalladeJuego,JLabelFig2,JLabelFig3,aux);
        this.add(matrizJuego);
    }
    
    public void activarTodo(String jugadaspath,FileManager archivo,ArrayList<Integer> puntajes){
        initComponents();
        fondo1.setVisible(true);//panel izq
        fondo2.setVisible(true);//panel der
        JLabelFig2.setVisible(true);
        JLabelFig3.setVisible(true);
        try {
            this.cancion = new Sonido();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("");
        } catch (LineUnavailableException ex) {
            
        }
        this.datos = null;
        this.jugadaspath = jugadaspath;
        this.archivo = archivo;
        this.pathMemoria = "";
        this.guardar = "";
        activarListener(listener);
        this.cancion.playMusic();
        this.addKeyListener(listener);
        this.puntajes = puntajes;
        
    }

    public void setPuntajes(ArrayList<Integer> puntajes) {
        this.puntajes = puntajes;
    }
    
    public ThreadBloque getHilo(){
        return this.hilo;
    }
    
    public void inicio(){
        this.hilo = new ThreadBloque(matrizJuego,this,this.cancion);
        this.hilo.start();
        this.cronometro.start();
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

    public int getNivel(){
        String nivelstr = this.txtnivel1.getText();
        return Integer.parseInt(nivelstr);
    }

    public void guardarPuntaje(){
        String puntos = txtPuntos.getText();
        int cantpuntos;
        try {
            cantpuntos = Integer.parseInt(puntos);
        }
        catch (Exception e){
            cantpuntos=0;
            puntos="0";
        }
        
        int largo;
        try{
            largo = this.puntajes.size();
        }
        catch (Exception e){
            largo = 0;
        }
        
        
        String puntosfinal = "";
        
        
        if (largo==0){
            this.puntajes.add(cantpuntos);
            this.archivo.cleanFile(jugadaspath);
            this.archivo.writeToFile(jugadaspath, puntos);
        }
        else if (largo<10){
            this.archivo.cleanFile(jugadaspath);
            
            this.puntajes.add(cantpuntos);
             Collections.sort(puntajes, Collections.reverseOrder());
             
             int numf = puntajes.get(largo);
             
             int cont = 0;
             
             for (int puntaje : puntajes){
                 if (puntaje!=numf){
                     puntosfinal = puntosfinal+puntaje+"\n";
                 }
                 else{
                     puntosfinal = puntosfinal+puntaje;
                 }
             }
            
            this.archivo.writeToFile(jugadaspath, puntosfinal);
        }
        else{
            Collections.sort(puntajes, Collections.reverseOrder());
            for (int puntaje : puntajes){
                if (puntaje<cantpuntos){
                    puntajes.remove(puntajes.get(9));
                    puntajes.add(cantpuntos);
                    break;
                }
            }
            Collections.sort(puntajes, Collections.reverseOrder());
            
            int numf = puntajes.get(9);
             
             for (int puntaje : puntajes){
                 if (puntaje!=numf){
                     puntosfinal = puntosfinal+puntaje+"\n";
                 }
                 else{
                     puntosfinal = puntosfinal+puntaje;
                 }
             }
             
            this.archivo.cleanFile(jugadaspath);
            this.archivo.writeToFile(jugadaspath, puntosfinal);
        }
        
    }

    public void setGanador(boolean sino){
        this.hilo.setGanador(sino);
    }
    
    public void detenerCronometro(){
        this.cronometro.setIsRunning(false);
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
        btnpausar = new javax.swing.JButton();
        btnreanudar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        fondo2 = new javax.swing.JPanel();
        lblPuntos = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        JLabelFig2 = new javax.swing.JLabel();
        JLabelFig3 = new javax.swing.JLabel();

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
        fondo1.setFocusable(false);
        fondo1.setPreferredSize(new java.awt.Dimension(160, 506));

        txtCrono.setEditable(false);
        txtCrono.setBackground(new java.awt.Color(0, 102, 102));
        txtCrono.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        txtCrono.setForeground(new java.awt.Color(255, 255, 255));
        txtCrono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCrono.setFocusable(false);
        txtCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCronoActionPerformed(evt);
            }
        });

        lblNivel.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(255, 255, 255));
        lblNivel.setText("NIVEL:");
        lblNivel.setFocusable(false);

        lblLineas.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        lblLineas.setForeground(new java.awt.Color(255, 255, 255));
        lblLineas.setText("LINEAS:");
        lblLineas.setFocusable(false);

        txtnivel1.setEditable(false);
        txtnivel1.setBackground(new java.awt.Color(0, 102, 102));
        txtnivel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        txtnivel1.setForeground(new java.awt.Color(255, 255, 255));
        txtnivel1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnivel1.setFocusable(false);

        txtLineas.setEditable(false);
        txtLineas.setBackground(new java.awt.Color(0, 102, 102));
        txtLineas.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        txtLineas.setForeground(new java.awt.Color(255, 255, 255));
        txtLineas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLineas.setFocusable(false);

        btnpausar.setText("PAUSAR");
        btnpausar.setFocusable(false);
        btnpausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpausarActionPerformed(evt);
            }
        });

        btnreanudar.setText("REANUDAR");
        btnreanudar.setFocusable(false);
        btnreanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreanudarActionPerformed(evt);
            }
        });

        btnguardar.setText("GUARDAR");
        btnguardar.setFocusable(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondo1Layout = new javax.swing.GroupLayout(fondo1);
        fondo1.setLayout(fondo1Layout);
        fondo1Layout.setHorizontalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo1Layout.createSequentialGroup()
                .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLineas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fondo1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(txtCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(fondo1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(fondo1Layout.createSequentialGroup()
                                    .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtnivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(fondo1Layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnreanudar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnpausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addGap(51, 51, 51)
                .addComponent(btnpausar)
                .addGap(34, 34, 34)
                .addComponent(btnreanudar)
                .addGap(38, 38, 38)
                .addComponent(btnguardar)
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
        fondo2.setFocusable(false);

        lblPuntos.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        lblPuntos.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntos.setText("PUNTOS:");
        lblPuntos.setFocusable(false);

        txtPuntos.setEditable(false);
        txtPuntos.setBackground(new java.awt.Color(0, 102, 102));
        txtPuntos.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        txtPuntos.setForeground(new java.awt.Color(255, 255, 255));
        txtPuntos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPuntos.setFocusable(false);

        JLabelFig2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        JLabelFig2.setFocusable(false);

        JLabelFig3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        JLabelFig3.setFocusable(false);

        javax.swing.GroupLayout fondo2Layout = new javax.swing.GroupLayout(fondo2);
        fondo2.setLayout(fondo2Layout);
        fondo2Layout.setHorizontalGroup(
            fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPuntos)
                    .addGroup(fondo2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLabelFig2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabelFig3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fondo2Layout.setVerticalGroup(
            fondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JLabelFig2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JLabelFig3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
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

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        
        this.detenerCronometro();
        //this.cronometro.setIsRunning(false);
        
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReanudarActionPerformed
        
        //this.hilo.setIsRunning(true);
        //this.cronometro.setIsRunning(true);
        
    }//GEN-LAST:event_btnReanudarActionPerformed

    private void btnpausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpausarActionPerformed
        this.cronometro.pauseThreadCrono();
        this.hilo.pauseThread();
        this.cancion.stopMusic();
    }//GEN-LAST:event_btnpausarActionPerformed

    private void btnreanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreanudarActionPerformed
        this.cronometro.reanudarThreadCrono();
        this.hilo.reanudarThread();
        this.cancion.playMusic();
    }//GEN-LAST:event_btnreanudarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        btnpausar.doClick();
        this.guardar=this.hilo.procesoGuardado();
        this.guardar+=this.cronometro.getSeconds()+"\n"; //segundos
        this.guardar+=cronometro.getMinutes()+"\n"; //minutos
        this.datos=new FileManager();
        this.pathMemoria+=JOptionPane.showInputDialog(boxGuardar, "favor ingrese su nombre", "GUARDAR", 2).toUpperCase();
        this.datos.createFile(this.pathMemoria);
        this.datos.writeToFile(this.pathMemoria, this.guardar);
        this.setVisible(false);

    }//GEN-LAST:event_btnguardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelFig2;
    private javax.swing.JLabel JLabelFig3;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnpausar;
    private javax.swing.JButton btnreanudar;
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
