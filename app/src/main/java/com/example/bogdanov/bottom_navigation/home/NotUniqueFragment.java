package com.example.bogdanov.bottom_navigation.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bogdanov.bottom_navigation.R;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotUniqueFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_not_unique, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button backButton = view.findViewById(R.id.nu_back_btn);
        Button popBackStackButton = view.findViewById(R.id.nu_pop_backstack_btn);
        final NavController navController = Navigation.findNavController(view);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });

        popBackStackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int startDestination = navController.getGraph().getStartDestination();
                switch (startDestination) {
                    case R.id.homeFragment:
                        navController.popBackStack(R.id.homeFragment, false);
                        break;
                    case R.id.newsFragment:
                        navController.popBackStack(R.id.newsFragment, false);
                        break;
                }
            }
        });
    }
}
