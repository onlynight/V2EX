package com.github.onlynight.v2ex.module.topic_details.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.AdapterDataOperator;
import com.github.onlynight.v2ex.base.VDBViewHolder;
import com.github.onlynight.v2ex.databinding.ItemTopicReplyBinding;
import com.github.onlynight.v2ex.databinding.PartTopicDetailsBinding;
import com.github.onlynight.v2ex.model.ReplyResponse;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.utils.TimeBase;
import com.github.onlynight.v2ex.view.combinerecyclerview.LoadMoreRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TopicDetailsAdapter extends LoadMoreRecyclerAdapter implements
        AdapterDataOperator<ReplyResponse> {

    private static final int VIEW_TYPE_TOPIC_DETAILS = 2;
    private static final int VIEW_TYPE_TOPIC_REPLY = 3;

    private TopicResponse topic;
    private List<ReplyResponse> replies;

    public TopicDetailsAdapter() {
        replies = new ArrayList<>();
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_TOPIC_DETAILS:
                return new TopicDetailsViewHolder(
                        TopicDetailsViewHolder.createDataBinding(R.layout.part_topic_details, parent));
            case VIEW_TYPE_TOPIC_REPLY:
                return new TopicReplyViewHolder(
                        TopicDetailsViewHolder.createDataBinding(R.layout.item_topic_reply, parent));
        }
        return null;
    }

    @Override
    protected void onBindItem(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopicDetailsViewHolder) {
            ((TopicDetailsViewHolder) holder).bindData(topic, 0);
        } else if (holder instanceof TopicReplyViewHolder) {
            int realPosition = position - 1;
            ((TopicReplyViewHolder) holder).bindData(replies.get(realPosition), realPosition);
        }
    }

    @Override
    public int getItemCount() {
        return replies.size() + 1;
    }

    @Override
    public int getContentViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_TOPIC_DETAILS;
        } else {
            return VIEW_TYPE_TOPIC_REPLY;
        }
    }

    @Override
    public List<ReplyResponse> getData() {
        return replies;
    }

    @Override
    public void setData(List<ReplyResponse> data) {
        if (data != null) {
            replies = data;
        }
    }

    @Override
    public void clearData() {
        replies.clear();
    }

    @Override
    public void addData(List<ReplyResponse> data) {
        replies.addAll(data);
    }

    public void setTopic(TopicResponse topic) {
        this.topic = topic;
        notifyItemChanged(0);
    }

    public class TopicDetailsViewHolder extends VDBViewHolder<PartTopicDetailsBinding, TopicResponse> {

        TopicDetailsViewHolder(PartTopicDetailsBinding viewDataBinding) {
            super(viewDataBinding);
        }

        @Override
        public void bindData(TopicResponse topic, int position) {
            if (topic != null) {
                viewDataBinding.textTitle.setText(topic.getTitle());
                viewDataBinding.textContent.setText(topic.getContent());
                viewDataBinding.textReplyNum.setText(String.valueOf(topic.getReplies()));
                viewDataBinding.textTime.setText(new TimeBase(topic.getLast_modified()).getShowTime());

                Glide.with(viewDataBinding.imgAvatar)
                        .load(topic.getMember().getAvatar_large())
                        .into(viewDataBinding.imgAvatar);

                viewDataBinding.textUserName.setText(topic.getMember().getUsername());
            }
        }

    }

    public class TopicReplyViewHolder extends VDBViewHolder<ItemTopicReplyBinding, ReplyResponse> {

        TopicReplyViewHolder(ItemTopicReplyBinding viewDataBinding) {
            super(viewDataBinding);
        }

        @Override
        public void bindData(ReplyResponse replyResponse, int position) {
            viewDataBinding.viewBlank.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
            viewDataBinding.textUserName.setText(replyResponse.getMember().getUsername());
            viewDataBinding.textTime.setText(new TimeBase(replyResponse.getLast_modified()).getShowTime());
            viewDataBinding.textReply.setText(replyResponse.getContent());
            Glide.with(viewDataBinding.imgAvatar)
                    .load(replyResponse.getMember().getAvatar_large())
                    .into(viewDataBinding.imgAvatar);
        }

    }

}
