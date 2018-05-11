package com.github.onlynight.v2ex.module.topic_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.view.combinerecyclerview.LoadMoreRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends LoadMoreRecyclerAdapter {

    private List<TopicResponse> data;

    public TopicAdapter() {
        data = new ArrayList<>();
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_topic_list, parent, false));
    }

    @Override
    protected void onBindItem(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).bindData(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<TopicResponse> getData() {
        return data;
    }

    public void setData(List<TopicResponse> data) {
        if (data != null) {
            this.data = data;
        }
    }

    public void clearData() {
        this.data.clear();
    }

    public void addData(List<TopicResponse> data) {
        this.data.addAll(data);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textContent;

        public ViewHolder(View itemView) {
            super(itemView);
            textContent = itemView.findViewById(R.id.text_content);
        }

        public void bindData(TopicResponse topic) {
            textContent.setText(topic.getContent());
        }

    }

}
