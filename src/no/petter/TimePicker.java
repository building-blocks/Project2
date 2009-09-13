package no.petter;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimePicker extends Activity {
		private TextView tv;
		private Button button;
		public final static int TIME_DIALOG = 735;
		
		private int hour;
		private int mminute;
		private boolean is24hour = false;
		private boolean isAm = true;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.time);
			
			tv = (TextView) findViewById(R.id.timeDisplay);
			button = (Button) findViewById(R.id.pickTime);
			button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					showDialog(TIME_DIALOG);
				}
			});
			
			
			final Calendar cal = Calendar.getInstance();
			if (is24hour) {
				hour = cal.get(Calendar.HOUR);
			} else {
				hour = cal.get(Calendar.HOUR_OF_DAY);
			}
			mminute = cal.get(Calendar.MINUTE);
			updateDisplay();
		}
		
		@Override
		protected Dialog onCreateDialog(int id) {
			if (id == TIME_DIALOG) {
				return new TimePickerDialog(this, superTimeString, hour, mminute, is24hour);
			}
			return null;
		}
		
		protected TimePickerDialog.OnTimeSetListener superTimeString = 
			new TimePickerDialog.OnTimeSetListener() {

				public void onTimeSet(android.widget.TimePicker view,
						int hourOfDay, int minute) {
					hour = hourOfDay;
					if (!is24hour) {
						if (hour > 12) {
							isAm = false;
							hour = hour - 12;
						}
					}							
					mminute = minute;
					updateDisplay();
				}
		};
		
		private void updateDisplay() {
			if (is24hour) {
				tv.setText(hour + ":" + mminute);
			} else if (isAm) {
				tv.setText(hour + ":" + mminute + " AM");
			} else {
				tv.setText(hour + ":" + mminute + " PM");
			}
		}
}
