package org.cornmuffin.droidcafeinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String order = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        String displayableMessage = getString(R.string.Order) + order;
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(displayableMessage);

        // init phone spinner
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }
    }

    public void onRadioButtonClicked(View view) {
        if (((RadioButton) view).isChecked()) {
            if (view.getId() == R.id.sameday) {
                displayToast(getString(R.string.same_day_messenger_service));
            } else if (view.getId() == R.id.nextday) {
                displayToast(getString(R.string.next_day_ground_delivery));
            } else if (view.getId() == R.id.pickup) {
                displayToast(getString(R.string.pick_up));
            }
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // TODO When/if we actually do something to submit an order, we'll have to add some code here.
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
