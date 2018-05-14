package com.github.onlynight.v2ex.base;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.onlynight.rxmvvm.IViewModel;
import com.github.onlynight.rxmvvm.base.BaseVDBMvvmActivity;
import com.github.onlynight.v2ex.R;

import java.util.Objects;

public abstract class BaseActivity<VDB extends ViewDataBinding, ViewModel extends IViewModel> extends
        BaseVDBMvvmActivity<VDB, ViewModel> {

    protected Toolbar toolbar;

    protected void initToolbar(VDB viewDataBinding) {
        initToolbar(viewDataBinding, true);
    }

    protected void initToolbar(VDB viewDataBinding, boolean isShowBack) {
        toolbar = viewDataBinding.getRoot().findViewById(R.id.tool_bar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);
        if (isShowBack) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(isShowBack);
        }
    }

    protected void translucentTitleBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    protected void translucentNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
