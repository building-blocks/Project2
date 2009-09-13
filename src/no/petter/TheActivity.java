package no.petter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TheActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageButton iButton = (ImageButton) findViewById(R.id.android_button);
        iButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i("tag", "button pushed");
				// Perform action on clicks
		        Toast.makeText(TheActivity.this, "Beep Bop", Toast.LENGTH_LONG).show();
			}
		});
        
        final EditText edittext = (EditText) findViewById(R.id.edittext);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                  // Perform action on key press
                  Toast.makeText(TheActivity.this, edittext.getText(), Toast.LENGTH_SHORT).show();
                  return true;
                }
                return false;
            }
        });
        
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
                if (checkbox.isChecked()) {
                    Toast.makeText(TheActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TheActivity.this, "Not selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        final RadioButton radio_red = (RadioButton) findViewById(R.id.radio_red);
        final RadioButton radio_blue = (RadioButton) findViewById(R.id.radio_blue);
        radio_red.setOnClickListener(radio_listener);
        radio_blue.setOnClickListener(radio_listener);
        
        final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.togglebutton);
        togglebutton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
                if (togglebutton.isChecked()) {
                    Toast.makeText(TheActivity.this, "ONNN", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TheActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    
    OnClickListener radio_listener = new OnClickListener() {
    	public void onClick(View v) {
    		// Perform action on clicks
    		RadioButton rb = (RadioButton) v;
    		Toast.makeText(TheActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
    	}
    };
}