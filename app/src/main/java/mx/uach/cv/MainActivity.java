package mx.uach.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.logging.Logger;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button gilBtn = findViewById(R.id.gilBtn);
        final Button mauBtn = findViewById(R.id.mauBtn);
        final Button sofBtn = findViewById(R.id.sofBtn);

        gilBtn.setOnClickListener(new View.OnClickListener() { //esto es una sobrecarga desde la instancia y no desde la clase
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("person","gil");
                startActivity(intent);
            }
        });

        mauBtn.setOnClickListener(new View.OnClickListener() { //esto es una sobrecarga desde la instancia y no desde la clase
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("person","mau");
                startActivity(intent);
            }
        });

        sofBtn.setOnClickListener(new View.OnClickListener() { //esto es una sobrecarga desde la instancia y no desde la clase
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("person","sof");
                startActivity(intent);
            }
        });


    }
}