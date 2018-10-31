package com.example.cryptarithmetic;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,editTextResultInterface {
	private EditText mEditText1;
	private EditText mEditText2;
	private EditText mEditText3;
	private TextView mTextViewResult;
	private Button mButtonPlus;
	private Button mButtonMinus;
	private Button mButtonMultiplication;
	private Button mButtonDivision;
	private String mString1;
	private String mString2;
	private String mString3;
	private boolean mStringValid;
	private Solutions mSolutions;

	private static final int PLUS = 1;
	private static final int MINUS = 2;
	private static final int  MULTIPLICATION= 3;
	private static final int DIVISION = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEditText1 = (EditText) findViewById(R.id.editText1);
		mEditText2 = (EditText) findViewById(R.id.editText2);
		mEditText3 = (EditText) findViewById(R.id.editText3);
		mTextViewResult=(TextView) findViewById(R.id.textView4);
		mButtonPlus = (Button) findViewById(R.id.button1);
		mButtonMinus = (Button) findViewById(R.id.button2);
		mButtonMultiplication = (Button) findViewById(R.id.button3);
		mButtonDivision = (Button) findViewById(R.id.button4);
		mButtonPlus.setOnClickListener(this);
		mButtonMinus.setOnClickListener(this);
		mButtonMultiplication.setOnClickListener(this);
		mButtonDivision.setOnClickListener(this);
		mTextViewResult.setMovementMethod(new ScrollingMovementMethod());
		mTextViewResult.setText("Result : \n");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			strValidate();
			if(mStringValid) 
				mSolutions.getResults(PLUS);
			break;
		case R.id.button2:
			strValidate();
			if(mStringValid)
				mSolutions.getResults(MINUS);
			break;
		case R.id.button3:
			strValidate();
			if(mStringValid)
				mSolutions.getResults(MULTIPLICATION);
			break;
		case R.id.button4:
			strValidate();
			if(mStringValid)
				mSolutions.getResults(DIVISION);
			break;
		}

	}

	public void strValidate() {
		mString1 = mEditText1.getText().toString();
		mString2 = mEditText2.getText().toString();
		mString3 = mEditText3.getText().toString();
		mStringValid = true;
		if (mString1.matches(".*\\d.*") || mString1.equals("")) {
			Toast.makeText(this, "String 1 invalid", Toast.LENGTH_SHORT).show();
			mEditText1.setText("");
			mStringValid = false;
		}
		if (mString2.matches(".*\\d.*") || mString2.equals("")) {
			Toast.makeText(this, "String 2 invalid", Toast.LENGTH_SHORT).show();
			mEditText2.setText("");
			mStringValid = false;
		}
		if (mString3.matches(".*\\d.*") || mString3.equals("")) {
			Toast.makeText(this, "String 3 invalid", Toast.LENGTH_SHORT).show();
			mEditText3.setText("");
			mStringValid = false;
		}
		if (mStringValid) {
			mSolutions=new Solutions(mString1, mString2, mString3,this);
		
		}
	}
	
	public void editTextResult(String result)
	{
		mTextViewResult.append(result+"\n");
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		System.exit(0);
	}

}
