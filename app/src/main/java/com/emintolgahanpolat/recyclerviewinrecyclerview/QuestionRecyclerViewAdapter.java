package com.emintolgahanpolat.recyclerviewinrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionRecyclerViewAdapter.MyViewHolder> {

    private List<QuestionModel> listQuestion;
    Context context;

    public QuestionRecyclerViewAdapter(Context context, List<QuestionModel> listQuestion) {
        this.listQuestion = listQuestion;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtQuestion;
        private RecyclerView answerListView;

        public MyViewHolder(@NonNull View view) {
            super(view);
            txtQuestion = view.findViewById(R.id.txtQuestion);
            answerListView = view.findViewById(R.id.answerRecyclerView);






        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_question, viewGroup, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        QuestionModel questionModel = listQuestion.get(position);
        myViewHolder.txtQuestion.setText(questionModel.getQuestion());

        myViewHolder.answerListView.setHasFixedSize(true);
        QuestionAnswerRecyclerViewAdatper adapter = new QuestionAnswerRecyclerViewAdatper(context, questionModel.getAnswers());
        myViewHolder.answerListView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        myViewHolder.answerListView.setAdapter(adapter);




    }

    @Override
    public int getItemCount() {
        return listQuestion.size();
    }


}
