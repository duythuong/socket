package TCP;

import java.net.*;
import java.util.Scanner;
import java.io.*;

class client {
	public static void main(String args[]) throws Exception {
		Socket s = new Socket("localhost", 1333);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		Scanner kb = new Scanner(System.in);

		String str = "", str2 = "";
		while (!str.equals("stop")) {
			str = kb.nextLine();
			dout.writeBytes(str+"\n");
			dout.flush();
			str2 = din.readLine();
			System.out.println("Server : " + str2);
		}

		dout.close();
		s.close();
	}
}