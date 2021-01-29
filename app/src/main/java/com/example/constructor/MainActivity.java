package com.example.constructor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private View toolBox;
    private ImageView roofWindow;
    private ImageView door;

    private View secondStage;
    private View thirdStage;
    private View fourthStage;
    private View fifthStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBox = findViewById(R.id.toolbox);

        CheckBox checkBox = findViewById(R.id.roof_window_checkbox);
        roofWindow = findViewById(R.id.roof_window);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                roofWindow.setVisibility(isChecked ? View.VISIBLE: View.GONE);
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radio_group_door_orientation);
        door = findViewById(R.id.door);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_door_left){
                    door.setImageResource(R.drawable.door_left); }
                else{  door.setImageResource(R.drawable.door); }
            }
        });

        EditText editText = findViewById(R.id.stage_num);
        secondStage = findViewById(R.id.second_stage);
        thirdStage = findViewById(R.id.third_stage);
        fourthStage = findViewById(R.id.fourth_stage);
        fifthStage = findViewById(R.id.fifth_stage);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int numStage = 0;
                if (s.toString() != null && !s.toString().isEmpty()){
                    numStage = Integer.parseInt(s.toString());
                }
                switch (numStage){
                    case 1:
                        secondStage.setVisibility(View.GONE);
                        thirdStage.setVisibility(View.GONE);
                        fourthStage.setVisibility(View.GONE);
                        fifthStage.setVisibility(View.GONE);
                        break;
                    case 2:
                        secondStage.setVisibility(View.VISIBLE);
                        thirdStage.setVisibility(View.GONE);
                        fourthStage.setVisibility(View.GONE);
                        fifthStage.setVisibility(View.GONE);
                        break;
                    case 3:
                        secondStage.setVisibility(View.VISIBLE);
                        thirdStage.setVisibility(View.VISIBLE);
                        fourthStage.setVisibility(View.GONE);
                        fifthStage.setVisibility(View.GONE);
                        break;
                    case 4:
                        secondStage.setVisibility(View.VISIBLE);
                        thirdStage.setVisibility(View.VISIBLE);
                        fourthStage.setVisibility(View.VISIBLE);
                        fifthStage.setVisibility(View.GONE);
                        break;
                    case 5:
                        secondStage.setVisibility(View.VISIBLE);
                        thirdStage.setVisibility(View.VISIBLE);
                        fourthStage.setVisibility(View.VISIBLE);
                        fifthStage.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

    }

    public void showSettings(View v){
        if (toolBox.getVisibility() == View.GONE)
            toolBox.setVisibility(View.VISIBLE);
        else
            toolBox.setVisibility(View.GONE);
    }


    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}