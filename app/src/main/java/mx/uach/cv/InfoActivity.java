package mx.uach.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String name = this.getIntent().getStringExtra("person");
        final TextView title = findViewById(R.id.layout_title);
        final String titleStr = this.getIntent().getStringExtra("person");
        title.setText(titleStr);

        //YA NOMÁS FALTA METERLE QUE OBTENGA LOS DATOS DE INTERNET Y LUEGO MOSTRARLOS
    }
}