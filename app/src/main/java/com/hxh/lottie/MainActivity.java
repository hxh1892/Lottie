package com.hxh.lottie;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity
{
    private static final String LOGO = "lottie.json";
    private static final String NUMBER = "number.json";
    private static final String ANDROID = "android.json";
    private static final String CRANE = "crane.json";

    private String title = LOGO;

    private LottieAnimationView lav;
    private TextView tv_seek;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lav = findViewById(R.id.lav);
        Switch swi = findViewById(R.id.swi);
        tv_seek = findViewById(R.id.tv_seek);

        lav.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                int progress = (int) (animation.getAnimatedFraction() * 100);

                tv_seek.setText("动画进度:" + progress + "%");
            }
        });

        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    lav.loop(true);
                }
                else
                {
                    lav.loop(false);
                }
            }
        });

        setAnimation();
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        lav.cancelAnimation();
    }

    public void lottie(View v)
    {
        title = LOGO;

        setAnimation();

        lav.playAnimation();
    }

    public void number(View v)
    {
        title = NUMBER;

        setAnimation();

        lav.playAnimation();
    }

    public void android(View v)
    {
        title = ANDROID;

        setAnimation();

        lav.playAnimation();
    }

    public void crane(View v)
    {
        title = CRANE;

        setAnimation();

        lav.playAnimation();
    }

    public void start(View v)
    {
        if (!lav.isAnimating())
        {
            lav.setProgress(0f);
            lav.playAnimation();
        }
    }

    public void stop(View v)
    {
        if (lav.isAnimating())
        {
            lav.cancelAnimation();
        }
    }

    private void setAnimation()
    {
        lav.setImageAssetsFolder("lsj/");
        lav.setAnimation(title);

//        LottieComposition.fromAssetFileName(mContext, title, new LottieComposition.OnCompositionLoadedListener()
//        {
//            @Override
//            public void onCompositionLoaded(LottieComposition composition)
//            {
//                lav.setComposition(composition);
//                lav.setProgress(0f);
//            }
//        });
    }
}
