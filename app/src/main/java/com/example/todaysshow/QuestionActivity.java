package com.example.todaysshow;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final Spinner spinner_field = (Spinner) findViewById(R.id.spinner_field);
        String[] str = getResources().getStringArray(R.array.question_spinner);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.question_spinner_item,str){
            @Override
            public boolean isEnabled(int position) {
                if(position == 0){
                    return false;
                }
                else{
                    return true;
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(Color.WHITE);
                    tv.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.rounded_corner));
                    tv.setTextSize(10);
                }else{
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setTextColor(Color.GRAY);
                    tv.setTextSize(10);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_field.setAdapter(adapter);
        spinner_field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String)parent.getItemAtPosition(position);
                if(position>0){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.question_toolbar,menu);
        return true;
    }

}
