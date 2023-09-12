package com.example.mytag.settings
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.mytag.R
import com.example.mytag.support.ButtonsAnimation

private const val SHAPE_TAGS = "shapeTags"
private var listCheckBox = listOf<CheckBox>()
class TagsFragment : Fragment(),ButtonsAnimation {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tags, container, false)

        val ok: Button = view.findViewById(R.id.b_ok)
        showButtonAnimation(ok)

        val shapeOne: CheckBox = view.findViewById(R.id.checkBox)
        val shapeTwo: CheckBox = view.findViewById(R.id.checkBox2)
        val shapeThree: CheckBox = view.findViewById(R.id.checkBox3)
        val shapeFour: CheckBox = view.findViewById(R.id.checkBox4)
        val shapeFive: CheckBox = view.findViewById(R.id.checkBox5)
        val shapeSix: CheckBox = view.findViewById(R.id.checkBox6)


        listCheckBox = listOf(shapeOne, shapeTwo,shapeThree,shapeFour,shapeFive,shapeSix)


        //сохраняем в памяти форму после выбора
        val sharedPreferences =
            this.requireActivity().getSharedPreferences(SHAPE_TAGS, AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val shape = sharedPreferences.getString("shapeTags", "shapeOne");

        when (shape) {
            "shapeOne" -> shapeOne.isChecked = true
            "shapeTwo" -> shapeTwo.isChecked = true
            "shapeThree" -> shapeThree.isChecked = true
            "shapeFour" -> shapeFour.isChecked = true
            "shapeFive" -> shapeFive.isChecked = true
            "shapeSix" -> shapeSix.isChecked = true
        }

        shapeOne.setOnClickListener {
            checkAndSave("shapeOne", 0, editor)
        }

        shapeTwo.setOnClickListener {
            checkAndSave("shapeTwo", 1, editor)
        }
        shapeThree.setOnClickListener {
            checkAndSave("shapeThree", 2, editor)
        }
        shapeFour.setOnClickListener {
            checkAndSave("shapeFour", 3, editor)
        }
        shapeFive.setOnClickListener {
            checkAndSave("shapeFive", 4, editor)
        }
        shapeSix.setOnClickListener {
            checkAndSave("shapeSix", 5, editor)
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
        editor.putString(SHAPE_TAGS, key)
        editor.apply()
    }
}