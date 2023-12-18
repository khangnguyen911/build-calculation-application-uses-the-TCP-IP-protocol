package Calculator_Server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Calculator.Calculator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;


public class ServerCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPort;
	private int portNo;
	
	public static final int NUMBER_OF_THREAD = 20;
	
	ServerSocket serverSocket;
	Socket socket;
	DataOutputStream dataOutputStream = null;
	DataInputStream dataInputStream = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerCalculator frame = new ServerCalculator();
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
	public ServerCalculator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ServerCalculator.class.getResource("/ImageAndLogo/T\u0110T_logo.png")));
		
		setTitle("Server Receive a Number from Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPort = new JLabel("PortNo:");
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPort.setBounds(223, 59, 60, 30);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPort.setText("1609");
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(283, 59, 100, 30);
		contentPane.add(textFieldPort);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(40, 150, 500, 180);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(40, 150, 500, 180);
		contentPane.add(scrollPane);
		
		JButton btnClickMe = new JButton("Click Here to Start Server");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int portNo = Integer.parseInt(textFieldPort.getText().trim());
				ExecutorService exe = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
				try {
					
					serverSocket = new ServerSocket(portNo);
					JOptionPane.showMessageDialog(null, "The Server is waiting for client!", "Inform from Server", JOptionPane.INFORMATION_MESSAGE);
					
					while(true) {
						socket = serverSocket.accept();
//						JOptionPane.showMessageDialog(null, "A new client is connected!", "Inform from Server", JOptionPane.INFORMATION_MESSAGE);
						Calculator calc = new Calculator(socket);
						exe.execute(calc);
					}
					
				} catch(IOException ioe) {
					
				}  finally {
					closeSocket(socket);
					closeDataInputStream(dataInputStream);
					closeDataOutputStream(dataOutputStream);
					
				}
			}
			
			public void closeSocket(Socket socket) {
				try {
					if(socket != null) {
						socket.close();	
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public void closeDataInputStream(DataInputStream dis) {
				try {
					if(dis != null) {
						dis.close();	
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public void closeDataOutputStream(DataOutputStream dos) {
				try {
					if(dos != null) {
						dos.close();	
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnClickMe.setBackground(UIManager.getColor("Button.shadow"));
		btnClickMe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClickMe.setBounds(150, 100, 300, 30);
		contentPane.add(btnClickMe);
		
		JLabel lblNewLabel = new JLabel("Server receive number from client and send result to client");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(42, 20, 498, 40);
		contentPane.add(lblNewLabel);
	}
}
