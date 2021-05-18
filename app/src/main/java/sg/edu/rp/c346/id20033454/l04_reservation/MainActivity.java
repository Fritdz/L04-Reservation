package sg.edu.rp.c346.id20033454.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText pax;
    ToggleButton smoke;
    TimePicker time;
    DatePicker date;
    Button submit;
    Button reset;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        phone = findViewById(R.id.editPhone);
        pax = findViewById(R.id.editPax);
        smoke = findViewById(R.id.smoke);
        time = findViewById(R.id.timePicker);
        date = findViewById(R.id.datePicker);
        submit = findViewById(R.id.Submit);
        reset = findViewById(R.id.Reset);
        details = findViewById(R.id.details);

        time.setCurrentHour(19);
        time.setCurrentMinute(30);
        date.updateDate(2020,5,1);
        name.setText("");
        phone.setText("");
        pax.setText("");
        details.setText("");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xname = name.getText().toString();
                String xphone = phone.getText().toString();
                String xpax = pax.getText().toString();

                if((xname.isEmpty())||(xphone.isEmpty())||(xpax.isEmpty())){
                    Toast.makeText(MainActivity.this, "Please fill in empty fields", Toast.LENGTH_SHORT).show();
                }
                else if ((Integer.parseInt(xphone)<=0)||(Integer.parseInt(xpax)<=0)){
                    Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();

                }else{

                    String day = "";
                    if (date.getDayOfMonth() <10){
                        day = "0" + date.getDayOfMonth();
                    } else {
                        day += date.getDayOfMonth();
                    }
                    int monthtest = date.getMonth()+1;
                    String month = "";
                    if (monthtest <10){
                        month = "0" + monthtest;
                    } else {
                        month += monthtest;
                    }
                    int year = date.getYear();

                    String xdate = String.format("%s/%s/%d", day, month, year);

                    String hour = "";
                    if (time.getCurrentHour() <10){
                        hour = "0" + time.getCurrentHour();
                    } else {
                        hour += time.getCurrentHour();
                    }
                    String minute = "";
                    if (time.getCurrentMinute() <10){
                        minute = "0" + time.getCurrentMinute();
                    } else {
                        minute += time.getCurrentMinute();
                    }
                    String xtime= hour + ":" + minute;

                    String xsmoke="";
                    if(smoke.isChecked()){
                        xsmoke= "Smoking area";
                    }else{
                        xsmoke="Non-smoking area";
                    }

                    String output=String.format("Registration made for %s pax on %s at %s by %s for %s", xpax, xdate, xtime, xname, xsmoke);
                    details.setText(output);
                    Toast.makeText(MainActivity.this, "Reservation made!", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,5,1);
                name.setText("");
                phone.setText("");
                pax.setText("");
                details.setText("");

            }
        });


    }

}