package ru.pasvitas.teaching.contactteachinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import ru.pasvitas.teaching.contactteachinapp.model.AddContactRequest;
import ru.pasvitas.teaching.contactteachinapp.model.AddContactResponse;

public class MainActivity extends AppCompatActivity {


    private TextView statusTextView;
    private EditText editTextName;
    private EditText editTextPhone;
    private Button button;

    private final static String URL = "http://192.168.0.102:8090/api/contacts";

    private final Gson gson = new Gson();

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        statusTextView = findViewById(R.id.textViewStatus);
        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextPhone = findViewById(R.id.editTextPhone);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            if (editTextName.getText().toString().isEmpty() || editTextPhone.getText().toString().isEmpty()) {
                statusTextView.setText("ПОЖАЛУЙСТА введите имя и телефон");
            }
            else {
                makeRequest(editTextName.getText().toString(), editTextPhone.getText().toString());
            }
        });
    }

    private void makeRequest(String name, String contact) {

        AddContactRequest request = new AddContactRequest(name, contact);

        String requestJson = gson.toJson(request);

        try {
            JSONObject jsonObject = new JSONObject(requestJson);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.POST, URL, jsonObject, response -> {
                        AddContactResponse responseModel = gson.fromJson(response.toString(), AddContactResponse.class);
                        statusTextView.setText("Ваш номер: " + responseModel.getId());
                    }, error -> {
                        // TODO: Handle error
                        statusTextView.setText("Ошибка запроса: " + error.getMessage());
                    });
            requestQueue.add(jsonObjectRequest);
        }
        catch (JSONException e) {
            statusTextView.setText("Непредвиденная ошибка");
        }
    }
}