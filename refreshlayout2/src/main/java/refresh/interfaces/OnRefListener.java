package refresh.interfaces;

import refresh.RefreshLayout;

/**
 * Created by wanghao on 2017/9/25.
 */

public interface OnRefListener {

    /**
     * 执行下拉刷新
     *
     * @param view
     */
    void onRefresh(RefreshLayout view);
}
