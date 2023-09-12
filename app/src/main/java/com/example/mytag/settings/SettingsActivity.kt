package com.example.mytag.settings

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mytag.R
import com.example.mytag.support.ButtonsAnimation
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy

class SettingsActivity : AppCompatActivity(), ButtonsAnimation, TabConfigurationStrategy {

    @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val viewPager2 = findViewById<ViewPager2>(R.id.pager2)
        val tabLayout = findViewById<TabLayout>(R.id.tab2)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setTitle(R.string.toolbar_setting)


        val fragmentStateAdapter: FragmentStateAdapter = SelectionsPagerAdapter2(this)
        viewPager2.adapter = fragmentStateAdapter

        TabLayoutMediator(tabLayout, viewPager2, (this as TabConfigurationStrategy)!!).attach()

    }
    override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
        when (position) {
            0 -> tab.setText(R.string.tab_backgrounds)
            1 -> tab.setText(R.string.tab_shapes)
        }
    }


    class SelectionsPagerAdapter2(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(position: Int): Fragment {
            val n = null
            return when (position) {
                0 -> BackgroundFragment()
                1 -> TagsFragment()
                else -> BackgroundFragment()
            }
        }

        override fun getItemCount(): Int {
            return 2
        }
    }
}