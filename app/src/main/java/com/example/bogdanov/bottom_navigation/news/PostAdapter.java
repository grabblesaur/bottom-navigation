package com.example.bogdanov.bottom_navigation.news;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.bogdanov.bottom_navigation.Post;
import com.example.bogdanov.bottom_navigation.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> mPostList;
    private PostAdapterListener mListener;

    public PostAdapter(List<Post> postList, PostAdapterListener listener) {
        mPostList = postList;
        mListener = listener;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(mPostList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        private FrameLayout mFrameLayout;
        private TextView mTextView;

        public PostViewHolder(View itemView) {
            super(itemView);
            mFrameLayout = itemView.findViewById(R.id.item_post_layout);
            mTextView = itemView.findViewById(R.id.item_post_title);
        }

        public void onBind(final Post post) {
            mFrameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onItemClicked(post);
                    }
                }
            });
            mTextView.setText(post.getTitle());
        }
    }

    public interface PostAdapterListener {
        void onItemClicked(Post post);
    }
}
