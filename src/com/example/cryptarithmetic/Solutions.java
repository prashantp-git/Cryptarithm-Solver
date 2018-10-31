package com.example.cryptarithmetic;

import android.util.Log;

public class Solutions {
	private CharObject[] mCharArr;
	private int[] mNumArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	private boolean mNoPermutations=false;
	private String mOrigString1;
	private String mOrigString2;
	private String mOrigString3;
	private String mNewResult;
	private String mOldResult;
	private String mResult="";
	private editTextResultInterface mEditTextResult;
	
	public Solutions(String str1, String str2, String str3,editTextResultInterface context) {
		mOrigString1=str1;
		mOrigString2=str2;
		mOrigString3=str3;
		mEditTextResult=context;
		String redString = new String("");
		String str = str1 + str2 + str3;
		for (int i = 0; i < str.length(); i++) {
			if (!redString.contains("" + str.charAt(i))) {
				redString += "" + str.charAt(i);
			}
		}
		Log.e("Solutions",redString );
		mCharArr=new CharObject[redString.length()];
		mNewResult="0";
		mOldResult="9";
		for (int i = 0; i < redString.length(); ++i) {
			mCharArr[i] = new CharObject(redString.charAt(i), mNumArr[i]);
		}
	}
	
	public void getResults(int opr)
	{
		while(!mNoPermutations)
		{
			String string1=mOrigString1;
			String string2=mOrigString2;
			String string3=mOrigString3;
			for(int i=0;i<mCharArr.length;i++)
			{
				mCharArr[i].setNumAssn(mNumArr[i]);
				char s=mCharArr[i].getLetter();
				char n=(char) ('0' + mCharArr[i].getNumAssn());				
				string1=string1.replace(s, n);
				string2=string2.replace(s, n);
				string3=string3.replace(s, n);
			}
			switch(opr)
			{
			case 1:
				if(Integer.parseInt(string3)==Integer.parseInt(string1)+Integer.parseInt(string2))
				{
					addResult(string1, string2, string3, "+");			
				}
				break;
			case 2:
				if(Integer.parseInt(string3)==Integer.parseInt(string1)-Integer.parseInt(string2))
				{
					addResult(string1, string2, string3, "-");			
				}
				break;
			case 3:
				if(Integer.parseInt(string3)==Integer.parseInt(string1)*Integer.parseInt(string2))
				{
					addResult(string1, string2, string3, "*");
				}
				break;
			case 4:
				if(Integer.parseInt(string3)==Integer.parseInt(string1)/Integer.parseInt(string2))
				{
					addResult(string1, string2, string3, "/");			
				}
				break;
			}
			if(!mResult.equals(""))
			{
				break;
			}
			next_permutation(mNumArr);
		}
		//!mNoPermutations
		if(mResult.equals(""))mResult = "No solution found.";
		mEditTextResult.editTextResult(mResult);
	}

	public void addResult(String string1, String string2, String string3, String opr){
		mOldResult=mNewResult;
		mNewResult=string1+" "+opr+" "+string2+" = "+string3+"\n";
		if(!mNewResult.equals(mOldResult))
		{
			mResult+=mNewResult;
		}	
	}
	
	
	public  void next_permutation(int[] array) {
		int i, j;
		for (i = array.length - 2; i >= 0; i--) {
			if (array[i] < array[i + 1])
				break;
		}
		if (i < 0) {
			System.out.println("End");
			mNoPermutations = true;
			return;
		}

		for (j = array.length - 1; j > i; j--) {
			if (array[j] > array[i])
				break;
		}

		swap(array, i++, j);

		for (j = array.length - 1; j > i; i++, j--) {
			swap(array, i, j);
		}
	}

	public  void swap(int[] array, int x, int y) {
		array[x] ^= array[y];
		array[y] ^= array[x];
		array[x] ^= array[y];
	}
}
