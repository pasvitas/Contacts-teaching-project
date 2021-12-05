package ru.pasvitas.teaching.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject
import ru.pasvitas.teaching.app.model.ScheduleRequest
import ru.pasvitas.teaching.app.model.ScheduleResponse

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMain: TextView
    private lateinit var editField: EditText
    private lateinit var editFieldPhone: EditText
    private lateinit var button: Button

    private lateinit var queue: RequestQueue
    private val url = "http://192.168.0.102:8090/api/contacts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewMain = findViewById(R.id.statusTextView)
        editField = findViewById(R.id.editTextView)
        button = findViewById(R.id.button)
        editFieldPhone = findViewById(R.id.editTextPhone)

        queue = Volley.newRequestQueue(this)

        button.setOnClickListener {
            if (editField.text.isNotEmpty()) {
                makeRequest(editField.text.toString(), editFieldPhone.text.toString())
            }
        }
    }

    private fun makeRequest(name: String, phone: String) {

        val gson = Gson()

        val request = ScheduleRequest(name, phone)

        val requestJson = gson.toJson(request)

        val jsonObject = JSONObject(requestJson)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject,
            { responseJson ->
                val response = gson.fromJson(responseJson.toString(), ScheduleResponse::class.java)
                textViewMain.text = "Ваш номер в очереди: ${response.number}"
            },
            { error ->
                textViewMain.text = "Ошибка запроса! ${error.message}"
            }
        )

        queue.add(jsonObjectRequest)
    }
}