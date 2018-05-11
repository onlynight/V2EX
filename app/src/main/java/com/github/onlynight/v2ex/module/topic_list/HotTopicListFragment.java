package com.github.onlynight.v2ex.module.topic_list;

public class HotTopicListFragment extends BaseTopicListFragment {

    @Override
    public String getFragmentTitle() {
        return "热门";
    }

    @Override
    public void onRefresh() {
        viewModel.getHotTopic();
    }

}
