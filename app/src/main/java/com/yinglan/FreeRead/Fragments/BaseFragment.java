package com.yinglan.FreeRead.Fragments;

import android.support.v4.app.Fragment;

/**
 * Created by ${AUTHOR} on 2019/3/30 0030
 * Function: ${Function}
 */
public abstract class BaseFragment extends Fragment {

    /** Fragment当前状态是否可见 */
    protected boolean isVisible;

    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

}
