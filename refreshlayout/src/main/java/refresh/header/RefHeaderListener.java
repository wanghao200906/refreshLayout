package refresh.header;

import android.view.View;

import refresh.RefreshLayout;

/**
 * Created by wanghao on 2017/9/25.
 */

public interface RefHeaderListener {

    View getHeaderView(RefreshLayout root);

    /**
     * 开始刷新
     *
     * @param view
     */
    void onBeginRefresh(RefreshLayout view);

    /**
     * 刷新完成
     *
     * @param view
     */
    void onCompleteRefuse(RefreshLayout view);

    void onResetHeader();

    /**
     * 改变高度时，满足刷新状态
     *
     * @param isRequireRefresh 是否满足刷新要求
     */
    void onPrepareRefreshToggle(boolean isRequireRefresh);

    /**
     * Header位置变化回调
     *
     * @param mHeaderHeight Header高度
     * @param mRefuseHeight 允许刷新的下拉高度
     * @param isTouch       是否触碰屏幕
     */
    void onPositionChange(int mHeaderHeight, int mRefuseHeight, int currentPosition, boolean isTouch);
}
