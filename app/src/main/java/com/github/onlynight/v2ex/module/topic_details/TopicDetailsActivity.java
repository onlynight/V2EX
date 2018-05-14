package com.github.onlynight.v2ex.module.topic_details;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.BaseActivity;
import com.github.onlynight.v2ex.databinding.ActivityTopicDetailsBinding;
import com.github.onlynight.v2ex.model.ReplyResponse;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.module.topic_details.adapter.TopicDetailsAdapter;
import com.github.onlynight.v2ex.utils.CollectionsUtils;

import java.util.List;

public class TopicDetailsActivity extends BaseActivity<ActivityTopicDetailsBinding, TopicDetailsViewModel>
        implements SwipeRefreshLayout.OnRefreshListener {

    protected TopicDetailsAdapter adapter;

    @Override
    protected void onBind(ActivityTopicDetailsBinding viewDataBinding) {
        initToolbar(viewDataBinding);
        viewDataBinding.combineRecyclerView.setOnRefreshListener(this);
        viewDataBinding.combineRecyclerView.setRefreshing(true);
        viewDataBinding.combineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TopicDetailsAdapter();
        viewDataBinding.combineRecyclerView.setAdapter(adapter);

        bindData(viewModel.getUpdateTopic(), this::updateTopicDetails);
        bindData(viewModel.getUpdateReplies(), this::updateTopicReplies);

        onRefresh();
    }

    private void updateTopicReplies(List<ReplyResponse> replies) {
        if (replies != null) {
            adapter.setData(replies);
            adapter.notifyDataSetChanged();
        }
    }

    private void updateTopicDetails(List<TopicResponse> topics) {
        viewDataBinding.combineRecyclerView.setRefreshing(false);
        TopicResponse topic = CollectionsUtils.getFirstItem(topics);
        if (topic != null) {
            getSupportActionBar().setTitle(topic.getTitle());
        }
        adapter.setTopic(topic);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_topic_details;
    }

    @Override
    protected TopicDetailsViewModel createViewModel() {
        return new TopicDetailsViewModel();
    }

    @Override
    public void onRefresh() {
        viewModel.getTopic();
        viewModel.getReplies();
    }

}
