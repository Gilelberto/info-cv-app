package mx.uach.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
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
        final TextView phone = findViewById(R.id.phone);
        final TextView email = findViewById(R.id.email);
        final TextView objective = findViewById(R.id.obj);
        final TextView xp = findViewById(R.id.xp);





        final String titleStr = this.getIntent().getStringExtra("person");
        title.setText(titleStr);
        Logger.getLogger("app ->").info(titleStr);

        if(Objects.equals(titleStr, "gil")){
            WebView webView = findViewById(R.id.photo);
            webView.loadUrl("https://avatars.githubusercontent.com/u/24398402?v=4");
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://raw.githubusercontent.com/Gilelberto/info-cv-jsons/main/infoGil.json";
            StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //System.out.println(response);
                    InfoCV infocv = new Gson().fromJson(response, InfoCV.class);
                    title.setText(infocv.name);
                    phone.setText(infocv.phone);
                    email.setText(infocv.email);
                    objective.setText(infocv.objective);
                    xp.setText(infocv.experience);


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
            WebView webView = findViewById(R.id.photo);
            webView.loadUrl("https://cdn-5.motorsport.com/images/mgl/0a9neZP0/s1200/sergio-perez-red-bull-racing-1.webp");
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
            WebView webView = findViewById(R.id.photo);
            webView.loadUrl("https://avatars.githubusercontent.com/u/24398402?v=4");
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
