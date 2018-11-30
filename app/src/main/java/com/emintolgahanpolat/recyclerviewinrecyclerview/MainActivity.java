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

    private List<QuestionModel> questionList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createData();
        init();

        onClickListener();
    }

    private void onClickListener() {
        List<AnswerModel> answerModels = new ArrayList<AnswerModel>();
        btnGetCheckedItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String items = "";
                for (QuestionModel questionModel : questionList) {

                    for (AnswerModel answerModel : questionModel.getAnswers()) {
                        if (answerModel.isChecked()) {
                            items=items+"Soru : "+questionModel.getId();
                            items = items +" Cevap : "+ answerModel.getAnswer()+" \n";
                        }
                    }
                }
                txtCheckedItems.setText(items);
            }
        });
    }

    private RecyclerView recyclerViewQuestion;
    private Button btnGetCheckedItems;
    private TextView txtCheckedItems;

    private void init() {

        recyclerViewQuestion = (RecyclerView) findViewById(R.id.recyclerViewQuestion);
        btnGetCheckedItems = (Button) findViewById(R.id.btnGetCehckItems);
        txtCheckedItems = (TextView) findViewById(R.id.txtCheckedItems);


        recyclerViewQuestion.setHasFixedSize(true);
        QuestionRecyclerViewAdapter adapter = new QuestionRecyclerViewAdapter(this, questionList);
        recyclerViewQuestion.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewQuestion.setAdapter(adapter);
    }


    private void createData() {

        QuestionModel questionModel;
        AnswerModel answerModel;

        for (int i = 0; i < 5; i++) {
            List<AnswerModel> answerList = new ArrayList<>();
            answerList.clear();
            for (int j = 0; j < i + 1; j++) {
                answerModel = new AnswerModel(i + "answer" + j, false);
                answerList.add(answerModel);
            }


            questionModel = new QuestionModel("id"+i,"question"+i,answerList);

            questionList.add(questionModel);

        }
    }
}
