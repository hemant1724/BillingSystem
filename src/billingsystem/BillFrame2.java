package billingsystem;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import billingsystem.dao.BillDAO;
import billingsystem.model.BillModel;

/**
 *
 * @author hp
 */
public class BillFrame2 extends javax.swing.JFrame {

    public BillFrame2() {
    }
    boolean status = false;
    float t = 0f;
    float du = 0f;
    int fields = 0;
    int selectedId;
    DefaultTableModel dtm;
    ArrayList<BillModel> al = new ArrayList<BillModel>();

    public BillFrame2(int selectedId) {
        this.selectedId = selectedId;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo Trinaabh.png")));

        status = false;
        BillModel b = new BillModel();
        b.setId(selectedId);
        BillDAO.fecthDataInModel(b);
        name.setText(b.getName());
        mobile.setText(b.getMobile());
        address.setText(b.getAddress());
        due.setText("" + b.getDue());

        this.rate.setText("" + 0.0);
        this.amount.setText("" + 0.0);
        this.qtyspinner.setValue(0);
        this.weightspinner.setValue(0);

        Action saveAction = new AbstractAction("save") {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (status == true) {
                    du = Float.parseFloat(due.getText());
                    t = t + du;
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Total + Due = " + t, "Total.", JOptionPane.INFORMATION_MESSAGE);
                    new PrintFrame(al, du).setVisible(true);
                    name.setText(null);
                    mobile.setText(null);
                    address.setText(null);
                    rate.setText(null);
                    amount.setText(null);
                    total.setText(null);
                    qtyspinner.setValue(0);
                    weightspinner.setValue(0);
                    itemnametxt.setText(null);
                    itemcodetxt.setText(null);
                    status = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all required fields.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
                }

            }
        };
        String key = "save";
        this.save.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), key);
        this.save.getActionMap().put(key, saveAction);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        add = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        qtyspinner = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JSeparator();
        reset = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        due = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        itemcodetxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        itemnametxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        weightspinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Bill");
        setMinimumSize(new java.awt.Dimension(472, 632));
        setName("BillFrame2"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1045, 690));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Bill ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mobile");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Address");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Rate");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Amount");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Total");

        add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add.setText("Add");
        add.setToolTipText("ctrl+S");
        add.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addFocusLost(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setToolTipText("Please Enter Name.");
        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        mobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobile.setToolTipText("Please Enter Mobile No. .");
        mobile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totalKeyPressed(evt);
            }
        });

        address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        address.setToolTipText("Please Enter Address .");
        address.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountFocusGained(evt);
            }
        });
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountKeyPressed(evt);
            }
        });

        rate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rate.setToolTipText("Please Enter Rate  .");
        rate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rateFocusLost(evt);
            }
        });

        qtyspinner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qtyspinner.setModel(new javax.swing.SpinnerNumberModel());
        qtyspinner.setToolTipText("Enter Quantity .");
        qtyspinner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reset.setText("Reset");
        reset.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                resetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                resetFocusLost(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        reset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resetKeyPressed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setText("Save");
        save.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                saveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                saveFocusLost(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Due");

        due.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        due.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        due.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dueKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Item Code");

        itemcodetxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itemcodetxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Item Name");

        itemnametxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itemnametxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Kg/L", "Qty", "Rate", "Amount"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1.setRowHeight(22);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Kg/L");

        weightspinner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weightspinner.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 0.25f));
        weightspinner.setToolTipText("Enter Quantity .");
        weightspinner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        weightspinner.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        weightspinner.setEditor(new javax.swing.JSpinner.NumberEditor(weightspinner, ""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(reset)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(save))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(total))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(due))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(qtyspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(add))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(itemnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(amount))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(weightspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weightspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(due, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(save))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        BillModel billModel = new BillModel();
        status = false;
        String name = this.name.getText();
        StringBuilder sb = new StringBuilder(name);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        name = sb.toString();
        if (name.length() != 0) {
            fields++;
        }

        String mobile = this.mobile.getText();
        String regex = "[6-9][0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        if (mobile.length() != 0) {
            if (matcher.matches()) {
                fields++;
            }
        } else {
            mobile = "Nil";
            fields++;
        }

        String address = this.address.getText();

        if (address.length() != 0) {
            fields++;
        } else {
            address = "Nil";
            fields++;
        }

        Date d = new Date();
        SimpleDateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        String date = da.format(d);

        billModel.setDate(date);
        billModel.setName(name);
        billModel.setMobile(mobile);
        billModel.setAddress(address);

        String itemcode = this.itemcodetxt.getText();
        if (itemcode.length() != 0) {
            fields++;
        } else {
            itemcodetxt.setText("Nil");
            fields++;
        }

        float weight = Float.parseFloat(this.weightspinner.getValue().toString());
        if (weight != 0) {
            fields++;
        }

        float am = Float.parseFloat(this.amount.getText());
        if (am != 0) {
            fields++;
        }

        t = t + am;
        this.total.setText("" + t);

        String itemname = this.itemnametxt.getText();
        if (itemname.length() != 0) {
            fields++;
        }

        int qty = (int) this.qtyspinner.getValue();
        if (qty != 0) {
            fields++;
        }

        float rate = Float.parseFloat(this.rate.getText());
        if (rate != 0) {
            fields++;
        }

        float total = Float.parseFloat(this.total.getText());
        billModel.setQty("" + qty);
        billModel.setAmount(am);
        billModel.setDescription(itemname);
        billModel.setRate(rate);
        billModel.setTotal(total);
        billModel.setWeight(weight);
        billModel.setItemcode(itemcode);

        if (fields == 9) {
            al.add(billModel);
            // JOptionPane.showMessageDialog(this, "Data Added.", "Submmision sucessful.", JOptionPane.INFORMATION_MESSAGE);
            jTable1.setModel(new DefaultTableModel(null, new String[]{"Item Name", "Kg/L", "Qty", "Rate", "Amount"}));

            dtm = (DefaultTableModel) jTable1.getModel();
            for (BillModel p : al) {

                Object o[] = {p.getDescription(), p.getWeight(), p.getQty(), p.getRate(), p.getAmount()};
                dtm.addRow(o);
            }
            jTable1.setModel(dtm);
            fields = 0;
            status = true;
            // this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please Enter Appropriate Data.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
            fields = 0;
            t = t - am;
            this.total.setText("" + t);
            status = false;
        }

        this.rate.setText("" + 0.0);
        this.amount.setText("" + 0.0);
        this.qtyspinner.setValue(0);
        this.itemnametxt.setText(null);
        this.weightspinner.setValue(0);
        this.itemcodetxt.setText(null);
        this.itemcodetxt.requestFocus();

    }//GEN-LAST:event_addActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        this.rate.setText("" + 0.0);
        this.amount.setText("" + 0.0);
        this.total.setText("" + 0.0);
        this.qtyspinner.setValue(0);
        this.weightspinner.setValue(0);
        this.itemcodetxt.setText(null);
        this.itemnametxt.setText(null);
    }//GEN-LAST:event_resetActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (status == true) {
            du = Float.parseFloat(due.getText());
            t = t + du;
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Total + Due = " + t, "Total.", JOptionPane.INFORMATION_MESSAGE);
            new PrintFrame(al, du).setVisible(true);
            name.setText(null);
            mobile.setText(null);
            address.setText(null);
            rate.setText(null);
            amount.setText(null);
            total.setText(null);
            qtyspinner.setValue(0);
            weightspinner.setValue(0);
            itemnametxt.setText(null);
            itemcodetxt.setText(null);
            status = false;
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all required fields.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_saveActionPerformed

    private void amountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountFocusGained
         float rate = Float.parseFloat(this.rate.getText());
        int qty = (int) this.qtyspinner.getValue();
        float weight = Float.parseFloat(this.weightspinner.getValue().toString());
        float amount = qty * rate * weight;
        this.amount.setText("" + amount);
    }//GEN-LAST:event_amountFocusGained

    private void amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BillModel billModel = new BillModel();
            status = false;
            String name = this.name.getText();
            StringBuilder sb = new StringBuilder(name);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            name = sb.toString();
            if (name.length() != 0) {
                fields++;
            }

            String mobile = this.mobile.getText();
            String regex = "[6-9][0-9]{9}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(mobile);
            if (mobile.length() != 0) {
                if (matcher.matches()) {
                    fields++;
                }
            } else {
                mobile = "Nil";
                fields++;
            }

            String address = this.address.getText();

            if (address.length() != 0) {
                fields++;
            } else {
                address = "Nil";
                fields++;
            }

            Date d = new Date();
            SimpleDateFormat da = new SimpleDateFormat("dd/MM/yyyy");
            String date = da.format(d);

            billModel.setDate(date);
            billModel.setName(name);
            billModel.setMobile(mobile);
            billModel.setAddress(address);

            String itemcode = this.itemcodetxt.getText();
            if (itemcode.length() != 0) {
                fields++;
            } else {
                itemcodetxt.setText("Nil");
                fields++;
            }

            float weight = Float.parseFloat(this.weightspinner.getValue().toString());
            if (weight != 0) {
                fields++;
            }

            float am = Float.parseFloat(this.amount.getText());
            if (am != 0) {
                fields++;
            }

            t = t + am;
            this.total.setText("" + t);

            String itemname = this.itemnametxt.getText();
            if (itemname.length() != 0) {
                fields++;
            }

            int qty = (int) this.qtyspinner.getValue();
            if (qty != 0) {
                fields++;
            }

            float rate = Float.parseFloat(this.rate.getText());
            if (rate != 0) {
                fields++;
            }

            float total = Float.parseFloat(this.total.getText());
            billModel.setQty("" + qty);
            billModel.setAmount(am);
            billModel.setDescription(itemname);
            billModel.setRate(rate);
            billModel.setTotal(total);
            billModel.setWeight(weight);
            billModel.setItemcode(itemcode);

            if (fields == 9) {
                al.add(billModel);
                // JOptionPane.showMessageDialog(this, "Data Added.", "Submmision sucessful.", JOptionPane.INFORMATION_MESSAGE);
                jTable1.setModel(new DefaultTableModel(null, new String[]{"Item Name", "Kg/L", "Qty", "Rate", "Amount"}));

                dtm = (DefaultTableModel) jTable1.getModel();
                for (BillModel p : al) {

                    Object o[] = {p.getDescription(), p.getWeight(), p.getQty(), p.getRate(), p.getAmount()};
                    dtm.addRow(o);
                }
                jTable1.setModel(dtm);
                fields = 0;
                status = true;
                // this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Appropriate Data.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
                fields = 0;
                t = t - am;
                this.total.setText("" + t);
                status = false;
            }

            this.rate.setText("" + 0.0);
            this.amount.setText("" + 0.0);
            this.qtyspinner.setValue(0);
            this.itemnametxt.setText(null);
            this.weightspinner.setValue(0);
            this.itemcodetxt.setText(null);
            this.itemcodetxt.requestFocus();

        }
    }//GEN-LAST:event_amountKeyPressed

    private void rateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusGained
        this.rate.setText("");
    }//GEN-LAST:event_rateFocusGained

    private void addFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFocusGained
        add.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_addFocusGained

    private void addFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFocusLost
        add.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_addFocusLost

    private void saveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saveFocusGained
        save.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_saveFocusGained

    private void saveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saveFocusLost
        save.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_saveFocusLost

    private void resetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resetFocusGained
        reset.setBackground(Color.decode("0x999999"));
    }//GEN-LAST:event_resetFocusGained

    private void resetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resetFocusLost
        reset.setBackground(Color.decode("0xF0F0F0"));
    }//GEN-LAST:event_resetFocusLost

    private void saveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (status == true) {
                du = Float.parseFloat(this.due.getText());
                t = t + du;
                this.setVisible(false);
                JOptionPane.showMessageDialog(this, "Total + Due = " + t, "Total.", JOptionPane.INFORMATION_MESSAGE);
                new PrintFrame(al, du).setVisible(true);

                this.name.setText(null);
                this.mobile.setText(null);
                this.address.setText(null);
                this.rate.setText(null);
                this.amount.setText(null);
                this.total.setText(null);
                this.qtyspinner.setValue(0);
                this.weightspinner.setValue(0);
                this.itemcodetxt.setText(null);
                this.itemnametxt.setText(null);
                status = false;

            } else {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveKeyPressed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BillModel billModel = new BillModel();
            status = false;
            String name = this.name.getText();
            StringBuilder sb = new StringBuilder(name);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            name = sb.toString();
            if (name.length() != 0) {
                fields++;
            }

            String mobile = this.mobile.getText();
            String regex = "[6-9][0-9]{9}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(mobile);
            if (mobile.length() != 0) {
                if (matcher.matches()) {
                    fields++;
                }
            } else {
                mobile = "Nil";
                fields++;
            }

            String address = this.address.getText();

            if (address.length() != 0) {
                fields++;
            } else {
                address = "Nil";
                fields++;
            }

            Date d = new Date();
            SimpleDateFormat da = new SimpleDateFormat("dd/MM/yyyy");
            String date = da.format(d);

            billModel.setDate(date);
            billModel.setName(name);
            billModel.setMobile(mobile);
            billModel.setAddress(address);

            String itemcode = this.itemcodetxt.getText();
            if (itemcode.length() != 0) {
                fields++;
            } else {
                itemcodetxt.setText("Nil");
                fields++;
            }

            float weight = Float.parseFloat(this.weightspinner.getValue().toString());
            if (weight != 0) {
                fields++;
            }

            float am = Float.parseFloat(this.amount.getText());
            if (am != 0) {
                fields++;
            }

            t = t + am;
            this.total.setText("" + t);

            String itemname = this.itemnametxt.getText();
            if (itemname.length() != 0) {
                fields++;
            }

            int qty = (int) this.qtyspinner.getValue();
            if (qty != 0) {
                fields++;
            }

            float rate = Float.parseFloat(this.rate.getText());
            if (rate != 0) {
                fields++;
            }

            float total = Float.parseFloat(this.total.getText());
            billModel.setQty("" + qty);
            billModel.setAmount(am);
            billModel.setDescription(itemname);
            billModel.setRate(rate);
            billModel.setTotal(total);
            billModel.setWeight(weight);
            billModel.setItemcode(itemcode);

            if (fields == 9) {
                al.add(billModel);
                // JOptionPane.showMessageDialog(this, "Data Added.", "Submmision sucessful.", JOptionPane.INFORMATION_MESSAGE);
                jTable1.setModel(new DefaultTableModel(null, new String[]{"Item Name", "Kg/L", "Qty", "Rate", "Amount"}));

                dtm = (DefaultTableModel) jTable1.getModel();
                for (BillModel p : al) {

                    Object o[] = {p.getDescription(), p.getWeight(), p.getQty(), p.getRate(), p.getAmount()};
                    dtm.addRow(o);
                }
                jTable1.setModel(dtm);
                fields = 0;
                status = true;
                // this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Appropriate Data.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
                fields = 0;
                t = t - am;
                this.total.setText("" + t);
                status = false;
            }

            this.rate.setText("" + 0.0);
            this.amount.setText("" + 0.0);
            this.qtyspinner.setValue(0);
            this.itemnametxt.setText(null);
            this.weightspinner.setValue(0);
            this.itemcodetxt.setText(null);
            this.itemcodetxt.requestFocus();

        }
    }//GEN-LAST:event_addKeyPressed

    private void resetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            this.rate.setText("" + 0.0);
            this.amount.setText("" + 0.0);
            this.total.setText("" + 0.0);
            this.qtyspinner.setValue(0);
             this.weightspinner.setValue(0);
            this.itemnametxt.setText(null);
            this.itemcodetxt.setText(null);
        }
    }//GEN-LAST:event_resetKeyPressed

    private void totalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (status == true) {
                du = Float.parseFloat(this.due.getText());
                t = t + du;
                this.setVisible(false);
                JOptionPane.showMessageDialog(this, "Total + Due = " + t, "Total.", JOptionPane.INFORMATION_MESSAGE);
                new PrintFrame(al, du).setVisible(true);

                this.name.setText(null);
                this.mobile.setText(null);
                this.address.setText(null);
                this.rate.setText(null);
                this.amount.setText(null);
                this.total.setText(null);
                this.qtyspinner.setValue(0);
                this.weightspinner.setValue(0);
                this.itemcodetxt.setText(null);
                this.itemnametxt.setText(null);
                status = false;

            } else {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.", "Submmision Falied.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_totalKeyPressed

    private void dueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dueKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dueKeyPressed

    private void rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusLost
        if (rate.getText().length() == 0) {
            rate.setText("0.0");
        }
    }//GEN-LAST:event_rateFocusLost

    /**
     * @param args the command line arguments
     */
    /**
     * public static void main(String args[]) { /* Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    /**
     * try { for (javax.swing.UIManager.LookAndFeelInfo info :
     * javax.swing.UIManager.getInstalledLookAndFeels()) { if
     * ("Nimbus".equals(info.getName())) {
     * javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } }
     * catch (ClassNotFoundException ex) {
     * java.util.logging.Logger.getLogger(BillFrame2.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } catch (InstantiationException ex) {
     * java.util.logging.Logger.getLogger(BillFrame2.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } catch (IllegalAccessException ex) {
     * java.util.logging.Logger.getLogger(BillFrame2.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     * java.util.logging.Logger.getLogger(BillFrame2.class.getName()).log(java.util.logging.Level.SEVERE,
     * null, ex); } //</editor-fold>
     * //</editor-fold>
     *
     * /* Create and display the form
     */
    /**
     * java.awt.EventQueue.invokeLater(new Runnable() { public void run() { //
     * new BillFrame2().setVisible(true); } }); }
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField address;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField due;
    private javax.swing.JTextField itemcodetxt;
    private javax.swing.JTextField itemnametxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JSpinner qtyspinner;
    private javax.swing.JTextField rate;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTextField total;
    private javax.swing.JSpinner weightspinner;
    // End of variables declaration//GEN-END:variables
}
