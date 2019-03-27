package com.emintolgahanpolat.recyclerviewinrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Object> questionList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createData();
        init();
        clickListener();

    }

    private void clickListener() {
        btnGetCheckedItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String items = "";
                for (Object questionModel : questionList) {
                    QuestionModel a=(QuestionModel) questionModel;
                    for (Object answerModel :  a.getAnswers()) {
                        AnswerModel b=(AnswerModel) answerModel;
                        if (b.isChecked()) {
                            items=items+"Question  : "+a.getId();
                            items = items +" | Answer  : "+ b.getAnswer()+" \n";
                        }
                    }
                }
                txtCheckedItems.setText(items);
            }
        });
    }


    private RecyclerView recyclerView;
    private Button btnGetCheckedItems;
    private TextView txtCheckedItems;
    private CustomRecyclerViewAdapter customRecyclerViewAdapter;

    private void init() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewQuestion);
        btnGetCheckedItems = (Button) findViewById(R.id.btnGetCehckItems);
        txtCheckedItems = (TextView) findViewById(R.id.txtCheckedItems);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        customRecyclerViewAdapter = new CustomRecyclerViewAdapter(this,questionList);
        customRecyclerViewAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(customRecyclerViewAdapter);


    }


    private void createData() {


        for (int i = 0; i < 15; i++) {
            List<Object> answerList = new ArrayList<>();
            answerList.clear();
            for (int j = 0; j < i + 1; j++) {
                answerList.add(new AnswerModel(i + ". question " + j+". answer", false));
            }



            questionList.add(new QuestionModel("Id : " + i, "Question : " + i, answerList));

        }
    }
}
