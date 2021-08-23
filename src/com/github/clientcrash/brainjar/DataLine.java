package com.github.clientcrash.brainjar;
public class DataLine {
public int[] line;
public int point;
public DataLine(int length) {
	this.line=new int[length];
	this.point = 0;
}
public char getCurrentPointAsChar() {
	return (char)this.line[this.point];
}
public int getCurrentPoint() {
	return this.line[this.point];
}
public String getAsString() {
	String s = "";
	for(int i:line) {
		s+=String.valueOf(i) + "|";
	}
	return s;
}
}