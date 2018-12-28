package com.cheyrouse.gael.mynews.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.cheyrouse.gael.mynews.Controllers.Fragments.ArticlesFragment;
import com.cheyrouse.gael.mynews.Models.Result;
import com.cheyrouse.gael.mynews.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final onArticleAdapterListener mListener;

    public interface Listener {
        void onClickDeleteButton(int position);
    }

    // FOR COMMUNICATION


    // FOR DATA
    private List<Result> topStories;
    private RequestManager glide;

    // CONSTRUCTOR
    public RecyclerViewAdapter(List<Result> topStories, RequestManager glide, ArticlesFragment articleAdapterListener) {
        this.mListener = articleAdapterListener;
        this.topStories = topStories;
        this.glide = glide;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_article_item, parent, false);

        return new RecyclerViewHolder(view);
    }

    // UPDATE VIEW HOLDER WITH A TOPSTORIES
    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {
        viewHolder.updateWithResult(this.topStories.get(position), this.glide, mListener);
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.topStories.size();
    }


    public Result getArticle (int position) {
        return this.topStories.get(position);
    }

    public interface onArticleAdapterListener {
        void onArticleClicked(Result resultTopStories);
    }
}
