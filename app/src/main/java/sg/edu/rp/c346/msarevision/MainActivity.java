package sg.edu.rp.c346.msarevision;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    ImageView ivPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        ivPhotos = (ImageView) findViewById(R.id.ivPhotos);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPhotos.setImageResource(R.drawable.kola);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPhotos.setImageResource(R.drawable.penguin);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.notfication){
            Intent i = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(i);


        }
        else  if (item.getItemId() == R.id.crud){
            Intent i = new Intent(MainActivity.this, EventsCrud.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
