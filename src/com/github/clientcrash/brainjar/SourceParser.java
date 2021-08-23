package com.github.clientcrash.brainjar;

import java.util.ArrayList;
import java.util.Scanner;

public class SourceParser {
	String source;
	String[] sourcesplit;
	ArrayList<LoopPoint> loops;
	Scanner sc;
	public SourceParser(String sourcestring) {
		this.source = sourcestring;
		this.sourcesplit = source.split("");
		this.sc = new Scanner(System.in);
		this.loops = new ArrayList<LoopPoint>();
	}
	public int run() {
		int n = 0;
		int currentSourceIndex;
		for (int sIndex = 0;sIndex <sourcesplit.length;sIndex++) {
			n+=1;
			String s=sourcesplit[sIndex];
			//System.out.println(sIndex+">"+s+ " - " + Main.line.getAsString());
			currentSourceIndex=sIndex;
			switch(s) {
			case("<"):
				Main.line.point-=1;
				break;
			case(">"):

				Main.line.point+=1;
				break;
			case("+"):
				//System.out.println("increasing current value");
				Main.line.line[Main.line.point]+=1;
				break;
			case("-"):

				//System.out.println("decreasing current value");
				Main.line.line[Main.line.point]-=1;
				break;
			case("."):
				System.out.print(Main.line.getCurrentPointAsChar());
				break;
			case(","):
				Main.line.line[Main.line.point] = sc.nextInt();
				break;
			case("["):
				this.loops.add(new LoopPoint(currentSourceIndex, 
						findLoopEnd(currentSourceIndex)
						));
				break;
			case("]"):
				if(Main.line.line[Main.line.point] != 0) {sIndex = findLoopStart(sIndex);}
				break;
			case(" "):
				break;
			
			
			
			}
		}
		return 1;
	}
	private int findLoopStart(int point) {
		for(LoopPoint l : loops) {
			if(l.end==point) {
				//System.out.println("returning a starting point of " + l.start);
				return l.start;
			}
		}
		return 0;
	}
	private int findLoopEnd(int point) {
		//System.out.println("SEARCHING FOR LOOP STARTING AT " + point);
		for(int i = point;i < sourcesplit.length;i++) {
			String o = sourcesplit[i];
			if(o.contains("]")) {

				//System.out.println("returning a ending point of " + i);
				return i;
			}
		}
		System.out.println("NO LOOP END FOUND");
		return 0;
	}
}
