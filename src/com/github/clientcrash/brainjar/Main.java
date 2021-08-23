package com.github.clientcrash.brainjar;
import java.util.Scanner;
public class Main {
	public static DataLine line;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("code>>");
		String source = sc.nextLine();
		System.out.println("How much memory fields are required?");
		int count = sc.nextInt();
		line = new DataLine(count);
		SourceParser sp = new SourceParser(source);
		sp.run();
		sc.close();
	}
}