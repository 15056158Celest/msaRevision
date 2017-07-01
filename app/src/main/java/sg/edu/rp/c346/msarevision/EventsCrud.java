package sg.edu.rp.c346.msarevision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventsCrud extends AppCompatActivity {
    EditText etDate, etTitle, etFee;
    Button btnAdd, btnEdit, btnDelete, btnShow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_crud);

        etDate = (EditText) findViewById(R.id.etDate);
        etTitle =(EditText) findViewById(R.id.etTitle);
        etFee = (EditText) findViewById(R.id.etFee);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnEdit = (Button) findViewById(R.id.btnUpdate);
        btnShow = (Button) findViewById(R.id.btnShow);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String date = etDate.getText().toString();
                String fee = etFee.getText().toString();

                DBHelper dbh = new DBHelper(EventsCrud.this);
                long adding = dbh.insertEvent(date,title,fee);
                dbh.close();

                if (adding != -1) {
                    Toast.makeText(EventsCrud.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(EventsCrud.this, EventList.class);
                startActivity(i);


            }
        });
    }
}
