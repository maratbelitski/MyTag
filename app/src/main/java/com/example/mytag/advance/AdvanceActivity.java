package com.example.mytag.advance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mytag.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AdvanceActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    private String countStep = "1";
    private String typeGame = "1";
    private String levelGame = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);

        ViewPager2 viewPager2 = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_advance);

        TextView step3x3_classic = findViewById(R.id.step3x3_classic);
        TextView step4x4_classic = findViewById(R.id.step4x4_classic);
        TextView step3x3_snake = findViewById(R.id.step3x3_snake);
        TextView step4x4_snake = findViewById(R.id.step4x4_snake);

        if (typeGame.equals("classic")) {
            if (levelGame.equals("easy")) {
                step3x3_classic.setText(countStep);
            } else {
                step4x4_classic.setText(countStep);
            }
        } else if (typeGame.equals("snake")) {
            if (levelGame.equals("easy")) {
                step3x3_snake.setText(countStep);
            } else {
                step4x4_snake.setText(countStep);
            }
        }

        FragmentStateAdapter fragmentStateAdapter = new SelectionsPagerAdapter2(this);
        viewPager2.setAdapter(fragmentStateAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (TabLayoutMediator.TabConfigurationStrategy) this).attach();
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        switch (position) {
            case 0 -> tab.setText(R.string.tab_facts);
            case 1 -> tab.setText(R.string.tab_records);
        }
    }


    public static class SelectionsPagerAdapter2 extends FragmentStateAdapter {

        public SelectionsPagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return switch (position) {
                case 0 -> new FactsFragment();
                case 1 -> new RecordsFragment();
                default -> null;
            };
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}

