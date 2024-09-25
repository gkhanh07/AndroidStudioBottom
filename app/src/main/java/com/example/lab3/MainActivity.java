package com.example.lab3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enabling edge-to-edge mode
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Set the content view using the binding
        replaceFragment(new HomeFragment());

        // Set up BottomNavigationView item selection listener
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null; // Declare a Fragment variable
            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment(); // Assuming you have a HomeFragment class
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment(); // Assuming you have a ProfileFragment class
                    break;
                case R.id.setting:
                    selectedFragment = new SettingFragment(); // Assuming you have a SettingsFragment class
                    break;
                default:
                    return false; // Return false for unhandled items
            }

            // Replace the fragment
            replaceFragment(selectedFragment);
            return true; // Indicate that the selection was handled
        });
    }

    // Method to replace the fragment
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment); // Replace the FrameLayout with the new fragment
        fragmentTransaction.addToBackStack(null); // Optional: add the transaction to the back stack
        fragmentTransaction.commit(); // Commit the transaction
    }
}
