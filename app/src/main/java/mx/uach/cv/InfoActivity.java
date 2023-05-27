package mx.uach.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Objects;
import java.util.logging.Logger;
import mx.uach.cv.models.InfoCV;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String name = this.getIntent().getStringExtra("person");
        //AQUI LE METEMOS LOS TEXT VIEW
        final TextView title = findViewById(R.id.layout_title);

        Logger.getLogger("app ->").info("===========================");





        final String titleStr = this.getIntent().getStringExtra("person");
        title.setText(titleStr);
        Logger.getLogger("app ->").info(titleStr);


        //YA NOMÁS FALTA METERLE QUE OBTENGA LOS DATOS DE INTERNET Y LUEGO MOSTRARLOS
        if(Objects.equals(titleStr, "gil")){
            Logger.getLogger("app ->").info("===========================");
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://raw.githubusercontent.com/Gilelberto/info-cv-jsons/main/infoGil.json";
            StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //System.out.println(response);
                    InfoCV infocv = new Gson().fromJson(response, InfoCV.class);
                    title.setText(infocv.name);

                }
            }, new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    Logger.getLogger("REQUEST WEATHER").warning(error.toString());
                }
            });
            queue.add(sr);
        }
        else if(Objects.equals(titleStr, "mau")){
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://raw.githubusercontent.com/LagMau2/cv2/master/cv_mau.json";
            StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    InfoCV infocv = new Gson().fromJson(response, InfoCV.class);
                    title.setText(infocv.name);
                }
            }, new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    Logger.getLogger("REQUEST WEATHER").warning(error.toString());
                }
            });
            queue.add(sr);

        }
        else if(Objects.equals(titleStr, "sof")){
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://raw.githubusercontent.com/a348451/shofo/main/shofocv.json";
            StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    InfoCV infocv = new Gson().fromJson(response, InfoCV.class);
                    title.setText(infocv.name);
                }
            }, new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    Logger.getLogger("REQUEST WEATHER").warning(error.toString());
                }
            });
            queue.add(sr);

        }
    }
}