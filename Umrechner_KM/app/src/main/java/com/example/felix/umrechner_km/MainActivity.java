package com.example.felix.umrechner_km;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends Activity implements View.OnClickListener
{
    private final static double factor = 0.6214;

    Button buttonBerechnen;
    EditText eingabe;
    TextView ausgabe;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBerechnen = (Button) findViewById(R.id.buttonBerechnen);
        eingabe = (EditText) findViewById(R.id.editText_eingabe);
        ausgabe = (TextView) findViewById(R.id.textView_ausgabe_miles);
        buttonBerechnen.setOnClickListener(this);
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId())
        {
            case R.id.action_berechnen:
                calculateMiles();
                return true;
            case R.id.action_clear:
                try
                {
                    eingabe.setText("0");
                    ausgabe.setText("");
                }
                catch(Exception e)
                {
                    Log.d("Fehler", e.getMessage());
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view)
    {
        if(view == buttonBerechnen)
        {
            calculateMiles();
        }
    }

    private void calculateMiles()
    {
        final double eingabeKM = Double.parseDouble(eingabe.getText().toString());
        double miles = eingabeKM * factor;
        DecimalFormat df = new DecimalFormat("0.000");
        ausgabe.setText(df.format(miles));
    }
}
