package Calculator_Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Calculator_ChuVi.*;
import Calculator_DienTich.*;
import Calculator_PhepTinhCoBan.*;
import Calculator_GiaiPhuongTrinh.*;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class MenuClient extends JFrame {

	private JPanel contentPane;
	private ButtonGroup jbg = new ButtonGroup();
	private String soLuong = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuClient frame = new MenuClient();
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
	public MenuClient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuClient.class.getResource("/ImageAndLogo/T\u0110T_logo.png")));
		setTitle("Menu Chon Phep tinh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseNum = new JLabel("Menu Chon Phep tinh");
		lblChooseNum.setForeground(Color.CYAN);
		lblChooseNum.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChooseNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseNum.setBounds(103, 51, 400, 52);
		contentPane.add(lblChooseNum);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 40);
		contentPane.add(menuBar);
		
		JMenu mnPTCB = new JMenu("Phep Toan Co Ban");
		mnPTCB.setForeground(new Color(34, 139, 34));
		mnPTCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPTCB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(mnPTCB);
		
		JMenuItem mntm2so = new JMenuItem("Cong, tru, nhan, chia, luy thua voi 2 so");
		mntm2so.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhepTinh2So pt2s = new PhepTinh2So();
				pt2s.setVisible(true);
			}
		});
		mntm2so.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnPTCB.add(mntm2so);
		
		JMenuItem mntm3so = new JMenuItem("Cong, tru, nhan voi 3 so");
		mntm3so.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhepTinh3So pt3s = new PhepTinh3So();
				pt3s.setVisible(true);
			}
		});
		mntm3so.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnPTCB.add(mntm3so);
		
		JMenuItem mntm4so = new JMenuItem("Cong, tru, nhan voi 4 so");
		mntm4so.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhepTinh4So pt4s = new PhepTinh4So();
				pt4s.setVisible(true);
			}
		});
		mntm4so.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnPTCB.add(mntm4so);
		
		JMenu mnCV = new JMenu("Tinh Chu vi");
		mnCV.setForeground(new Color(160, 82, 45));
		mnCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(mnCV);
		
		JMenuItem mntmCVT = new JMenuItem("Hinh Tron");
		mntmCVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhTron cVT = new ChuViHinhTron();
				cVT.setVisible(true);
			}
		});
		mntmCVT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVT);
		
		JMenuItem mntmCVTG = new JMenuItem("Hinh Tam giac");
		mntmCVTG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhTamGiac cVTG = new ChuViHinhTamGiac();
				cVTG.setVisible(true);
			}
		});
		mntmCVTG.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVTG);
		
		JMenuItem mntmCVV = new JMenuItem("Hinh Vuong");
		mntmCVV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhVuong cVV = new ChuViHinhVuong();
				cVV.setVisible(true);
			}
		});
		mntmCVV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVV);
		
		JMenuItem mntmCVCN = new JMenuItem("Hinh Chu nhat");
		mntmCVCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhChuNhat cVCN = new ChuViHinhChuNhat();
				cVCN.setVisible(true);
			}
		});
		mntmCVCN.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVCN);
		
		JMenuItem mntmCVBH = new JMenuItem("Hinh Binh hanh");
		mntmCVBH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhBinhHanh cVBH = new ChuViHinhBinhHanh();
				cVBH.setVisible(true);
			}
		});
		mntmCVBH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVBH);
		
		JMenuItem mntmCVThoi = new JMenuItem("Hinh Thoi");
		mntmCVThoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhThoi cVThoi = new ChuViHinhThoi();
				cVThoi.setVisible(true);
			}
		});
		mntmCVThoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVThoi);
		
		JMenuItem mntmCVThang = new JMenuItem("Hinh Thang");
		mntmCVThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuViHinhThang cVThang = new ChuViHinhThang();
				cVThang.setVisible(true);
			}
		});
		mntmCVThang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnCV.add(mntmCVThang);
		
		JMenu mnDT = new JMenu("Tinh Dien tich");
		mnDT.setForeground(new Color(105, 105, 105));
		mnDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(mnDT);
		
		JMenuItem mntmDTT = new JMenuItem("Hinh Tron");
		mntmDTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhTron dTT = new DienTichHinhTron();
				dTT.setVisible(true);
			}
		});
		mntmDTT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTT);
		
		JMenuItem mntmDTTG = new JMenuItem("Hinh Tam giac");
		mntmDTTG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhTamGiac dTTG = new DienTichHinhTamGiac();
				dTTG.setVisible(true);
			}
		});
		mntmDTTG.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTTG);
		
		JMenuItem mntmDTV = new JMenuItem("Hinh Vuong");
		mntmDTV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhVuong dTV = new DienTichHinhVuong();
				dTV.setVisible(true);
			}
		});
		mntmDTV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTV);
		
		JMenuItem mntmDTCN = new JMenuItem("Hinh Chu nhat");
		mntmDTCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhChuNhat dTCN = new DienTichHinhChuNhat();
				dTCN.setVisible(true);
			}
		});
		mntmDTCN.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTCN);
		
		JMenuItem mntmDTBH = new JMenuItem("Hinh Binh hanh");
		mntmDTBH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhBinhHanh dTBH = new DienTichHinhBinhHanh();
				dTBH.setVisible(true);
			}
		});
		mntmDTBH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTBH);
		
		JMenuItem mntmDTThoi = new JMenuItem("Hinh Thoi");
		mntmDTThoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhThoi dTThoi= new DienTichHinhThoi();
				dTThoi.setVisible(true);
			}
		});
		mntmDTThoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTThoi);
		
		JMenuItem mntmDTThang = new JMenuItem("Hinh Thang");
		mntmDTThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTichHinhThang dTThang = new DienTichHinhThang();
				dTThang.setVisible(true);
			}
		});
		mntmDTThang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnDT.add(mntmDTThang);
		
		JMenu mnGPT = new JMenu("Giai phuong trinh");
		mnGPT.setForeground(new Color(255, 0, 0));
		mnGPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnGPT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(mnGPT);
		
		JMenuItem mntmBac = new JMenuItem("Bac 1");
		mntmBac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaiPhuongTrinhBac1 ptb1 = new GiaiPhuongTrinhBac1();
				ptb1.setVisible(true);
			}
		});
		mntmBac.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnGPT.add(mntmBac);
		
		JMenuItem mntmBac_1 = new JMenuItem("Bac 2");
		mntmBac_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaiPhuongTrinhBac2 ptb2 = new GiaiPhuongTrinhBac2();
				ptb2.setVisible(true);
			}
		});
		mntmBac_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnGPT.add(mntmBac_1);
		
		JMenuItem mntmBac_1_1 = new JMenuItem("Bac 3");
		mntmBac_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GiaiPhuongTrinhBac3 ptb3 = new GiaiPhuongTrinhBac3();
				ptb3.setVisible(true);
			}
		});
		mntmBac_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mnGPT.add(mntmBac_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuClient.class.getResource("/ImageAndLogo/Click image for full version Click image for full version Click image.jpg")));
		lblNewLabel.setBounds(0, 36, 584, 325);
		contentPane.add(lblNewLabel);
	}
}
