package com.example.droidcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String cake = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void orderCake(View view) {

        if (view.getId() == R.id.donut) {
            cake = "Donut";
            Toast.makeText(this, getString(R.string.donut_order_message), Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.froyo) {
            cake = "FroYo";
            Toast.makeText(this, getString(R.string.froyo_order_message), Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.ice_cream) {
            cake = "Ice cream sandwich";
            Toast.makeText(this, getString(R.string.ice_cream_order_message), Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("cake", cake);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));

                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                // Set the dialog title and message.
                myAlertBuilder.setTitle("Thanh toán ?");
                myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:");
                // Add the dialog buttons.
                myAlertBuilder.setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), "Pressed OK", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, OrderActivity.class));
                });
                myAlertBuilder.setNegativeButton("Cancel", (dialog, which) -> {
                    // User cancelled the dialog.
                    Toast.makeText(getApplicationContext(), "Pressed Cancel", Toast.LENGTH_SHORT).show();
                });
                // Create and show the AlertDialog.
                myAlertBuilder.show();



                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favourites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

}