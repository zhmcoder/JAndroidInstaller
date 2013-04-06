/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JAndroidInstaller.UIComponent;

import JAndroidInstaller.AndroidDevice.APKBaseInfoEntry;
import JAndroidInstaller.AndroidDevice.USBDeviceWorker;
import WSwingUILib.Component.JMiddleContentPanel;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author wcss
 */
public class JAndroidAPKInstaller extends JMiddleContentPanel {

    ArrayList<APKBaseInfoEntry> needInstallFiles = new ArrayList<APKBaseInfoEntry>();

    /**
     * Creates new form JAndroidAPKInstaller
     */
    public JAndroidAPKInstaller() {
        initComponents();
        plReadme.setReadmeInfo("APK批量安装");
        this.ubtnLoadFromDir.setButtonText("批量导入");
        this.ubtnDelete.setButtonText("删除该记录");
        this.ubtnInstallToPhone.setButtonText("安装所有到内存");
        this.ubtnInstallToSdcard.setButtonText("安装所有到存储卡");
        this.ubtnUninstall.setButtonText("卸载该应用");
        this.ubtnClear.setButtonText("清空");
        this.tleApkList.setBackground(Color.white);
        this.tleApkList.getTableHeader().setBackground(Color.white);
        if (JAPKInstallerUI.currentArgs != null && JAPKInstallerUI.currentArgs.length > 0)
        {
            if (new File(JAPKInstallerUI.currentArgs[0]).exists())
            {
                try {
                    APKBaseInfoEntry aie = USBDeviceWorker.readAPKInfo(JAPKInstallerUI.currentArgs[0]);
                    needInstallFiles.add(aie);
                    JAPKInstallerUI.currentArgs = null;
                } catch (Exception ex) {
                    Logger.getLogger(JAndroidAPKInstaller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
    }

    /**
     * 选择安装包文件
     *
     * @return
     */
    public File[] showOpenDialogs() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("选择要导入的APK文件！");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "APK安装包", "apk");
        jfc.setFileFilter(filter);
        int option = jfc.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFiles();
        } else {
            return null;
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

        plReadme = new JAndroidInstaller.UIComponent.JReadmePanel();
        ubtnLoadFromDir = new WSwingUILib.Component.JUIButton();
        ubtnDelete = new WSwingUILib.Component.JUIButton();
        ubtnInstallToSdcard = new WSwingUILib.Component.JUIButton();
        ubtnInstallToPhone = new WSwingUILib.Component.JUIButton();
        ubtnUninstall = new WSwingUILib.Component.JUIButton();
        ubtnClear = new WSwingUILib.Component.JUIButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tleApkList = new javax.swing.JTable();

        ubtnLoadFromDir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubtnLoadFromDirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubtnLoadFromDirLayout = new javax.swing.GroupLayout(ubtnLoadFromDir);
        ubtnLoadFromDir.setLayout(ubtnLoadFromDirLayout);
        ubtnLoadFromDirLayout.setHorizontalGroup(
            ubtnLoadFromDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        ubtnLoadFromDirLayout.setVerticalGroup(
            ubtnLoadFromDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        ubtnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubtnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubtnDeleteLayout = new javax.swing.GroupLayout(ubtnDelete);
        ubtnDelete.setLayout(ubtnDeleteLayout);
        ubtnDeleteLayout.setHorizontalGroup(
            ubtnDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );
        ubtnDeleteLayout.setVerticalGroup(
            ubtnDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        ubtnInstallToSdcard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubtnInstallToSdcardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubtnInstallToSdcardLayout = new javax.swing.GroupLayout(ubtnInstallToSdcard);
        ubtnInstallToSdcard.setLayout(ubtnInstallToSdcardLayout);
        ubtnInstallToSdcardLayout.setHorizontalGroup(
            ubtnInstallToSdcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );
        ubtnInstallToSdcardLayout.setVerticalGroup(
            ubtnInstallToSdcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        ubtnInstallToPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubtnInstallToPhoneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubtnInstallToPhoneLayout = new javax.swing.GroupLayout(ubtnInstallToPhone);
        ubtnInstallToPhone.setLayout(ubtnInstallToPhoneLayout);
        ubtnInstallToPhoneLayout.setHorizontalGroup(
            ubtnInstallToPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
        ubtnInstallToPhoneLayout.setVerticalGroup(
            ubtnInstallToPhoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        ubtnUninstall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubtnUninstallMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubtnUninstallLayout = new javax.swing.GroupLayout(ubtnUninstall);
        ubtnUninstall.setLayout(ubtnUninstallLayout);
        ubtnUninstallLayout.setHorizontalGroup(
            ubtnUninstallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        ubtnUninstallLayout.setVerticalGroup(
            ubtnUninstallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        ubtnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubtnClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubtnClearLayout = new javax.swing.GroupLayout(ubtnClear);
        ubtnClear.setLayout(ubtnClearLayout);
        ubtnClearLayout.setHorizontalGroup(
            ubtnClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );
        ubtnClearLayout.setVerticalGroup(
            ubtnClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        tleApkList.setFont(new java.awt.Font("文泉驿微米黑", 0, 14)); // NOI18N
        tleApkList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "包英", "包中", "大小", "状态"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tleApkList.setDoubleBuffered(true);
        tleApkList.setFillsViewportHeight(true);
        tleApkList.setShowHorizontalLines(false);
        tleApkList.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tleApkList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plReadme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ubtnLoadFromDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubtnInstallToPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubtnUninstall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubtnInstallToSdcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ubtnLoadFromDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubtnInstallToPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ubtnUninstall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ubtnInstallToSdcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plReadme, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ubtnLoadFromDirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubtnLoadFromDirMouseClicked
        // TODO add your handling code here:
        File[] team = showOpenDialogs();
        if (team != null && team.length > 0) {
            for (File f : team) {
                try {
                    this.needInstallFiles.add(USBDeviceWorker.readAPKInfo(f.getAbsolutePath()));
                } catch (Exception ex) {
                    Logger.getLogger(JAndroidAPKInstaller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
        }
    }//GEN-LAST:event_ubtnLoadFromDirMouseClicked

    private void ubtnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubtnClearMouseClicked
        // TODO add your handling code here:
        this.needInstallFiles.clear();
        this.tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
    }//GEN-LAST:event_ubtnClearMouseClicked

    private void ubtnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubtnDeleteMouseClicked
        // TODO add your handling code here:
        if (this.tleApkList.getSelectedRow() >= 0) {
            if (this.needInstallFiles.size() > this.tleApkList.getSelectedRow()) {
                this.needInstallFiles.remove(this.tleApkList.getSelectedRow());
                this.tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
            }
        }
    }//GEN-LAST:event_ubtnDeleteMouseClicked

    private void ubtnInstallToPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubtnInstallToPhoneMouseClicked
        // TODO add your handling code here:
        if (this.needInstallFiles.size() > 0) {
            this.plReadme.setReadmeInfo("共有" + this.needInstallFiles.size() + "个应用需要安装到内存中，正在安装请稍后......");
            ubtnInstallToPhone.setEnabled(false);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    int curr = 1;
                    for (APKBaseInfoEntry aie : needInstallFiles) {
                        try {
                            //plReadme.setReadmeInfo("共有"+ needInstallFiles.size() +"个应用需要安装到内存中，正在安装第" + curr + "个......");
                            if (USBDeviceWorker.installSoftware(aie.getLocalPath(), true)) {
                                aie.setState("安装成功!");
                            } else {
                                aie.setState("安装失败!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(JAndroidAPKInstaller.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        curr++;
                    }

                    plReadme.setReadmeInfo("安装完成!");
                    tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
                    ubtnInstallToPhone.setEnabled(true);
                }
            });


        }
    }//GEN-LAST:event_ubtnInstallToPhoneMouseClicked

    private void ubtnUninstallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubtnUninstallMouseClicked
        // TODO add your handling code here:
        if (this.tleApkList.getSelectedRow() >= 0) {
            if (this.needInstallFiles.size() > this.tleApkList.getSelectedRow()) {
                final String name = this.needInstallFiles.get(this.tleApkList.getSelectedRow()).getPackageEngName();
                this.plReadme.setReadmeInfo("正在卸载，请稍后...");
                ubtnUninstall.setEnabled(false);

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        if (USBDeviceWorker.uninstallSoftware(name)) {
                            needInstallFiles.get(tleApkList.getSelectedRow()).setState("卸载完成!");
                        } else {
                            needInstallFiles.get(tleApkList.getSelectedRow()).setState("卸载失败!");
                        }

                        tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
                        plReadme.setReadmeInfo("卸载完成");
                        ubtnUninstall.setEnabled(true);
                    }
                });

            }
        }
    }//GEN-LAST:event_ubtnUninstallMouseClicked

    private void ubtnInstallToSdcardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubtnInstallToSdcardMouseClicked
        // TODO add your handling code here:
        if (this.needInstallFiles.size() > 0) {
            this.plReadme.setReadmeInfo("共有" + this.needInstallFiles.size() + "个应用需要安装到存储卡中，正在安装请稍后......");
            ubtnInstallToPhone.setEnabled(false);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    int curr = 1;

                    for (APKBaseInfoEntry aie : needInstallFiles) {
                        try {
                            //plReadme.setReadmeInfo("共有"+ needInstallFiles.size() +"个应用需要安装到存储卡中，正在安装第" + curr + "个......");
                            if (USBDeviceWorker.installSoftware(aie.getLocalPath(), false)) {
                                aie.setState("安装成功!");
                            } else {
                                aie.setState("安装失败!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(JAndroidAPKInstaller.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        curr++;
                    }

                    tleApkList.setModel(new JAndroidAPKListModel(needInstallFiles));
                    plReadme.setReadmeInfo("安装完成！");
                    ubtnInstallToPhone.setEnabled(true);
                }
            });


        }
    }//GEN-LAST:event_ubtnInstallToSdcardMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private JAndroidInstaller.UIComponent.JReadmePanel plReadme;
    private javax.swing.JTable tleApkList;
    private WSwingUILib.Component.JUIButton ubtnClear;
    private WSwingUILib.Component.JUIButton ubtnDelete;
    private WSwingUILib.Component.JUIButton ubtnInstallToPhone;
    private WSwingUILib.Component.JUIButton ubtnInstallToSdcard;
    private WSwingUILib.Component.JUIButton ubtnLoadFromDir;
    private WSwingUILib.Component.JUIButton ubtnUninstall;
    // End of variables declaration//GEN-END:variables
}
