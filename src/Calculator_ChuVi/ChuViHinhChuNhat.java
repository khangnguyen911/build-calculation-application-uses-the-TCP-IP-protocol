package Calculator_ChuVi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Calculator_Client.MenuClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;

import java.net.*;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Checkbox;


public class ChuViHinhChuNhat extends JFrame {

	private JPanel contentPane;
//	private static JTextField textFieldHostName;
//	private static JTextField textFieldPort;
//	static Socket socket;
	private String hostName;
	private int portNo;
	private JTextField txt1st;
	private String str = "";
	private ButtonGroup jbg = new ButtonGroup();
	private String operator = "chuViHinhChuNhat";
	private JTextField textFieldHostName;
	private JTextField textFieldPort;
	Socket socket;
	DataOutputStream dataOutputStream;
	DataInputStream dataInputStream;
	private JTextField txt2nd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuViHinhChuNhat frame = new ChuViHinhChuNhat();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChuViHinhChuNhat() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChuViHinhChuNhat.class.getResource("/ImageAndLogo/T\u0110T_logo.png")));
		setTitle("Chu vi hinh Chu nhat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 555);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblHostname = new JLabel("HostName:");
		lblHostname.setForeground(Color.BLACK);
		lblHostname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblHostname.setBounds(49, 74, 80, 30);
		contentPane.add(lblHostname);
		
		textFieldHostName = new JTextField();
		textFieldHostName.setText("localhost");
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setBounds(150, 74, 150, 30);
		contentPane.add(textFieldHostName);
		textFieldHostName.setColumns(10);
		
		JLabel lblPort = new JLabel("Cong:");
		lblPort.setForeground(Color.BLACK);
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPort.setBounds(472, 74, 60, 30);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setText("1609");
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(542, 74, 81, 30);
		contentPane.add(textFieldPort);

		JLabel lblEnt1 = new JLabel("Nhap chieu dai cua hinh chu nhat:");
		lblEnt1.setForeground(Color.BLACK);
		lblEnt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnt1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnt1.setBounds(49, 189, 276, 30);
		contentPane.add(lblEnt1);
		
		JTextArea textAreaInputData = new JTextArea();
		textAreaInputData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textAreaInputData.setBounds(175, 400, 450, 100);
		contentPane.add(textAreaInputData);
		
		JScrollPane scrollPane = new JScrollPane(textAreaInputData);
		scrollPane.setBounds(175, 400, 450, 100);
		contentPane.add(scrollPane);
		
		txt1st = new JTextField();
		txt1st.setHorizontalAlignment(SwingConstants.CENTER);
		txt1st.setText("9");
		txt1st.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txt1st.setColumns(10);
		txt1st.setBounds(342, 189, 190, 30);
		contentPane.add(txt1st);
		
		JButton btnReturnToMenu = new JButton("Quay ve menu chon");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuClient mc = new MenuClient();
				mc.setVisible(true);
			}
		});
		btnReturnToMenu.setBackground(UIManager.getColor("Button.darkShadow"));
		btnReturnToMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReturnToMenu.setBounds(443, 340, 182, 30);
		contentPane.add(btnReturnToMenu);
		
		JLabel lblResultFromServer = new JLabel("Ket qua tu May chu:");
		lblResultFromServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultFromServer.setForeground(Color.BLACK);
		lblResultFromServer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblResultFromServer.setBounds(10, 424, 155, 30);
		contentPane.add(lblResultFromServer);
		
		JButton btnSend = new JButton("Gui toi May chu");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(txt1st.getText());
				double num2 = Double.parseDouble(txt2nd.getText());
				
				String hostName = textFieldHostName.getText();
				int port = Integer.parseInt(textFieldPort.getText());
				
				try {
					socket = new Socket(hostName, port);
					dataInputStream = new DataInputStream(socket.getInputStream());
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					
					String sendStr = num1+"~~~"+num2+"~~~"+operator;
					dataOutputStream.writeUTF(sendStr);
					
					switch(operator) {
						case "chuViHinhChuNhat":
							str += dataInputStream.readUTF();
							break;
						default:
							str += "Vui long nhap so hoac chon mot trong cac phep tinh ben tren !\n";
							break;
					}
					
					txt1st.setText("");
					txt2nd.setText("");
					textAreaInputData.setText("\n"+str);
					
					dataInputStream.close();
					dataOutputStream.close();
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBackground(UIManager.getColor("Button.shadow"));
		btnSend.setBounds(175, 340, 173, 30);
		contentPane.add(btnSend);
		
		JButton btnClickHereTo = new JButton("Nhan vao Day de Bat Dau");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket(textFieldHostName.getText(), Integer.parseInt(textFieldPort.getText()));
					JOptionPane.showMessageDialog(null, "Client connect success to server !", "Note from client", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClickHereTo.setBackground(UIManager.getColor("Button.shadow"));
		btnClickHereTo.setBounds(259, 115, 215, 50);
		contentPane.add(btnClickHereTo);
		
		JLabel lblInf = new JLabel("Chu vi hinh Chu nhat");
		lblInf.setHorizontalAlignment(SwingConstants.CENTER);
		lblInf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblInf.setBounds(119, 11, 465, 30);
		contentPane.add(lblInf);
		
		JLabel lblEnt2 = new JLabel("Nhap chieu rong cua hinh chu nhat:");
		lblEnt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnt2.setForeground(Color.BLACK);
		lblEnt2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnt2.setBounds(49, 242, 276, 30);
		contentPane.add(lblEnt2);
		
		txt2nd = new JTextField();
		txt2nd.setText("12");
		txt2nd.setHorizontalAlignment(SwingConstants.CENTER);
		txt2nd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txt2nd.setColumns(10);
		txt2nd.setBounds(342, 242, 190, 30);
		contentPane.add(txt2nd);
		
		
		
		
	}
}
