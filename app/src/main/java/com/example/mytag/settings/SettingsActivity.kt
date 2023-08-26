package com.example.mytag.settings

import android.annotation.SuppressLint
import android.app.backup.SharedPreferencesBackupHelper
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.mytag.R
import com.example.mytag.support.ButtonsAnimation
private const val FON_START = "fonStartValue"
var listCheckBox = listOf<CheckBox>()

class SettingsActivity : AppCompatActivity(), ButtonsAnimation {

    @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val ok: Button = findViewById(R.id.b_ok)
        showButtonAnimation(ok)
        val fonStart: CheckBox = findViewById(R.id.checkBox)
        val fonStart2: CheckBox = findViewById(R.id.checkBox2)
        val fonStart3: CheckBox = findViewById(R.id.checkBox3)
        val fonStart4: CheckBox = findViewById(R.id.checkBox4)
        val fonStart5: CheckBox = findViewById(R.id.checkBox5)

        listCheckBox = listOf(fonStart,fonStart2,fonStart3,fonStart4,fonStart5)


        //сохраняем в памяти фон после выбора
        val sharedPreferences = getSharedPreferences(FON_START, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val valueFon = sharedPreferences.getString("fonStartValue", "fonStart");

        when (valueFon) {
            "fonStart" -> fonStart.isChecked = true
            "fonStart2" -> fonStart2.isChecked = true
            "fonStart3" -> fonStart3.isChecked = true
            "fonStart4" -> fonStart4.isChecked = true
            "fonStart5" -> fonStart5.isChecked = true
        }

        fonStart.setOnClickListener {
            checkAndSave("fonStart",0,editor)
//            if (fonStart.isChecked) {
//                fonStart2.isChecked = false
//                fonStart3.isChecked = false
//                fonStart4.isChecked = false
//                fonStart5.isChecked = false
//
//                editor.putString(FON_START, "fonStart")
//                editor.apply()
//            }
        }

        fonStart2.setOnClickListener {
            checkAndSave("fonStart2",1,editor)
//            if (fonStart2.isChecked) {
//                fonStart.isChecked = false
//                fonStart3.isChecked = false
//                fonStart4.isChecked = false
//                fonStart5.isChecked = false
//
//                editor.putString(FON_START, "fonStart2")
//                editor.apply()
//            }
        }

        fonStart3.setOnClickListener {
            checkAndSave("fonStart3",2,editor)
//            if (fonStart3.isChecked) {
//                fonStart.isChecked = false
//                fonStart2.isChecked = false
//                fonStart4.isChecked = false
//                fonStart5.isChecked = false
//
//                editor.putString(FON_START, "fonStart3")
//                editor.apply()
//            }
        }

        fonStart4.setOnClickListener {
            checkAndSave("fonStart4",3,editor)
//            if (fonStart4.isChecked) {
//                fonStart.isChecked = false
//                fonStart2.isChecked = false
//                fonStart3.isChecked = false
//                fonStart5.isChecked = false
//
//                editor.putString(FON_START, "fonStart4")
//                editor.apply()
//            }
        }

        fonStart5.setOnClickListener {
            checkAndSave("fonStart5",4,editor)
//            if (fonStart5.isChecked) {
//                fonStart.isChecked = false
//                fonStart2.isChecked = false
//                fonStart3.isChecked = false
//                fonStart4.isChecked = false
//
//                editor.putString(FON_START, "fonStart5")
//                editor.apply()
//            }
        }
        ok.setOnClickListener {
            finish()
        }
    }
    fun checkAndSave(key:String,numberButton:Int,editor: SharedPreferences.Editor){
        for (i in listCheckBox) {
            if (i == listCheckBox[numberButton]) {
                listCheckBox[numberButton].isChecked = true
            } else {
                i.isChecked = false
            }
        }
        editor.putString(FON_START, key)
        editor.apply()
    }
}