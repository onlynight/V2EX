package com.github.onlynight.v2ex.module.topic_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.AdapterDataOperator;
import com.github.onlynight.v2ex.base.VDBViewHolder;
import com.github.onlynight.v2ex.databinding.ItemTopicListBinding;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.utils.TimeBase;
import com.github.onlynight.v2ex.view.combinerecyclerview.LoadMoreRecyclerAdapter;
import com.github.onlynight.v2ex.view.combinerecyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class TopicListAdapter extends LoadMoreRecyclerAdapter implements AdapterDataOperator<TopicResponse> {

    private List<TopicResponse> data;
    private OnItemClickListener<TopicResponse> onItemClickListener;

    public TopicListAdapter() {
        data = new ArrayList<>();
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        ItemTopicListBinding dataBinding =
                VDBViewHolder.createDataBinding(R.layout.item_topic_list, parent);
        return new ViewHolder(dataBinding);
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

    public class ViewHolder extends VDBViewHolder<ItemTopicListBinding, TopicResponse> {

        ViewHolder(ItemTopicListBinding viewDataBinding) {
            super(viewDataBinding);
        }

        @Override
        public void bindData(TopicResponse topic, int position) {
            viewDataBinding.textTitle.setText(topic.getTitle());
            viewDataBinding.textContent.setText(topic.getContent());
            viewDataBinding.textUserName.setText(topic.getMember().getUsername());
            viewDataBinding.textReplyNum.setText(String.valueOf(topic.getReplies()));
            viewDataBinding.textTime.setText(new TimeBase(topic.getLast_modified()).getShowTime());
            Glide.with(viewDataBinding.imgAvatar).load(topic.getMember().getAvatar_normal()).into(viewDataBinding.imgAvatar);

            viewDataBinding.layoutBase.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(viewDataBinding.layoutBase, topic, position);
                }
            });
        }

    }

}
