import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientKursova {

	public static Socket sock;
	public static Scanner in;

	public static void main(String[] args) {
		
		boolean flag=true;
		try {
			sock = new Socket("localhost", 1116);
		} catch (UnknownHostException e) {
			PopupWarning.PopupWarning("Wrong host. Please check the hostname", "Error");
			flag=false;
			System.err.println("wrong host");
		} catch (IOException e) {
			PopupWarning.PopupWarning("No connection. Please turn on the server", "Error");
			flag=false;
			System.err.println("could not connect");
		}
       
	if(flag){
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NewJFrame(sock, in).setVisible(true);
				 
				 
			}
		});
	}

	}

	public static void menu() {

		PrintWriter pw = null;
		Scanner sc=null;
		try {
			pw = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			System.err.println("There was a problem please restart the program");
		}
		try {
			in = new Scanner(sock.getInputStream());
		} catch (IOException e) {
			System.err.println("There was a problem please restart the program");
		}

		int num = 0;
		try{
		sc = new Scanner(System.in);
		}catch(InputMismatchException e){
			System.err.println("Wrong input");
		}
		Boolean quit = false;
		while (num != 1 || num != 2) {
			num = sc.nextInt();
			switch (num) {
			case 1:
				pw.println(1);
				pw.flush();
				int n1 = in.nextInt();
				for (int i = 0; i < n1 + 1; i++) {
					System.out.println(in.nextLine());
				}
				break;
			case 2:
				pw.println(2);
				pw.flush();
				int n2 = in.nextInt();
				for (int i = 0; i < n2 + 1; i++) {
					System.out.println(in.nextLine());
				}
				break;
			case 3:
				quit = true;
			}
			if (quit)
				break;
		}

	}
}

class NewJFrame extends javax.swing.JFrame {

	Socket sock = null;
	Scanner in = null;
	
    
	public NewJFrame(Socket sock, Scanner in) {
		this.sock = sock;
		this.in = in;
		initComponents();
		
		
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	    
	@SuppressWarnings("unchecked")
	 private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textArea1 = new java.awt.TextArea();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jComboBox9 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        textField1 = new java.awt.TextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" ���");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("�������");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("�������");

        jLabel4.setText("���. �����");

        jLabel5.setText("��");
        jLabel5.setAlignmentX(0.5F);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setText("��");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("�������:");

        jButton1.setText("�������� �����");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("������ �����");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("\n\n\n\n\n\n");
        jTextArea2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTextArea2ComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("�� ������:");

        jLabel11.setText("���������");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("������");

        jLabel13.setText("���� ��:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel8.setText("�� �����");

        textArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel9.setText("����� �� ����:");

        jButton3.setText("����������");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "more", "ezero", "planina", "reka" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        jComboBox3.setAlignmentX(1.0F);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021" }));

        jButton4.setText("�������");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        textField1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel4)))
                                .addGap(223, 223, 223))
                            .addComponent(jButton4))
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>
    

	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		//PRINTS THE PAST CUSTOMERS
		PrintWriter pw = null;
		String str = "";
		try {
			pw = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			System.out.println("Error writing to server");
		}
		try {
			in = new Scanner(sock.getInputStream());
		} catch (IOException e) {
			System.out.println("There was a problem in reading from the server");
		}
		pw.println(1);
		pw.flush();
		int n1=0;
		if(in.hasNextInt()){
			try{
		n1 = in.nextInt();
			}catch(Exception e){
				System.out.println("Error writing to server");
			}
		if(n1>0){
		
		for (int i = 0; i < n1 + 1; i++) {
			
			str += in.nextLine() + "\n";
		}
		}
		}
		jTextArea2.setText(str);
		jTextArea2.setVisible(true);
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//PRINTS THE PRESENT CUSTOMERS
		PrintWriter pw = null;
		String str = "";
		try {
			pw = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			System.out.println("Error writing to server");
		}
		try {
			in = new Scanner(sock.getInputStream());
		} catch (IOException e) {
			System.out.println("There was a problem in reading from the server");
			e.printStackTrace();
		}
		pw.println(2);
		pw.flush();
		int n1 = in.nextInt();
		for (int i = 0; i < n1 + 1; i++) {
			str += in.nextLine() + "\n";
		}
		jTextArea1.setText(str);
		jTextArea1.setVisible(true);
		}

	private void jTextArea2ComponentShown(java.awt.event.ComponentEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextArea1ComponentShown(java.awt.event.ComponentEvent evt) {
		// TODO add your handling code here:
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TAKES THE INPUT CHARACTERISTICS FOR THE ROOM AND CHECKS FOR A FREE ROOM
		boolean flag=true;
		PrintWriter pw = null;
		String str1="";
		try {
			pw = new PrintWriter(sock.getOutputStream());
		} catch (IOException e1) {
			System.out.println("Error writing to server");
			}
		try {
			in = new Scanner(sock.getInputStream());
		} catch (IOException e2) {
			System.out.println("There was a problem in reading from the server");
		}
		
		
		String kategoria = jComboBox1.getSelectedItem().toString();
		String izgled = jComboBox2.getSelectedItem().toString();
		String brLegla = jComboBox3.getSelectedItem().toString();
		String cena = jTextField5.getText();
		int cenaInt=0;
		if(!cena.isEmpty()){
			try{
				cenaInt=Integer.parseInt(cena);
	           }
	           catch(NumberFormatException e){
	        	   flag=false;
	           }
	    if(flag){
		String send = "Call show_rooms(" + kategoria+ "," + brLegla + ",'" + izgled+ "'," + cena+");";
		String sendTo = "Call show_NUMrooms(" + kategoria+ "," + brLegla + ",'" + izgled+ "'," + cena+");";
		pw.println(3);
		pw.flush();
		pw.println(send);
		pw.flush();
		pw.println(sendTo);
		pw.flush();
		
		int n1=0;
		if(in.hasNextInt()){
			try{
		n1 = in.nextInt();
		System.out.println(n1);
			}catch(Exception e3){
				System.out.println("There was a problem in reading from the server");
			}
		if(n1>0){
		for (int i = 0; i < n1+1 ; i++) {
			if(in.hasNextLine())
			str1 += in.nextLine() + "\n";
		}
		}
		else {
			str1="\n ���� ���� ���������� �� ������������!";
		}
		}
		
		in.reset();
		jComboBox1.setLightWeightPopupEnabled(false);
		jComboBox2.setLightWeightPopupEnabled(false);
		jComboBox3.setLightWeightPopupEnabled(false);
		textArea1.setText("�������� ���� ���������� �� ������������:"+str1);
		textArea1.setVisible(true);
		
		}
	    else PopupWarning.PopupWarning("You have not entered a valid price. Please fill it in!", "Error");
		}
		else PopupWarning.PopupWarning("You have not entered a price. Please fill it in!", "Error");

		// TODO add your handling code here:
	}
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {   
		// TAKES THE USER INFO AND MAKES A REGISTRATION
		PrintWriter pw = null;
		boolean flag=true;
		String str1="";
		try {
			pw = new PrintWriter(sock.getOutputStream());
		} catch (IOException e4) {
			System.out.println("Error writing to server");;
		}
		try {
			in = new Scanner(sock.getInputStream());
		} catch (IOException e) {
			System.out.println("There was a problem in reading from the server");
		}
		
		
		String name=jTextField1.getText();
       String SecondName=jTextField2.getText();
       String FamilyName=jTextField3.getText();
       String phone=jTextField4.getText();
       String idRoom =jTextField6.getText(); 
       int phoneNum=0;
       if(!name.isEmpty()&&!SecondName.isEmpty()&&!FamilyName.isEmpty()&&!phone.isEmpty()&&!idRoom.isEmpty()){
	   
    	   try{
        	   phoneNum=Integer.parseInt(phone);
           }
           catch(NumberFormatException e){
        	   flag=false;
           }
             if(flag){
	   pw.println(4);
	   pw.flush();
       int n1 = in.nextInt();
       n1=n1+1;
                
       pw.println(name);
       pw.flush();
       pw.println(SecondName);
       pw.flush();
       pw.println(FamilyName);
       pw.flush();
       pw.println(n1);
       pw.flush();
       pw.println(Integer.parseInt(idRoom));
       pw.flush();
       pw.println(Integer.parseInt(jComboBox4.getSelectedItem().toString()));
       pw.flush();
       pw.println(Integer.parseInt(jComboBox5.getSelectedItem().toString()));
       pw.flush();
       pw.println(Integer.parseInt(jComboBox8.getSelectedItem().toString()));
       pw.flush();
       pw.println(Integer.parseInt(jComboBox6.getSelectedItem().toString()));
       pw.flush();
       pw.println(Integer.parseInt(jComboBox7.getSelectedItem().toString()));
       pw.flush();
       pw.println(Integer.parseInt(jComboBox8.getSelectedItem().toString()));
       pw.flush();
       pw.println(phoneNum);
       pw.flush();
       textField1.setText("������");	   
       }
         else{
        	 PopupWarning.PopupWarning("The phone is not a number. Please enter a valid phone number!", "Error");
         }
       }
       else PopupWarning.PopupWarning("There are blank fields in your discription.Please fill them in!", "Error");
      
    }

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JComboBox jComboBox5;
	private javax.swing.JComboBox jComboBox6;
	private javax.swing.JComboBox jComboBox7;
	private javax.swing.JComboBox jComboBox8;
	private javax.swing.JComboBox jComboBox9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private java.awt.TextArea textArea1;
	private java.awt.TextField textField1;
	// End of variables declaration
}
class PopupWarning
{

    public static void PopupWarning(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null,infoMessage, "InfoBox: ", JOptionPane.ERROR_MESSAGE);
    }
}
