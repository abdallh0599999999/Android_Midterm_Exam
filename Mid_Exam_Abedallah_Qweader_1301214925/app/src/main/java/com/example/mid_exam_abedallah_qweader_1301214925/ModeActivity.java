
package com.example.mid_exam_abedallah_qweader_1301214925;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mid_exam_abedallah_qweader_1301214925.databinding.ActivityModeBinding;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NavUtils;
public class ModeActivity extends AppCompatActivity {

    private ActivityModeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityModeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Set Adapter
        PageAdapter adapter = new PageAdapter(this);
        binding.viewPager.setAdapter(adapter);

        // Connect TabLayout with ViewPager2
        new TabLayoutMediator(binding.tabLayout,
                binding.viewPager,
                (tab, position) -> {

                    switch (position) {
                        case 0:
                            tab.setText("First");
                            break;

                        case 1:
                            tab.setText("Second");
                            break;

                        case 2:
                            tab.setText("Third");
                            break;
                    }

                }).attach();
        binding.setModeButton.setOnClickListener(v -> {

            PopupMenu popupMenu = new PopupMenu(
                    ModeActivity.this,
                    binding.setModeButton
            );

            popupMenu.getMenu().add("Light");
            popupMenu.getMenu().add("Night");
            popupMenu.getMenu().add("System");

            popupMenu.setOnMenuItemClickListener(item -> {

                String mode = item.getTitle().toString();

                if (mode.equals("Light")) {

                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_NO);

                } else if (mode.equals("Night")) {

                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_YES);

                } else if (mode.equals("System")) {

                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }

                return true;
            });

            popupMenu.show();
        });
    }
    @Override
    public void onBackPressed() {

        if (binding.viewPager.getCurrentItem() != 0) {

            binding.viewPager.setCurrentItem(0, true);

        } else {

            super.onBackPressed();

        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }
}
