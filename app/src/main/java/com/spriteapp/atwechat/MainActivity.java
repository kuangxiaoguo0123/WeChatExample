package com.spriteapp.atwechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.spriteapp.atwechat.fragment.ChatFragment;
import com.spriteapp.atwechat.fragment.ContactFragment;
import com.spriteapp.atwechat.fragment.DiscoverFragment;
import com.spriteapp.atwechat.fragment.MeFragment;
import com.spriteapp.atwechat.wediget.BottomLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ChatFragment mChatFragment;
    private ContactFragment mContactFragment;
    private DiscoverFragment mDiscoverFragment;
    private MeFragment mMeFragment;
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private BottomLayout mChatLayout;
    private BottomLayout mContactLayout;
    private BottomLayout mDiscoverLayout;
    private BottomLayout mMeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        initFragment();
        initList();
        setPagerAdapter();
        mChatLayout.setSelectState();
        setViewPagerListener();
    }

    private void setViewPagerListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setBottomState(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setPagerAdapter() {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    private void initId() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mChatLayout = (BottomLayout) findViewById(R.id.chat_layout);
        mContactLayout = (BottomLayout) findViewById(R.id.contact_layout);
        mDiscoverLayout = (BottomLayout) findViewById(R.id.discover_layout);
        mMeLayout = (BottomLayout) findViewById(R.id.me_layout);

        mChatLayout.setOnClickListener(this);
        mContactLayout.setOnClickListener(this);
        mDiscoverLayout.setOnClickListener(this);
        mMeLayout.setOnClickListener(this);
    }

    private void initList() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(mChatFragment);
        mFragmentList.add(mContactFragment);
        mFragmentList.add(mDiscoverFragment);
        mFragmentList.add(mMeFragment);
    }

    private void initFragment() {
        mChatFragment = new ChatFragment();
        mContactFragment = new ContactFragment();
        mDiscoverFragment = new DiscoverFragment();
        mMeFragment = new MeFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chat_layout:
                setBottomState(0);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.contact_layout:
                setBottomState(1);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.discover_layout:
                setBottomState(2);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.me_layout:
                setBottomState(3);
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    private void setBottomState(int position) {
        switch (position) {
            case 0:
                mChatLayout.setSelectState();
                mContactLayout.setUnSelectState();
                mDiscoverLayout.setUnSelectState();
                mMeLayout.setUnSelectState();
                break;
            case 1:
                mChatLayout.setUnSelectState();
                mContactLayout.setSelectState();
                mDiscoverLayout.setUnSelectState();
                mMeLayout.setUnSelectState();
                break;
            case 2:
                mChatLayout.setUnSelectState();
                mContactLayout.setUnSelectState();
                mDiscoverLayout.setSelectState();
                mMeLayout.setUnSelectState();
                break;
            case 3:
                mChatLayout.setUnSelectState();
                mContactLayout.setUnSelectState();
                mDiscoverLayout.setUnSelectState();
                mMeLayout.setSelectState();
                break;
            default:
                break;
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
