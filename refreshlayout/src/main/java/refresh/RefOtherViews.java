package refresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import com.wh.reflayout.R;

import refresh.interfaces.RefOtherViewListener;

/**
 * Created by wanghao on 2017/9/26.
 */

public class RefOtherViews implements RefOtherViewListener {


    private Context mContext;

    public RefOtherViews(Context context) {
        mContext = context;
    }

    @Override
    public View geErrorView(RefreshLayout root) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ptr_error_view, root, false);
        return view;
    }

    @Override
    public View geEmptyView(RefreshLayout root) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ptr_empty_view, root, false);
        return view;
    }
}
