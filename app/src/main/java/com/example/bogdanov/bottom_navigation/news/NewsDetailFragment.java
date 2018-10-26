package com.example.bogdanov.bottom_navigation.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bogdanov.bottom_navigation.Post;
import com.example.bogdanov.bottom_navigation.R;

import androidx.navigation.Navigation;

public class NewsDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView titleTextView = view.findViewById(R.id.news_detail_title);
        TextView descTextView = view.findViewById(R.id.news_detail_desc);
        Button button = view.findViewById(R.id.news_detail_btn);
        if (getArguments() != null) {
            Post post = (Post) getArguments().getSerializable("extra-post");
            titleTextView.setText(post.getTitle());
            descTextView.setText(post.getDesc());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_newsDetailFragment_to_notUniqueFragment);
            }
        });
    }
}
