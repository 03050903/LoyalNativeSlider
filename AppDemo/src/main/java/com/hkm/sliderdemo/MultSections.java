package com.hkm.sliderdemo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hkm.slider.Animations.DescriptionAnimation;
import com.hkm.slider.SliderLayout;
import com.hkm.slider.SliderTypes.BaseSliderView;
import com.hkm.slider.SliderTypes.CompactFrameSliderView;
import com.hkm.slider.SliderTypes.CompactSliderView;
import com.hkm.slider.SliderTypes.TextSliderView;
import com.hkm.slider.TransformerL;
import com.hkm.sliderdemo.Util.DataProvider;
import com.hkm.sliderdemo.modules.NumZero;
import com.hkm.sliderdemo.modules.TransformerAdapter;

import java.util.HashMap;

/**
 * Created by hesk on 24/11/15.
 */
public class MultSections extends BaseApp {

    @SuppressLint("ResourceAsColor")
    protected void setupSlider() {
        // remember setup first
        mDemoSlider.setPresetTransformer(TransformerL.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.setOffscreenPageLimit(3);
        mDemoSlider.setSliderTransformDuration(400, new LinearOutSlowInInterpolator());
        mDemoSlider.getPagerIndicator().setDefaultIndicatorColor(R.color.red_pink_24, R.color.red_pink_26);
        final NumZero n = new NumZero(this);
        mDemoSlider.setNumLayout(n);
        mDemoSlider.presentation(SliderLayout.PresentationConfig.Numbers);
        ListView l = (ListView) findViewById(R.id.transformers);
        l.setAdapter(new TransformerAdapter(this));
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());

            }
        });
        //and data second. it is a must because you will except the data to be streamed into the pipline.
        defaultCompleteSlider(DataProvider.getFileSrcHorizontal());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void defaultCompleteSlider(final HashMap<String, Integer> maps) {
        TextSliderView s1 = new TextSliderView(this);
        // initialize a SliderLayout
        s1
                .description(getString(R.string.head_line_01))
                .image(getString(R.string.hl_image_01))
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .enableSaveImageByLongClick(getFragmentManager())
                .enableImageLocalStorage()
                .setOnSliderClickListener(this);
        //add your extra information
        // textSliderView.getBundle().putString("extra", name);
        mDemoSlider.addSlider(s1);


        try {
            CompactSliderView s2 = new CompactSliderView(this, 2);
            s2

                    .setDisplayOnlyImageUrls(new String[]{
                            getString(R.string.hl_image_02),
                            getString(R.string.hl_image_03)
                    })


                            // initialize a SliderLayout

                    .description(getString(R.string.head_line_02))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .enableImageLocalStorage()
                    .setOnSliderClickListener(this);

            mDemoSlider.addSlider(s2.build());


            CompactSliderView s3 = new CompactSliderView(this, 3);
            s3

                    .setDisplayOnlyImageUrls(new String[]{
                            getString(R.string.hl_image_03),
                            getString(R.string.hl_image_04),
                            getString(R.string.hl_image_05)
                    })


                            // initialize a SliderLayout

                    .description(getString(R.string.head_line_02))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .enableImageLocalStorage()
                    .setOnSliderClickListener(this);

            mDemoSlider.addSlider(s3.build());


            CompactSliderView s4 = new CompactSliderView(this, 4);
            s4

                    .setDisplayOnlyImageUrls(new String[]{
                            getString(R.string.hl_image_03),
                            getString(R.string.hl_image_07),
                            getString(R.string.hl_image_05),
                            getString(R.string.hl_image_01)
                    })


                            // initialize a SliderLayout

                    .description(getString(R.string.head_line_02))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .enableImageLocalStorage()
                    .setOnSliderClickListener(this);

            mDemoSlider.addSlider(s4.build());



            CompactFrameSliderView s5 = new CompactFrameSliderView(this, 4);
            s5

                    .setDescriptions(new String[]{
                            getString(R.string.head_line_03),
                            getString(R.string.head_line_07),
                            getString(R.string.head_line_05),
                            getString(R.string.head_line_01)

                    })
                            // initialize a SliderLayout

                    .setDisplayOnlyImageUrls(new String[]{
                            getString(R.string.hl_image_03),
                            getString(R.string.hl_image_07),
                            getString(R.string.hl_image_05),
                            getString(R.string.hl_image_01)
                    })

                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .enableImageLocalStorage()
                    .setOnSliderClickListener(this);

            mDemoSlider.addSlider(s5.build());



            CompactFrameSliderView s6 = new CompactFrameSliderView(this, 2);
            s6

                    .setDescriptions(new String[]{
                            getString(R.string.head_line_03),
                            getString(R.string.head_line_07)

                    })
                            //  .setSlideLayoutCustom(CompactFrameSliderView.RIPPLE_SLIDE)
                            // initialize a SliderLayout

                    .setDisplayOnlyImageUrls(new String[]{
                            getString(R.string.hl_image_03),
                            getString(R.string.hl_image_07)
                    })


                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .enableImageLocalStorage()
                    .setOnSliderClickListener(this);
            mDemoSlider.addSlider(s6.build());


            CompactFrameSliderView s7 = new CompactFrameSliderView(this, 2);
            s7

                    .setDescriptions(new String[]{
                            getString(R.string.head_line_08),
                            getString(R.string.head_line_06)

                    })
                    .setSlideLayoutCustom(CompactFrameSliderView.RIPPLE_SLIDE)
                            // initialize a SliderLayout

                    .setDisplayOnlyImageUrls(new String[]{
                            getString(R.string.hl_image_08),
                            getString(R.string.hl_image_06)
                    })


                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .enableSaveImageByLongClick(getFragmentManager())
                    .enableImageLocalStorage()
                    .setOnSliderClickListener(this);

            mDemoSlider.addSlider(s7.build());


        } catch (Exception e) {
            Toast.makeText(
                    this,
                    e.getMessage(),
                    Toast.LENGTH_SHORT)
                    .show();
        }

    }


    @Override
    public void onSliderClick(BaseSliderView coreSlider) {

    }
}