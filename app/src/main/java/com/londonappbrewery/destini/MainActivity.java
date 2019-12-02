package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyText;
    Button optionOneButton,optionTwoButton;
    Story currentStory ;
    Story[] storyArray =
            {
                    new Story(1, R.string.T1_Story, R.string.T1_Ans1,R.string.T1_Ans2,1,2),
                    new Story(2, R.string.T2_Story, R.string.T2_Ans1,R.string.T2_Ans2,2,3),
                    new Story(3, R.string.T3_Story, R.string.T3_Ans1,R.string.T3_Ans2,3,3),
                    new Story(4, R.string.T4_Story, R.string.T4_Ans1,R.string.T4_Ans2,0,1),

            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
        {
            Log.d("Main","savedInstanceState not null");
            this.currentStory = (Story) savedInstanceState.getSerializable("currentObject");

        }else
            {
                this.currentStory = storyArray[0];
            }



        storyText = findViewById(R.id.storyTextView);
        optionOneButton = findViewById(R.id.buttonTop);
        optionTwoButton = findViewById(R.id.buttonBottom);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        optionOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentStory = storyArray[currentStory.getNextQuestionNumber1()];
                updateUI();


            }
        });

        optionTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Main","Second Button");
                currentStory = storyArray[currentStory.getNextQuestionNumber2()];
                updateUI();
            }
        });


        updateUI();
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }
    public void updateUI()
    {
        storyText.setText(currentStory.getQuestionText());
        optionOneButton.setText(currentStory.getOption1());
        optionTwoButton.setText(currentStory.getOption2());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("currentObject",this.currentStory);
    }
}
