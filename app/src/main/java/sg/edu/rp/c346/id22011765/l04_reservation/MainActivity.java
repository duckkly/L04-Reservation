package sg.edu.rp.c346.id22011765.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name;
EditText mobilenumber;
EditText pax;
TextView date;
DatePicker datepick;
TextView time;
TimePicker timepick;
CheckBox smoking;
Button reset;
Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etname);
        mobilenumber = findViewById(R.id.etnumber);
        pax = findViewById(R.id.etpax);
        date = findViewById(R.id.tvdate);
        datepick = findViewById(R.id.datePicker);
        time = findViewById(R.id.tvtime);
        timepick = findViewById(R.id.timePicker);
        smoking = findViewById(R.id.smoking);
        reset = findViewById(R.id.btnreset);
        submit = findViewById(R.id.btnsubmit);
        timepick.setCurrentHour(19);
        timepick.setCurrentMinute(30);
        datepick.updateDate(2020, 5, 1);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                mobilenumber.setText("");
                pax.setText("");
                timepick.setCurrentHour(19);
                timepick.setCurrentMinute(30);
                datepick.updateDate(2020, 5, 1);
                smoking.setSelected(false);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobilenumber.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0 && name.getText().toString().trim().length()!=0) {
                    CharSequence displayname = "Name: " + name.getText().toString();
                    CharSequence displaynumber = "Mobile Number: " + mobilenumber.getText().toString();
                    CharSequence displaypax = "Pax: " + pax.getText().toString();
                    CharSequence displaydate = "Date: " + datepick.getDayOfMonth() + "/" + (datepick.getMonth()+1) + "/" + datepick.getYear();
                    CharSequence displaytime = "Time: " + timepick.getCurrentHour() + ":" + timepick.getCurrentMinute();
                    if (smoking.isChecked()){
                        CharSequence displaysmoking = "Smoking Area: Yes";
                        Toast.makeText(getApplicationContext(),displayname + "\n" + displaynumber + "\n" + displaypax + "\n" + displaydate + "\n" + displaytime + "\n" + displaysmoking,Toast.LENGTH_SHORT).show();
                    }
                    else{
                        CharSequence displaysmoking ="Smoking Area: No";
                        Toast.makeText(getApplicationContext(),displayname + "\n" + displaynumber + "\n" + displaypax + "\n" + displaydate + "\n" + displaytime + "\n" + displaysmoking,Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please fill in the required domains",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}