package com.github.onlynight.v2ex.module.topic_details;

import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.BaseActivity;
import com.github.onlynight.v2ex.databinding.ActivityTopicDetailsBinding;

public class TopicDetailsActivity extends BaseActivity<ActivityTopicDetailsBinding, TopicDetailsViewModel>
        implements TopicDetailsContract.View {

    @Override
    protected void onBind(ActivityTopicDetailsBinding viewDataBinding) {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_topic_details;
    }

    @Override
    protected TopicDetailsViewModel createViewModel() {
        return new TopicDetailsViewModel(this);
    }

}
