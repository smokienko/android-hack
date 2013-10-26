package com.chernicka;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class QuestActivity extends Activity implements OnClickListener {

	private Button btnSend;
	private EditText edtAnswer;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activty_quest);
		edtAnswer = (EditText)findViewById(R.id.edt_answer);
		btnSend = (Button)findViewById(R.id.btn_send);
		btnSend.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_send:
			sendAnswer();
			break;
		default:
			break;
		}
	}
	
	private void sendAnswer(){
		//edtAnswer.getText().toString()
		//TODO send answer to server
	}	
	
}
