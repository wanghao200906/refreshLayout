package refresh.header;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wh.reflayout.R;

import refresh.RefreshLayout;

/**
 * Created by wanghao on 2017/9/25.
 */

public class DefaultHeader implements RefHeaderListener {

    private ProgressBar mProgressBar;
    private ImageView mImageView;
    private TextView mTextView;

    private Context mContext;
    private Animation mAnimationTop, mAnimationBottom;

    public DefaultHeader(Context context) {
        mContext = context;
        mAnimationTop = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_top);
        mAnimationBottom = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_bottom);
    }

    @Override
    public View getHeaderView(RefreshLayout root) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.header_default, root, false);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mImageView = (ImageView) view.findViewById(R.id.iv_arrow);
        mTextView = (TextView) view.findViewById(R.id.tv_text);
        return view;
    }

    @Override
    public void onBeginRefresh(RefreshLayout view) {
        Log.i("info2", "onBeginRefresh");
        goneViews();
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setText("正在刷新...");
    }

    @Override
    public void onCompleteRefuse(RefreshLayout view) {
        Log.i("info2", "onCompleteRefuse");
        goneViews();
        mTextView.setText("更新完成");
    }

    @Override
    public void onResetHeader() {
        Log.i("info2", "onResetHeader");
        goneViews();
        mImageView.setVisibility(View.VISIBLE);
        mImageView.clearAnimation();
        mTextView.setText("下拉刷新...");
    }

    @Override
    public void onPrepareRefreshToggle(boolean isRequireRefresh) {
        Log.i("info2", "onPrepareRefreshToggle");
        if (isRequireRefresh) {
            mImageView.startAnimation(mAnimationTop);
            mTextView.setText("松开刷新...");
        } else {
            mImageView.startAnimation(mAnimationBottom);
            mTextView.setText("下拉刷新...");
        }
    }

    @Override
    public void onPositionChange(int mHeaderHeight, int mRefuseHeight, int currentPosition, boolean isTouch) {

    }

    private void goneViews() {
        mProgressBar.setVisibility(View.GONE);
        mImageView.clearAnimation();
        mImageView.setVisibility(View.GONE);
    }
}
