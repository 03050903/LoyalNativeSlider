package com.hkm.loyalns.demos;

import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;

import com.hkm.loyalns.R;
import com.hkm.loyalns.mod.BaseApp;
import com.hkm.slider.Animations.DescriptionAnimation;
import com.hkm.slider.SliderLayout;
import com.hkm.slider.SliderTypes.AdjustableSlide;
import com.hkm.slider.SliderTypes.BaseSliderView;
import com.hkm.slider.TransformerL;

import java.util.ArrayList;

/**
 * Created by hesk on 15/4/16.
 */
public class SliderAdjust1 extends BaseApp {
    @Override
    protected void setupSlider() {
        mDemoSlider.setPresetTransformer(TransformerL.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.setOffscreenPageLimit(3);
        mDemoSlider.setSliderTransformDuration(400, new LinearOutSlowInInterpolator());
        mDemoSlider.getPagerIndicator().setDefaultIndicatorColorRes(R.color.red_pink_26, R.color.red_pink_27);
        mDemoSlider.setAutoAdjustImageByHeight();
        String[] urls = {
                //   "http://pcdn.500px.net/35939982/127d53ceac436e2e17a11ea42bb2cd7719b9f1e1/4.jpg",
                "https://drscdn.500px.org/photo/149207821/m%3D900/61196063c2685f6c3461bbc8568b3a2e",
                //    special url with error
                "https://drscdn.500px.org/photo/144545025/m%3D900/aa1681951f730749a27dc1aec604ca4f",
                "https://drscdn.500px.org/photo/138365879/m%3D900/a349013757f0766bccd3024e237c3601",
                "https://c3.staticflickr.com/2/1515/26325284906_92b7a12363_n.jpg"
        };

        ArrayList<AdjustableSlide> list = new ArrayList<>();
        for (int h = 0; h < urls.length; h++) {
            AdjustableSlide textSliderView = new AdjustableSlide(this);
            // initialize a SliderLayout
            textSliderView
                    .image(urls[h])
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .setOnSliderClickListener(this);
            //add your extra information
            list.add(textSliderView);
        }
        mFrameMain.setVisibility(View.VISIBLE);
        mDemoSlider.loadSliderList(list);

    }

    @Override
    protected int getActivityMainLayoutId() {
        return R.layout.bouncer_slider;
    }

    @Override
    public void onSliderClick(BaseSliderView coreSlider) {

    }
}
