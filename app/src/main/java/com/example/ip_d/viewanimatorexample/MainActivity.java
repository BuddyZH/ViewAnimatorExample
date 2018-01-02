package com.example.ip_d.viewanimatorexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private ViewAnimator simpleViewAnimator;
    Button btnNext;
    // array of images
    int[] images = {R.drawable.lion, R.drawable.cat, R.drawable.dog, R.drawable.bird1, R.drawable.bird2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get The references of Button and ViewAnimator
        btnNext = (Button) findViewById(R.id.buttonNext);
        simpleViewAnimator = (ViewAnimator) findViewById(R.id.simpleViewAnimator); // get the reference of ViewAnimator
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(getApplicationContext()); // create a new object  for ImageView
            imageView.setImageResource(images[i]); // set image resource for ImageView
            simpleViewAnimator.addView(imageView); // add child view in ViewAnimator
        }
        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ViewAnimator
        simpleViewAnimator.setInAnimation(in);
        simpleViewAnimator.setOutAnimation(out);

        simpleViewAnimator.setAnimateFirstView(true); // set false value for setAnimateFirstView

        // ClickListener for NEXT button
        // When clicked on Button ViewSwitcher will switch between views
        // The current view will go out and next view will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                // show the next view of ViewAnimator `     `
                simpleViewAnimator.showNext();
            }
        });

    }

}


