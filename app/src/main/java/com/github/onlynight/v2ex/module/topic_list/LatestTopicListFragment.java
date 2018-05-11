package com.github.onlynight.v2ex.module.topic_list;

public class LatestTopicListFragment extends BaseTopicListFragment {

    @Override
    public String getFragmentTitle() {
        return "最新";
    }

    @Override
    public void onRefresh() {
        viewModel.getLatestTopic();
    }
}
