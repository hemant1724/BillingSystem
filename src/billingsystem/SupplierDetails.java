/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem;

import billingsystem.dao.SupplierDAO;
import billingsystem.model.SupplierModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SupplierDetails extends javax.swing.JFrame {

    DefaultTableModel dtm;
    public SupplierDetails() {
        initComponents();
         datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.getBillModelList();
        for (SupplierModel p : al) {
            Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
            dtm.addRow(o);
        }
        datatable.setModel(dtm);
          searchtxt.setText(null);
          
            Action refreshAction = new AbstractAction("refresh") {

            @Override
            public void actionPerformed(ActionEvent e) {
                 datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.getBillModelList();
        for (SupplierModel p : al) {
            Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
            dtm.addRow(o);
        }
        datatable.setModel(dtm);
          searchtxt.setText(null);

            }
        };
        String key = "refresh";
        this.refreshbtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK), key);
        this.refreshbtn.getActionMap().put(key, refreshAction);

        // ctrl + P code (print)
        Action printAction = new AbstractAction("print") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int p = JOptionPane.showConfirmDialog(null, "Do you really want to Print Table", "Print", JOptionPane.YES_NO_OPTION);
                if (p == 0) {
                    MessageFormat header = new MessageFormat("Report Print");
                    MessageFormat footer = new MessageFormat("Page{0,number,integer}");
                    try {
                        datatable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                    } catch (PrinterException ex) {
                        System.err.format("cannot Print %s%n", ex.getMessage());
                    }
                }

            }
        };
        String key3 = "print";
        this.refreshbtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), key3);
        this.refreshbtn.getActionMap().put(key3, printAction);

        // add export ctrl + X
        Action exportAction = new AbstractAction("export") {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutputStream excelFOU = null;
                BufferedOutputStream excelBOU = null;
                XSSFWorkbook excelJTableExporter = null;
                JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\hp\\Desktop\\Documents\\billing");
                excelFileChooser.setDialogTitle("Save As ..");
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                excelFileChooser.setFileFilter(fnef);
                int excelChooser = excelFileChooser.showSaveDialog(null);

                if (excelChooser == JFileChooser.APPROVE_OPTION) {

                    try {
                        excelJTableExporter = new XSSFWorkbook();
                        XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                        for (int i = 0; i < datatable.getRowCount(); i++) {
                            XSSFRow excelRow = excelSheet.createRow(i);

                            for (int j = 0; j < datatable.getColumnCount(); j++) {
                                XSSFCell excelcell = excelRow.createCell(j);

                                excelcell.setCellValue(datatable.getValueAt(i, j).toString() + "\t");

                            }
                        }
                        excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                        excelBOU = new BufferedOutputStream(excelFOU);
                        excelJTableExporter.write(excelBOU);
                        JOptionPane.showMessageDialog(null, "Data Exported Successfully !", "Export", JOptionPane.INFORMATION_MESSAGE);

                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        try {
                            if (excelBOU != null) {
                                excelBOU.close();
                            }
                            if (excelFOU != null) {
                                excelFOU.close();
                            }

                            if (excelJTableExporter != null) {
                                excelJTableExporter.close();
                            }

                            //excelFOU.close();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        };
        String key2 = "export";
        this.export.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), key2);
        this.export.getActionMap().put(key2, exportAction);
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable();
        refreshbtn = new javax.swing.JButton();
        searchtxt = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        export = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1045, 690));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Supplier Details");

        datatable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        datatable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "SupplierName", "Mobile", "ItemCode", "ItemName", "Rate", "MRP", "Quantity", "Total", "Amt Paid", "Due", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        datatable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datatable.setGridColor(new java.awt.Color(51, 51, 51));
        datatable.setRowHeight(18);
        datatable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        datatable.getTableHeader().setReorderingAllowed(false);
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                datatableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        refreshbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        refreshbtn.setText("Refresh");
        refreshbtn.setToolTipText("ctrl+R");
        refreshbtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                refreshbtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                refreshbtnFocusLost(evt);
            }
        });
        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });
        refreshbtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                refreshbtnKeyPressed(evt);
            }
        });

        searchtxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchtxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchtxtKeyTyped(evt);
            }
        });

        searchbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchbtn.setText("Search");
        searchbtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchbtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchbtnFocusLost(evt);
            }
        });
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        searchbtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchbtnKeyPressed(evt);
            }
        });

        export.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        export.setText("Export ");
        export.setToolTipText("ctrl+X");
        export.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exportFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                exportFocusLost(evt);
            }
        });
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        export.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exportKeyPressed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setText("Delete");
        delete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deleteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                deleteFocusLost(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteKeyPressed(evt);
            }
        });

        printbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        printbtn.setText("Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 736, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(printbtn))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(searchtxt)
                    .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(export))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(printbtn))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
       /*int column = 0;
        int row = datatable.getSelectedRow();
        String value = "" + datatable.getModel().getValueAt(row, column);
        int selectedId = Integer.parseInt(value);
        String[] options = {"New Bill", "Update Bill"};
        int x = JOptionPane.showOptionDialog(this, "Choose Any One.", "Click a Button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            dispose();
            new BillFrame2(selectedId).setVisible(true);
        } else if (x == 1) {
            //dispose();
            new UpdateBill(selectedId).setVisible(true);
        }*/
    }//GEN-LAST:event_datatableMouseClicked

    private void datatableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyPressed
       /* if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int column = 0;
            int row = datatable.getSelectedRow();
            String value = "" + datatable.getModel().getValueAt(row, column);
            int selectedId = Integer.parseInt(value);
            String[] options = {"New Bill", "Update Bill"};
            int x = JOptionPane.showOptionDialog(this, "Choose Any One.", "Click a Button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (x == 0) {
                dispose();
                new BillFrame2(selectedId).setVisible(true);
            } else if (x == 1) {
                //dispose();
                new UpdateBill(selectedId).setVisible(true);
            }
        }*/
    }//GEN-LAST:event_datatableKeyPressed

    private void refreshbtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refreshbtnFocusGained
        refreshbtn.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_refreshbtnFocusGained

    private void refreshbtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refreshbtnFocusLost
        refreshbtn.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_refreshbtnFocusLost

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbtnActionPerformed
        datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.getBillModelList();
        for (SupplierModel p : al) {
            Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
            dtm.addRow(o);
        }
        datatable.setModel(dtm);
        searchtxt.setText(null);
    }//GEN-LAST:event_refreshbtnActionPerformed

    private void refreshbtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refreshbtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.getBillModelList();
        for (SupplierModel p : al) {
            Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
            dtm.addRow(o);
        }
        datatable.setModel(dtm);
        searchtxt.setText(null);

        }
    }//GEN-LAST:event_refreshbtnKeyPressed

    private void searchtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             String searchText = searchtxt.getText();
         datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.searchList(searchText);
        if (al.size() != 0) {
            for (SupplierModel p : al) {
                 Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
                dtm.addRow(o);
            }
            datatable.setModel(dtm);
        } else {
            JOptionPane.showMessageDialog(this, "No Search FOund.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_searchtxtKeyPressed

    private void searchtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtxtKeyReleased
        //String value = (String) searchBy.getSelectedItem();
        //  ViewPanelModel viewPanelModel = new ViewPanelModel();
        String searchText = searchtxt.getText();
         datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.searchList(searchText);
        if (al.size() != 0) {
            for (SupplierModel p : al) {
                 Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
                dtm.addRow(o);
            }
            datatable.setModel(dtm);
        } else {
            JOptionPane.showMessageDialog(this, "No Search FOund.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchtxtKeyReleased

    private void searchtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtxtKeyTyped
          String searchText = searchtxt.getText();
         datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.searchList(searchText);
        if (al.size() != 0) {
            for (SupplierModel p : al) {
                 Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
                dtm.addRow(o);
            }
            datatable.setModel(dtm);
        } else {
            JOptionPane.showMessageDialog(this, "No Search FOund.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchtxtKeyTyped

    private void searchbtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchbtnFocusGained
        searchbtn.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_searchbtnFocusGained

    private void searchbtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchbtnFocusLost
        searchbtn.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_searchbtnFocusLost

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        //String value = (String) searchBy.getSelectedItem();
        //  ViewPanelModel viewPanelModel = new ViewPanelModel();
        String searchText = searchtxt.getText();
         datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.searchList(searchText);
        if (al.size() != 0) {
            for (SupplierModel p : al) {
                 Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
                dtm.addRow(o);
            }
            datatable.setModel(dtm);
        } else {
            JOptionPane.showMessageDialog(this, "No Search FOund.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchbtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              String searchText = searchtxt.getText();
         datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.searchList(searchText);
        if (al.size() != 0) {
            for (SupplierModel p : al) {
                 Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
                dtm.addRow(o);
            }
            datatable.setModel(dtm);
        } else {
            JOptionPane.showMessageDialog(this, "No Search FOund.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }

        }
    }//GEN-LAST:event_searchbtnKeyPressed

    private void exportFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exportFocusGained
        export.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_exportFocusGained

    private void exportFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exportFocusLost
        export.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_exportFocusLost

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\hp\\Desktop\\Documents\\supplier");
        excelFileChooser.setDialogTitle("Save As ..");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                for (int i = 0; i < datatable.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);

                    for (int j = 0; j < datatable.getColumnCount(); j++) {
                        XSSFCell excelcell = excelRow.createCell(j);

                        excelcell.setCellValue(datatable.getValueAt(i, j).toString() + "\t");

                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Data Exported Successfully !", "Export", JOptionPane.INFORMATION_MESSAGE);

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }

                    //excelFOU.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_exportActionPerformed

    private void exportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exportKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            FileOutputStream excelFOU = null;
            BufferedOutputStream excelBOU = null;
            XSSFWorkbook excelJTableExporter = null;
            JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\hp\\Desktop\\Documents\\billing");
            excelFileChooser.setDialogTitle("Save As ..");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
            excelFileChooser.setFileFilter(fnef);
            int excelChooser = excelFileChooser.showSaveDialog(null);

            if (excelChooser == JFileChooser.APPROVE_OPTION) {

                try {
                    excelJTableExporter = new XSSFWorkbook();
                    XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                    for (int i = 0; i < datatable.getRowCount(); i++) {
                        XSSFRow excelRow = excelSheet.createRow(i);

                        for (int j = 0; j < datatable.getColumnCount(); j++) {
                            XSSFCell excelcell = excelRow.createCell(j);

                            excelcell.setCellValue(datatable.getValueAt(i, j).toString() + "\t");

                        }
                    }
                    excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                    excelBOU = new BufferedOutputStream(excelFOU);
                    excelJTableExporter.write(excelBOU);
                    JOptionPane.showMessageDialog(null, "Data Exported Successfully !", "Export", JOptionPane.INFORMATION_MESSAGE);

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (excelBOU != null) {
                            excelBOU.close();
                        }
                        if (excelFOU != null) {
                            excelFOU.close();
                        }

                        if (excelJTableExporter != null) {
                            excelJTableExporter.close();
                        }

                        //excelFOU.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Export", "Failed.", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }
    }//GEN-LAST:event_exportKeyPressed

    private void deleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteFocusGained
        delete.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_deleteFocusGained

    private void deleteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteFocusLost
        delete.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_deleteFocusLost

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) datatable.getModel();
        int bottom_value = 0 + Integer.parseInt(JOptionPane.showInputDialog(this, "Choose Bottom_Value", "Enter Last Entry top be deleted", JOptionPane.QUESTION_MESSAGE));
        int top_value = (Integer.parseInt(JOptionPane.showInputDialog(this, "Choose Top_Value", "Enter Last Entry top be deleted", JOptionPane.QUESTION_MESSAGE)) + 0);
        //  int   status = JOptionPane.showConfirmDialog(this, "Are you sure to delete ?");
        int y = JOptionPane.showConfirmDialog(this, "Do you really want to delete data", "Delete", JOptionPane.YES_NO_OPTION);

        if (SupplierDAO.deleteData(bottom_value, top_value) && y == 0) {
            JOptionPane.showMessageDialog(this, "Data Deleted successfully.", "Delete", JOptionPane.INFORMATION_MESSAGE);
             datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.getBillModelList();
        for (SupplierModel p : al) {
            Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
            dtm.addRow(o);
        }
        datatable.setModel(dtm);
            searchtxt.setText(null);
        } else {
            JOptionPane.showMessageDialog(this, "Failed.", "Delete", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_deleteActionPerformed

    private void deleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel model = (DefaultTableModel) datatable.getModel();
            int bottom_value = 0 + Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Last Entry top be deleted", "Choose Bottom_Value", JOptionPane.QUESTION_MESSAGE));
            int top_value = (Integer.parseInt(JOptionPane.showInputDialog(this,  "Enter Last Entry top be deleted","Choose Top_Value", JOptionPane.QUESTION_MESSAGE)) + 0);

            int y = JOptionPane.showConfirmDialog(this, "Do you really want to delete data", "Delete", JOptionPane.YES_NO_OPTION);

            if (SupplierDAO.deleteData(bottom_value, top_value) && y == 0) {
                JOptionPane.showMessageDialog(this, "Data Deleted successfully.", "Delete", JOptionPane.INFORMATION_MESSAGE);
                datatable.setModel(new DefaultTableModel(null, new String[]{"SupplierName","Mobile","ItemCode","ItemName","Rate","MRP","Quantity","Total","AmtPaid","Due","Date"}));

        dtm = (DefaultTableModel) datatable.getModel();
        ArrayList<SupplierModel> al = SupplierDAO.getBillModelList();
        for (SupplierModel p : al) {
            Object o[] = {p.getId(), p.getSuppliername(), p.getMobile(), p.getItemcode(), p.getItemname(), p.getRate(), p.getMrp(),p.getQty(),p.getTotal(),p.getAmtpaid(), p.getDue(),p.getDate()};
            dtm.addRow(o);
        }
        datatable.setModel(dtm);
                searchtxt.setText(null);
            } else {
                JOptionPane.showMessageDialog(this, "Failed.", "Delete", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_deleteKeyPressed

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        int p = JOptionPane.showConfirmDialog(this, "Do you really want to Print Table", "Print", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            MessageFormat header = new MessageFormat("Report Print");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            try {
                PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);

                datatable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            } catch (PrinterException ex) {
                System.err.format("cannot Print %s%n", ex.getMessage());
            }
        }
    }//GEN-LAST:event_printbtnActionPerformed

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
            java.util.logging.Logger.getLogger(SupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datatable;
    private javax.swing.JButton delete;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton printbtn;
    private javax.swing.JButton refreshbtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField searchtxt;
    // End of variables declaration//GEN-END:variables
}
