package com.github.onlynight.v2ex.module.topic_list;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.BaseFragment;
import com.github.onlynight.v2ex.databinding.FragmentTopicListBinding;
import com.github.onlynight.v2ex.model.TopicResponse;
import com.github.onlynight.v2ex.module.topic_list.adapter.TopicAdapter;
import com.github.onlynight.v2ex.utils.LogUtils;

import java.util.List;

public class BaseTopicListFragment extends BaseFragment<FragmentTopicListBinding, TopicListViewModel> implements
        TopicListContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    protected TopicAdapter adapter;

    @Override
    protected void onBind(FragmentTopicListBinding viewDataBinding) {
        adapter = new TopicAdapter();
        viewDataBinding.recyclerView.setAdapter(adapter);
        viewDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewDataBinding.recyclerView.setOnRefreshListener(this);

        viewDataBinding.recyclerView.setRefreshing(true);
        onRefresh();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_topic_list;
    }

    @Override
    protected TopicListViewModel createViewModel() {
        return new TopicListViewModel(this);
    }

    @Override
    public String getFragmentTitle() {
        return "Topics";
    }

    @Override
    public void updateTopics(List<TopicResponse> topics) {
        viewDataBinding.recyclerView.setRefreshing(false);
        adapter.setData(topics);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
    }

}
