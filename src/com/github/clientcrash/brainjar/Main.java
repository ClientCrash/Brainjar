package com.github.clientcrash.brainjar;

import java.util.Scanner;

public class Main {
	public static DataLine line = new DataLine(100);
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("code>>");
		SourceParser sp = new SourceParser(sc.nextLine());
		sp.run();
	}

}
