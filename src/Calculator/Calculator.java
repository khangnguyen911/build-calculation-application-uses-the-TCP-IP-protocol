package Calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Calculator extends Thread{
	private Socket socket;
	private DataInputStream dis;
	String clientName;
		
	public Calculator(Socket socket) {
		this.socket = socket;
	}
		
	public void run() {
		DataOutputStream dos = null;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			String[] getDatas =  dis.readUTF().split("~~~");
			
			switch(getDatas.length) {
				case 2:
	//				String clientName = getDatas[0];
	//				double a = Double.parseDouble(getDatas[1]);
	//				String receive = getDatas[2];
					
					double numOf1TS = Double.parseDouble(getDatas[0]);
					String receive = getDatas[1];
					switch(receive) {
					case "chuViHinhVuong":
						dos.writeUTF("Canh cua hinh vuong ma ban nhap la: "+numOf1TS+
								"\nChu vi hinh vuong la: "+4*numOf1TS+".\n");
						break;
					case "chuViHinhThoi":
						dos.writeUTF("Canh cua hinh thoi ma ban nhap la: "+numOf1TS+
								"\nChu vi hinh thoi la: "+4*numOf1TS+".\n");
						break;
					case "chuViHinhTron":
						dos.writeUTF("Ban kinh cua hinh tron ma ban nhap la: "+numOf1TS+
								"\nChu vi hinh tron la: "+2*numOf1TS*Math.PI+".\n");
						break;
					case "dienTichHinhVuong":
						dos.writeUTF("Canh cua hinh vuong ma ban nhap la: "+numOf1TS+
								"\nDien tich hinh vuong la: "+Math.pow(numOf1TS, 2)+".\n");
						break;
					case "dienTichHinhTron":
						dos.writeUTF("Ban kinh cua hinh tron ma ban nhap la: "+numOf1TS+
								"\nDien tich hinh tron la: "+Math.PI*Math.pow(numOf1TS, 2)+".\n");
						break;
					default:
						dos.writeUTF("Vui long nhap mot so bat ky hoac chon mot phep tinh.\n");
						break;
					}
					break;
				case 3:
					double numOf2TS1 = Double.parseDouble(getDatas[0]);
					double numOf2TS2 = Double.parseDouble(getDatas[1]);
					String receive2TS = getDatas[2];
					switch(receive2TS) {
						case "tong2So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf2TS1+" va so thu hai: "+numOf2TS2+
									"\nTong cua hai so tren la: "+(numOf2TS1 + numOf2TS2)+".\n");
							break;
						case "hieu2So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf2TS1+" va so thu hai: "+numOf2TS2+
									"\nHieu cua hai so tren la: "+(numOf2TS1 - numOf2TS2)+".\n");
							break;
						case "tich2So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf2TS1+" va so thu hai: "+numOf2TS2+
									"\nTich cua hai so tren la: "+(numOf2TS1 * numOf2TS2)+".\n");
							break;
						case "thuong2So":
							if(numOf2TS2 != 0) {
								dos.writeUTF("\nBan nhap so thu nhat: "+numOf2TS1+" va so thu hai: "+numOf2TS2+
										"\nThuonng cua hai so tren la: "+(numOf2TS1 / numOf2TS2)+".\n");
							} else {
								dos.writeUTF("\nKhong the chia cho 0 !\n Vui long nhap lai so thu 2 !");
							}
							break;
						case "luyThua2So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf2TS1+" va so thu hai: "+numOf2TS2+
									"\nLuy thua cua hai so tren la: "+Math.pow(numOf2TS1, numOf2TS2)+".\n");
							break;
						case "chuViHinhChuNhat":
							dos.writeUTF("\nBan nhap chieu dai cua hinh chu nhat: "+numOf2TS1+" va chieu rong cua hinh chu nhat: "+numOf2TS2+
									"\nChu vi cua hinh chu nhat tren la: "+2*(numOf2TS1+numOf2TS2)+".\n");
							break;
						case "chuViHinhBinhHanh":
							dos.writeUTF("\nBan nhap chieu dai cua hinh binh hanh: "+numOf2TS1+" va chieu rong cua hinh binh hanh: "+numOf2TS2+
									"\nChu vi cua hinh chu nhat tren la: "+2*(numOf2TS1+numOf2TS2)+".\n");
							break;
						case "dienTichHinhChuNhat":
							dos.writeUTF("\nBan nhap chieu dai cua hinh chu nhat: "+numOf2TS1+" va chieu rong cua hinh chu nhat: "+numOf2TS2+
									"\nChu vi cua hinh chu nhat tren la: "+(numOf2TS1*numOf2TS2)+".\n");
							break;
						case "dienTichHinhBinhHanh":
							dos.writeUTF("\nBan nhap chieu cao cua hinh binh hanh: "+numOf2TS1+" va canh day cua hinh binh hanh: "+numOf2TS2+
									"\nDien tich cua hinh binh hanh tren la: "+(numOf2TS1*numOf2TS2)+".\n");
							break;
						case "dienTichHinhThoi":
							dos.writeUTF("\nBan nhap duong cheo thu nhat cua hinh thoi: "+numOf2TS1+" va duong cheo thu hai cua hinh thoi: "+numOf2TS2+
									"\nDien tich cua hinh thoi tren la: "+(numOf2TS1*numOf2TS2)/2+".\n");
							break;
						case "phuongTrinhBac1":
							if(numOf2TS1 == 0) {
								if(numOf2TS2 == 0) {
									dos.writeUTF("\nPhuong trinh bac 1 co dang ax + b = 0\n"
											+ "ban nhap a: "+numOf2TS1+" ban nhap b: "+numOf2TS2+
											"\nPhuong trinh ban nhap co vo so nghiem !\n");
								} else {
									dos.writeUTF("\nPhuong trinh bac 1 co dang ax + b = 0\n"
											+ "ban nhap a: "+numOf2TS1+" ban nhap b: "+numOf2TS2+
											"\nPhuong trinh ban nhap vo nghiem !\n");	
								}
							} else {
								double res = (double) -numOf2TS2/numOf2TS1;
								dos.writeUTF("\nPhuong trinh bac 1 co dang ax + b = 0\n"
										+ "ban nhap a: "+numOf2TS1+" ban nhap b: "+numOf2TS2+
										"\nPhuong trinh co nghiem la: "+res+".\n");
							}
							break;
						default:
							dos.writeUTF("\nVui long nhap mot so bat ky hoac chon mot phep tinh.\n");
							break;
					}
					break;
				case 4:
					double numOf3TS1 = Double.parseDouble(getDatas[0]);
					double numOf3TS2 = Double.parseDouble(getDatas[1]);
					double numOf3TS3 = Double.parseDouble(getDatas[2]);
					String receive3TS = getDatas[3];
					switch(receive3TS) {
						case "tong3So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf3TS1+", so thu hai: "+numOf3TS2+", so thu ba: "+numOf3TS3+
									"\nTong cua ba so tren la: "+(numOf3TS1 + numOf3TS2 + numOf3TS3)+".\n");
							break;
						case "hieu3So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf3TS1+", so thu hai: "+numOf3TS2+", so thu ba: "+numOf3TS3+
									"\nHieu cua ba so tren la: "+(numOf3TS1 - numOf3TS2 - numOf3TS3)+".\n");
							break;
						case "tich3So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf3TS1+", so thu hai: "+numOf3TS2+", so thu ba: "+numOf3TS3+
									"\nTich cua ba so tren la: "+(numOf3TS1 * numOf3TS2 * numOf3TS3)+".\n");
							break;
//						case "thuong3So":
//							dos.writeUTF("\nBan nhap so thu nhat: "+numOf3TS1+", so thu hai: "+numOf3TS2+", so thu ba: "+numOf3TS3+
//									"\nThuong cua ba so tren la: "+(numOf3TS1 * numOf3TS2 * numOf3TS3)+".\n");
//							break;
						case "chuViHinhTamGiac":
							dos.writeUTF("\nBan nhap canh thu nhat cua hinh tam giac: "+numOf3TS1+
									"\n canh thu hai cua hinh tam giac: "+numOf3TS2+
									"\n va canh thu ba cua hinh tam giac: "+numOf3TS3+
									"\nChu vi cua hinh tam giac tren la: "+(numOf3TS1 + numOf3TS2 + numOf3TS3)+".\n");
							break;
						case "dienTichHinhTamGiac":
								if((numOf3TS1 == numOf3TS2) && (numOf3TS2 == numOf3TS3) && (numOf3TS3 == numOf3TS1)) { // Tam giac deu
									dos.writeUTF("\nBan nhap canh thu nhat cua hinh tam giac: "+numOf3TS1+
											"\n canh thu hai cua hinh tam giac: "+numOf3TS2+
											"\n va canh thu ba cua hinh tam giac: "+numOf3TS3+
											"\n\tDay la tam giac deu"+
											"\nDien tich cua hinh tam giac deu nay la: "+(Math.sqrt(3)/4)*(Math.pow(numOf3TS1, 2))+".\n");
								} else if((Math.pow(numOf3TS1, numOf3TS2) == Math.pow(numOf3TS3, 2))) { // Tam giac vuong
									dos.writeUTF("\nBan nhap canh thu nhat cua hinh tam giac: "+numOf3TS1+
											"\n canh thu hai cua hinh tam giac: "+numOf3TS2+
											"\n va canh thu ba cua hinh tam giac: "+numOf3TS3+
											"\n\tDay la tam giac vuong"+
											"\nDien tich cua hinh tam giac vuong nay la: "+(numOf3TS1 * numOf3TS2)/2+".\n");
								} else if((Math.pow(numOf3TS1, numOf3TS2) == Math.pow(numOf3TS3, 2)) && (numOf3TS1 == numOf3TS2)) { // Tam giac vuong can
									dos.writeUTF("\nBan nhap canh thu nhat cua hinh tam giac: "+numOf3TS1+
											"\n canh thu hai cua hinh tam giac: "+numOf3TS2+
											"\n va canh thu ba cua hinh tam giac: "+numOf3TS3+
											"\n\tDay la tam giac vuong can"+
											"\nDien tich cua hinh tam giac vuong can nay la: "+".\n");
								
//								} else if((a == b) && (a != c) && (b != c)) { // Tam giac can
//									dos.writeUTF("Day la Tam giac can !\n"+
//											"Dien tich tam giac can nay la: "+(double) (1/2)*a*b);
								} else { // Tam giac thuong
									double p = (numOf3TS1+numOf3TS2+numOf3TS3)/2;
									dos.writeUTF("\nBan nhap canh thu nhat cua hinh tam giac: "+numOf3TS1+
											"\n canh thu hai cua hinh tam giac: "+numOf3TS2+
											"\n va canh thu ba cua hinh tam giac: "+numOf3TS3+
											"\n\tDay la tam giac thuong"+
											"\nDien tich cua hinh tam giac thuong nay la: "+Math.sqrt(p*(p-numOf3TS1)*(p-numOf3TS2)*(p-numOf3TS3))+".\n");
								}
							break;
						case "dienTichHinhThang":
							dos.writeUTF("\nBan nhap canh day thu nhat cua hinh thang: "+numOf3TS1+
									"\n canh day thu hai cua hinh thang: "+numOf3TS2+
									"\n va chieu cao cua hinh thang: "+numOf3TS3+
									"\nDien tich cua hinh thang tren la: "+((numOf3TS1 + numOf3TS2)*numOf3TS3)/2 +".\n");
							break;
						case "phuongTrinhBac2":
							if(numOf3TS1 == 0) {
								if(numOf3TS2 == 0) {
									dos.writeUTF("\nPhuong trinh bac 2 co dang ax^2 + bx + c = 0\n"
											+ "ban nhap a: "+numOf3TS1+", b: "+numOf3TS2+", c: "+numOf3TS3+
											"\nPhuong trinh ban nhap bi vo nghiem !\n");
								} else {
									dos.writeUTF("\nPhuong trinh bac 2 co dang ax^2 + bx + c = 0\n"
											+ "ban nhap a: "+numOf3TS1+", b: "+numOf3TS2+", c: "+numOf3TS3+
											"\nPhuong trinh ban nhap co mot nghiem: "+(-numOf3TS3/numOf3TS2)+".\n");	
								}
							} else {
								double delta = Math.pow(numOf3TS2, 2) - 4*numOf3TS1*numOf3TS3;
								if(delta > 0) {
									dos.writeUTF("\nPhuong trinh bac 2 co dang ax^2 + bx + c = 0\n"
											+ "ban nhap a: "+numOf3TS1+", b: "+numOf3TS2+", c: "+numOf3TS3+
											"\nPhuong trinh ban nhap co hai nghiem lan luot la: "
											+(-numOf3TS2+Math.sqrt(delta))/(2*numOf3TS1)+" va "+(-numOf3TS2-Math.sqrt(delta))/(2*numOf3TS1)+".\n");
								} else if(delta == 0) {
									dos.writeUTF("\nPhuong trinh bac 2 co dang ax^2 + bx + c = 0\n"
											+ "ban nhap a: "+numOf3TS1+", b: "+numOf3TS2+", c: "+numOf3TS3+
											"\nPhuong trinh ban nhap co mot nghiem la: "
											+(-numOf3TS2/(2*numOf3TS1))+".\n");
								} else {
									dos.writeUTF("\nPhuong trinh bac 2 co dang ax^2 + bx + c = 0\n"
											+ "ban nhap a: "+numOf3TS1+", b: "+numOf3TS2+", c: "+numOf3TS3+
											"\nPhuong trinh ban nhap bi vo nghiem !\n");
								}
							}
							break;
						default:
							dos.writeUTF("\nVui long nhap mot so bat ky hoac chon mot phep tinh.\n");
							break;
					}
					break;
				case 5:
					double numOf4TS1 = Double.parseDouble(getDatas[0]);
					double numOf4TS2 = Double.parseDouble(getDatas[1]);
					double numOf4TS3 = Double.parseDouble(getDatas[2]);
					double numOf4TS4 = Double.parseDouble(getDatas[3]);
					String receive4TS = getDatas[4];
					switch(receive4TS) {
						case "tong4So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf4TS1+", so thu hai: "+numOf4TS2+", so thu ba: "+numOf4TS3+", so thu tu: "+numOf4TS4+
									"\nTong cua ba so tren la: "+(numOf4TS1 + numOf4TS2 + numOf4TS3 + numOf4TS4)+".\n");
							break;
						case "hieu4So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf4TS1+", so thu hai: "+numOf4TS2+", so thu ba: "+numOf4TS3+", so thu tu: "+numOf4TS4+
									"\nHieu cua ba so tren la: "+(numOf4TS1 - numOf4TS2 - numOf4TS3 - numOf4TS4)+".\n");
							break;
						case "tich4So":
							dos.writeUTF("\nBan nhap so thu nhat: "+numOf4TS1+", so thu hai: "+numOf4TS2+", so thu ba: "+numOf4TS3+", so thu tu: "+numOf4TS4+
									"\nTich cua ba so tren la: "+(numOf4TS1 * numOf4TS2 * numOf4TS3 * numOf4TS4)+".\n");
							break;
						case "chuViHinhThang":
							dos.writeUTF("\nBan nhap canh thu nhat cua hinh thang: "+numOf4TS1+
									"\n va canh thu hai cua hinh thang: "+numOf4TS2+
									"\n va canh thu ba cua hinh thang: "+numOf4TS3+
									"\n va canh thu tu cua hinh thang: "+numOf4TS4+
									"\nChu vi cua hinh thang tren la: "+(numOf4TS1 + numOf4TS2 + numOf4TS3 + numOf4TS4)+".\n");
							break;
						case "phuongTrinhBac3":
							double a = numOf4TS1;
							double b = numOf4TS2;
							double c = numOf4TS3;
							double d = numOf4TS4;
							double nRoots, x1, x2, x3;
							
							// kiem tra he so
							if(a == 0) {
								dos.writeUTF("\nPhuong trinh bac 3 co dang ax^3 + bx^2 + cx + d = 0."
										+ "\nBan nhap a: "+numOf4TS1+
										"\n ,b: "+numOf4TS2+
										"\n ,c:"+numOf4TS3+
										"\n va d: "+numOf4TS4+
										"\nKhong the nhap a = 0 !\nVui long nhap lai a.\n");
							}
							
							// chuan hoa cac he so
							double denom = a;
							a = b/denom;
							b = c/denom;
							c = d/denom;
							
							//	bat dau tinh
							double a_chia_3 = a / 3.0;
							double Q = (3*b - a*a) / 9.0;
							double Q_mu_3 = Q*Q*Q;
							double R = (9*a*b - 27*c - 2*a*a*a) / 54.0;
							double R_mu_2 = R*R;
							double D = Q_mu_3 + R_mu_2;
							
							if(D < 0.0) {
								// 3 nghiem
								nRoots = 3;
								double theta = Math.acos (R / Math.sqrt (-Q_mu_3));
								double SQRT_Q = Math.sqrt (-Q);
								x1 = 2.0 * SQRT_Q * Math.cos (theta/3.0) - a_chia_3;
								x2 = 2.0 * SQRT_Q * Math.cos ((theta+Math.PI*2)/3.0) - a_chia_3;
								x3 = 2.0 * SQRT_Q * Math.cos ((theta+Math.PI*4)/3.0) - a_chia_3;
								if(x1 < x2) {
									double tmp = x1;
									x1 = x2;
									x2 = tmp;
								}
								if(x2 < x3) {
									double tmp = x2;
									x2 = x3;
									x3 = tmp;
								}
								if(x1 < x2) {
									double tmp = x1;
									x1 = x2;
									x2 = tmp;
								}
								dos.writeUTF("\nPhuong trinh bac 3 co dang ax^3 + bx^2 + cx + d = 0."
										+ "\nBan nhap a: "+numOf4TS1+
										"\n ,b: "+numOf4TS2+
										"\n ,c:"+numOf4TS3+
										"\n va d: "+numOf4TS4+
										"\nPhuong trinh ban nhap co 3 nghiem lan luot la: "+x1+", "+x2+" va "+x3+"\n");
							} else if(D > 0.0) {
								//	Co 1 nghiem
								nRoots = 1;
								double SQRT_D = Math.sqrt (D);
								double S = Math.cbrt (R + SQRT_D);
								double T = Math.cbrt (R - SQRT_D);
								x1 = (S + T) - a_chia_3;
								x2 = Double.NaN;
								x3 = Double.NaN;
								dos.writeUTF("\nPhuong trinh bac 3 co dang ax^3 + bx^2 + cx + d = 0."
										+ "\nBan nhap a: "+numOf4TS1+
										"\n ,b: "+numOf4TS2+
										"\n ,c:"+numOf4TS3+
										"\n va d: "+numOf4TS4+
										"\nPhuong trinh ban nhap co 1 nghiem la: "+x1+"\n");
							} else {
								nRoots = 3;
								double CBRT_R = Math.cbrt (R);
								x1 = 2*CBRT_R - a_chia_3;
								x2 = x3 = CBRT_R - a_chia_3;
								if(x1 < x2) {
									double tmp = x1;
									x1 = x2;
									x2 = tmp;
								}
								if(x2 < x3) {
									double tmp = x2;
									x2 = x3;
									x3 = tmp;
								}
								if(x1 < x2) {
									double tmp = x1;
									x1 = x2;
									x2 = tmp;
								}
								dos.writeUTF("\nPhuong trinh bac 3 co dang ax^3 + bx^2 + cx + d = 0."
										+ "\nBan nhap a: "+numOf4TS1+
										"\n ,b: "+numOf4TS2+
										"\n ,c:"+numOf4TS3+
										"\n va d: "+numOf4TS4+
										"\nPhuong trinh ban nhap co 3 nghiem trong do co hai nghiem bang nhau: "+x1+", "+x2+" va "+x3+"\n");
							}
							break;
						default:
							dos.writeUTF("\nVui long nhap mot so bat ky hoac chon mot phep tinh.\n");
							break;
					}
					break;
				default:
					break;
			}
			
			
			
			dis.close();
			dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	public String getClientName(Socket socket) {
		return clientName;
	}
}
