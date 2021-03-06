/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.File;
import javax.swing.JFileChooser;
import lapr.project.controller.CreateProjectController;
import lapr.project.model.Project;
import lapr.project.model.RegistryProject;

/**
 *
 * @author rgcar
 */

public class CreateProjectGUI extends javax.swing.JFrame {
     public static final long serialVersionUID = 1L;
     public File fileVehicle;
     public File fileRoad;
     public RegistryProject rp;

    /**
     * Creates new form CreateProjectGUI
     * @param rp
     */
    public CreateProjectGUI(RegistryProject rp) {
        initComponents();
        this.setLocationRelativeTo(null);
         this.rp = rp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        confirmPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        createBTN = new javax.swing.JButton();
        vehicleFileBtn = new javax.swing.JButton();
        roadsFileBtn = new javax.swing.JButton();
        vehicleConfirmationLbl = new javax.swing.JLabel();
        roadsConfirmationLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        pNameLBL = new javax.swing.JLabel();
        desciptionLBL = new javax.swing.JLabel();
        pNameTF = new javax.swing.JTextField();
        descriptionTF = new javax.swing.JTextField();
        titleLBL = new javax.swing.JLabel();

        fileChooser.setDialogTitle("Choose file");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Project");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        okButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        okButton.setForeground(new java.awt.Color(102, 102, 102));
        okButton.setText("Exit");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        createBTN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createBTN.setForeground(new java.awt.Color(102, 102, 102));
        createBTN.setText("Create");
        createBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmPanelLayout = new javax.swing.GroupLayout(confirmPanel);
        confirmPanel.setLayout(confirmPanelLayout);
        confirmPanelLayout.setHorizontalGroup(
            confirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmPanelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addGroup(confirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        confirmPanelLayout.setVerticalGroup(
            confirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        vehicleFileBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehicleFileBtn.setForeground(new java.awt.Color(102, 102, 102));
        vehicleFileBtn.setText("Select File for Vehicles");
        vehicleFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleFileBtnActionPerformed(evt);
            }
        });

        roadsFileBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        roadsFileBtn.setForeground(new java.awt.Color(102, 102, 102));
        roadsFileBtn.setText("Select File for Roads");
        roadsFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roadsFileBtnActionPerformed(evt);
            }
        });

        vehicleConfirmationLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vehicleConfirmationLbl.setForeground(new java.awt.Color(0, 102, 153));
        vehicleConfirmationLbl.setText("Vehicle File Loaded");

        roadsConfirmationLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roadsConfirmationLbl.setForeground(new java.awt.Color(0, 102, 153));
        roadsConfirmationLbl.setText("Roads File Loaded");

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(1);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(1);
        jScrollPane2.setViewportView(jTextArea2);

        pNameLBL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pNameLBL.setForeground(new java.awt.Color(0, 102, 153));
        pNameLBL.setText("Project Name:");

        desciptionLBL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        desciptionLBL.setForeground(new java.awt.Color(0, 102, 153));
        desciptionLBL.setText("Project Description:");

        pNameTF.setForeground(new java.awt.Color(0, 102, 153));
        pNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNameTFActionPerformed(evt);
            }
        });

        descriptionTF.setForeground(new java.awt.Color(0, 102, 153));

        titleLBL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLBL.setForeground(new java.awt.Color(0, 102, 153));
        titleLBL.setText("Create Project");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(confirmPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(vehicleConfirmationLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roadsConfirmationLbl)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(vehicleFileBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roadsFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(titleLBL)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pNameLBL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pNameTF)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desciptionLBL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionTF)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLBL)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pNameLBL)
                    .addComponent(pNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(desciptionLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleFileBtn)
                    .addComponent(roadsFileBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleConfirmationLbl)
                    .addComponent(roadsConfirmationLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(confirmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vehicleConfirmationLbl.setVisible(false);
        roadsConfirmationLbl.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        super.dispose();
       
    }//GEN-LAST:event_okButtonActionPerformed

    private void vehicleFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleFileBtnActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileVehicle = fileChooser.getSelectedFile();
            String name = fileChooser.getName(fileVehicle);
            String path = fileVehicle.getAbsolutePath();
            jTextArea1.setText(name);

        }
    }//GEN-LAST:event_vehicleFileBtnActionPerformed

    private void roadsFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roadsFileBtnActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileRoad = fileChooser.getSelectedFile();
            String name = fileChooser.getName(fileRoad);
            String path = fileRoad.getAbsolutePath();
            jTextArea2.setText(name);

        }
    }//GEN-LAST:event_roadsFileBtnActionPerformed

    private void createBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBTNActionPerformed

        String projectName = pNameTF.getText();
        String projectDescription = descriptionTF.getText();
        String roadsFileName = jTextArea2.getText();
        String vehiclesFileName = jTextArea1.getText();

        Project proj = new Project();

        CreateProjectController pc = new CreateProjectController(proj, this.rp);

        pc.setData(projectName, projectDescription);
        
        pc.insertProjectInDataBase(projectName, projectDescription);

        pc.importFromFiles(roadsFileName, vehiclesFileName);
        
        
                
        ChooseProjectUI cp = new ChooseProjectUI(this.rp);
        cp.setVisible(true);
        
        this.dispose();
 
    }//GEN-LAST:event_createBTNActionPerformed

    private void pNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNameTFActionPerformed
        
    }//GEN-LAST:event_pNameTFActionPerformed

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
            java.util.logging.Logger.getLogger(CreateProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateProjectGUI().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel confirmPanel;
    private javax.swing.JButton createBTN;
    private javax.swing.JLabel desciptionLBL;
    private javax.swing.JTextField descriptionTF;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel pNameLBL;
    private javax.swing.JTextField pNameTF;
    private javax.swing.JLabel roadsConfirmationLbl;
    private javax.swing.JButton roadsFileBtn;
    private javax.swing.JLabel titleLBL;
    private javax.swing.JLabel vehicleConfirmationLbl;
    private javax.swing.JButton vehicleFileBtn;
    // End of variables declaration//GEN-END:variables
}
