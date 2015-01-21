package com.example.rakeshch.todoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class EditItemActivity extends ActionBarActivity {

    EditText editText;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String item = getIntent().getStringExtra("item");
        editText = (EditText)findViewById(R.id.editText);
        editText.setText(item);

        saveButton = (Button)findViewById(R.id.button);
        setUpSaveButtonListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setUpSaveButtonListener() {

        saveButton.setOnClickListener(
                new AdapterView.OnClickListener() {
                    @Override
                    public void onClick(View item) {
                        EditText etName = (EditText) findViewById(R.id.editText);
                        Intent data = new Intent();
                        data.putExtra("item", etName.getText().toString());
                        setResult(RESULT_OK, data);
                        finish();
                    }

                }
        );
    }
}
