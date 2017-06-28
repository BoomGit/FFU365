package com.boom.ffu365.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boom.ffu365.R;
import com.boom.ffu365.UserLoginActivity;

/**
 * Created by Boom on 2017/6/21.
 */

public class CenterFragment extends Fragment implements View.OnClickListener {
    View mRootView;
    TextView user_login_tv;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.fragment_center,null);
        mContext=getActivity();
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        user_login_tv = (TextView) mRootView.findViewById(R.id.user_login_tv);
        user_login_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(mContext,UserLoginActivity.class);
    }
}
