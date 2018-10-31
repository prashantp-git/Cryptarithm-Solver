package com.example.cryptarithmetic;

public class CharObject {
	private int numAssn;
	private char letter;

	public CharObject(char lett, int num) {
		letter = lett;
		numAssn = num;
		}

	public int getNumAssn() {
		return numAssn;
	}

	public void setNumAssn(int numAssn) {
		this.numAssn = numAssn;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	
}
