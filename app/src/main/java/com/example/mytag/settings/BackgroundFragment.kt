package com.example.mytag.settings
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


import com.example.mytag.R
import com.example.mytag.support.ButtonsAnimation

private const val FON_START = "fonStartValue"
private var listCheckBox = listOf<CheckBox>()

class BackgroundFragment : Fragment(), ButtonsAnimation {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_background, container, false)

        val ok:Button = view.findViewById(R.id.b_ok)
        showButtonAnimation(ok)

        val fonStart: CheckBox = view.findViewById(R.id.checkBox)
        val fonStart2: CheckBox = view.findViewById(R.id.checkBox2)
        val fonStart3: CheckBox = view.findViewById(R.id.checkBox3)
        val fonStart4: CheckBox = view.findViewById(R.id.checkBox4)
        val fonStart5: CheckBox = view.findViewById(R.id.checkBox5)

        listCheckBox = listOf(fonStart, fonStart2, fonStart3, fonStart4, fonStart5)


        //сохраняем в памяти фон после выбора
        val sharedPreferences =  this.requireActivity().getSharedPreferences(FON_START, AppCompatActivity.MODE_PRIVATE)
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
            checkAndSave("fonStart", 0, editor)
        }

        fonStart2.setOnClickListener {
            checkAndSave("fonStart2", 1, editor)
        }

        fonStart3.setOnClickListener {
            checkAndSave("fonStart3", 2, editor)
        }

        fonStart4.setOnClickListener {
            checkAndSave("fonStart4", 3, editor)
        }

        fonStart5.setOnClickListener {
            checkAndSave("fonStart5", 4, editor)
        }
        ok.setOnClickListener {
            this.requireActivity().finish()
        }

        return view
    }

    private fun checkAndSave(key: String, numberButton: Int, editor: SharedPreferences.Editor) {
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