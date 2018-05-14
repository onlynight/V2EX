package com.github.onlynight.v2ex.module.topic_list;

import com.github.onlynight.v2ex.databinding.FragmentTopicListBinding;

public class LatestTopicListFragment extends BaseTopicListFragment {

    @Override
    protected void onBind(FragmentTopicListBinding viewDataBinding) {
        super.onBind(viewDataBinding);
        bindData(viewModel.getUpdateLatestTopics(), this::updateTopics);
    }

    @Override
    public String getFragmentTitle() {
        return "最新";
    }

    @Override
    public void onRefresh() {
        viewModel.getLatestTopic();
    }
}
