package refresh.interfaces;

import android.view.View;

import refresh.RefreshLayout;

/**
 * Created by wanghao on 2017/9/26.
 */
public interface RefOtherViewListener {

    /**
     * 加载错误页面
     *
     * @param root
     * @return
     */
    View geErrorView(RefreshLayout root);

    /**
     * 加载空数据页面
     *
     * @param root
     * @return
     */
    View geEmptyView(RefreshLayout root);
}
