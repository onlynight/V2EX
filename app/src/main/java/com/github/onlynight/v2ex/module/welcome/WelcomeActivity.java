package com.github.onlynight.v2ex.module.welcome;

import android.animation.Animator;
import android.content.Intent;

import com.github.onlynight.v2ex.module.main.MainActivity;
import com.github.onlynight.v2ex.R;
import com.github.onlynight.v2ex.base.BaseActivity;
import com.github.onlynight.v2ex.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding, WelcomeViewModel>
        implements WelcomeContract.View {

    @Override
    protected WelcomeViewModel createViewModel() {
        return new WelcomeViewModel(this);
    }

    @Override
    protected void onBind(final ActivityWelcomeBinding viewDataBinding) {
        viewDataBinding.rippleLayout.setAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                viewDataBinding.rippleLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                        finish();
                    }
                }, 500);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        viewModel.testFunction();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void testFunction(String args) {
        System.out.println(args);
    }
}
