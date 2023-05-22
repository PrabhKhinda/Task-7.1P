package com.example.lostfoundapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewAdvertActivity : AppCompatActivity() {

    private lateinit var advertNameEditText: EditText
    private lateinit var advertDescriptionEditText: EditText
    private lateinit var advertDateEditText: EditText
    private lateinit var advertLocationEditText: EditText
    private lateinit var advertPhoneEditText: EditText
    private lateinit var lostRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_advert)

        advertNameEditText = findViewById(R.id.advertname)
        advertDescriptionEditText = findViewById(R.id.advertdescription)
        advertDateEditText = findViewById(R.id.advertdate)
        advertLocationEditText = findViewById(R.id.advertlocation)
        advertPhoneEditText = findViewById(R.id.advertphone)
        lostRadioButton = findViewById(R.id.lost_rbtn)

        val saveButton = findViewById<Button>(R.id.advertsave_btn)
        saveButton.setOnClickListener {
            val advertType = if (lostRadioButton.isChecked) "Lost" else "Found"
            val advertName = advertNameEditText.text.toString()
            val advertDescription = advertDescriptionEditText.text.toString()
            val advertDate = advertDateEditText.text.toString()
            val advertLocation = advertLocationEditText.text.toString()
            val advertPhone = advertPhoneEditText.text.toString()


            val databaseHelper = DatabaseHelper(this)
            databaseHelper.insertAdvert(advertType, advertName, advertDescription, advertDate, advertLocation, advertPhone)
            Toast.makeText(this, "Advert saved successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
         }
    }
}
