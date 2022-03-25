package com.example.droidcafe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// we can create new listener for handle OnItemSlected
public class OrderActivity extends AppCompatActivity {

    TextView tvCake;
    RadioButton nextDayRadioButton;
    Spinner lablelSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvCake = findViewById(R.id.tvCake);

        Intent intent = getIntent();
        if (intent != null) {
            String cake = intent.getStringExtra("cake");
            tvCake.setText(cake);
        }

        nextDayRadioButton = findViewById(R.id.nextday);
        nextDayRadioButton.setChecked(true);

        lablelSpinner = findViewById(R.id.label_spinner);
        // change this to class your listener
        lablelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String text =parent.getItemAtPosition(position).toString();
                displayToast(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast("R.string.same_day_messenger_service");
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast("getString(R.string.next_day_ground_delivery");
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast("getString(R.string.pick_up)");
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}