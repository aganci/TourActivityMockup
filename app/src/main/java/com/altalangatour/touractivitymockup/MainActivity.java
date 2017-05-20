package com.altalangatour.touractivitymockup;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private Guideline guideline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (ConstraintLayout) findViewById(R.id.constraint_layout);
        createGuideline();
        createImageView();
    }

    private void createGuideline() {
        guideline = new Guideline(this);
        guideline.setId(View.generateViewId());
        layout.addView(guideline);

        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        guideline.setLayoutParams(layoutParams);

        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        set.create(guideline.getId(), ConstraintSet.VERTICAL);
        set.setGuidelinePercent(guideline.getId(), 0.5f);
        set.applyTo(layout);
    }

    private void createImageView() {
        ImageView imageView = new ImageView(this);
        imageView.setId(View.generateViewId());
        layout.addView(imageView);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.langhet);
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));

        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        set.connect(imageView.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT, 0);
        set.connect(imageView.getId(), ConstraintSet.RIGHT, guideline.getId(), ConstraintSet.LEFT, 0);
        set.connect(imageView.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, 0);
        set.setDimensionRatio(imageView.getId(), "h,1:1");
        set.applyTo(layout);
    }
}
