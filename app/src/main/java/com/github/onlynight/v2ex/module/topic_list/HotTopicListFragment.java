package com.github.onlynight.v2ex.module.topic_list;

import com.github.onlynight.v2ex.databinding.FragmentTopicListBinding;

public class HotTopicListFragment extends BaseTopicListFragment {

    @Override
    protected void onBind(FragmentTopicListBinding viewDataBinding) {
        super.onBind(viewDataBinding);
        bindData(viewModel.getUpdateHotTopics(), this::updateTopics);
    }

    @Override
    public String getFragmentTitle() {
        return "热门";
    }

    @Override
    public void onRefresh() {
        viewModel.getHotTopic();
    }

}
