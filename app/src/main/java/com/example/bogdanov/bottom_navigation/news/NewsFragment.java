package com.example.bogdanov.bottom_navigation.news;

import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bogdanov.bottom_navigation.Post;
import com.example.bogdanov.bottom_navigation.R;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NewsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        RecyclerView recyclerView = view.findViewById(R.id.news_recyclerview);

        List<Post> postList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post("Title " + i, "Desc " + i);
            postList.add(post);
        }
        PostAdapter adapter = new PostAdapter(postList, new PostAdapter.PostAdapterListener() {
            @Override
            public void onItemClicked(Post post) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("extra-post", post);
                navController.navigate(R.id.action_newsFragment_to_newsDetailFragment, bundle);
            }
        });

        RecyclerView.ItemDecoration itemDecorator = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
