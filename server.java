package TCP;

import java.net.*;
import java.util.Scanner;
import java.io.*;

class server {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(1333);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		Scanner kb = new Scanner(System.in);
		String str = "", str2 = "";
		while (!str.equals("stop")) {
			str = din.readLine();
			System.out.println("client : " + str);
			str2 = kb.nextLine();
			dout.writeBytes(str2+"\n");
			dout.flush();
		}
		din.close();
		s.close();
		ss.close();
	}
}