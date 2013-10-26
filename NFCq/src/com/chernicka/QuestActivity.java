package com.chernicka;

import org.json.JSONObject;

import com.chernicka.volley.VolleyRequest;
import com.chernicka.volley.VolleyResponse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuestActivity extends Activity implements OnClickListener {

	private Button btnSend;
	private EditText edtAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activty_quest);
		edtAnswer = (EditText) findViewById(R.id.edt_answer);
		btnSend = (Button) findViewById(R.id.btn_send);
		btnSend.setOnClickListener(this);
		((TextView)findViewById(R.id.txt_question)).setText(NfcQAplication.getCurrentTask().getTaskText());
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

	private void sendAnswer() {
		if (edtAnswer.getText().toString()
				.equals(NfcQAplication.getCurrentTask().getResponse())) {
			VolleyRequest.questComplited(NfcQAplication.getUser(),
					new VolleyResponse() {

						@Override
						public void onResponse(JSONObject response) {

						}

						@Override
						public void onError(Exception error) {

						}
					});
			Toast.makeText(getApplicationContext(), "You won 20 points",
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), "Wrong answer",
					Toast.LENGTH_LONG).show();
		}
		// edtAnswer.getText().toString()
		// TODO send answer to server
	}

}
