package com.github.onlynight.v2ex.module.topic_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.view.combinerecyclerview.LoadMoreRecyclerAdapter;
import com.github.onlynight.v2ex.view.combinerecyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class TopicListAdapter extends LoadMoreRecyclerAdapter {

    private List<TopicResponse> data;
    private OnItemClickListener<TopicResponse> onItemClickListener;

    public TopicListAdapter() {
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
            ((ViewHolder) holder).bindData(data.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener<TopicResponse> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView textTitle;
        TextView textUsername;
        TextView textContent;
        TextView textReplies;
        LinearLayout layoutBase;

        ViewHolder(View itemView) {
            super(itemView);
            layoutBase = itemView.findViewById(R.id.layout_base);
            textTitle = itemView.findViewById(R.id.text_title);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            textUsername = itemView.findViewById(R.id.text_user_name);
            textContent = itemView.findViewById(R.id.text_content);
            textReplies = itemView.findViewById(R.id.text_reply_num);
        }

        void bindData(TopicResponse topic, int position) {
            textTitle.setText(topic.getTitle());
            textContent.setText(topic.getContent());
            textUsername.setText(topic.getMember().getUsername());
            textReplies.setText(String.valueOf(topic.getReplies()));
            Glide.with(imgAvatar).load(topic.getMember().getAvatar_normal()).into(imgAvatar);

            layoutBase.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(layoutBase, topic, position);
                }
            });
        }

    }

}
