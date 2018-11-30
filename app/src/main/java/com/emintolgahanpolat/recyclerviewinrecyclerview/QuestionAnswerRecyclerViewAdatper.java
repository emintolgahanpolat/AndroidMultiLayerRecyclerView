package com.emintolgahanpolat.recyclerviewinrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.List;

public class QuestionAnswerRecyclerViewAdatper extends RecyclerView.Adapter<QuestionAnswerRecyclerViewAdatper.MyViewHolder> {

    private List<AnswerModel> listAnswer;
    private Context context;

    public QuestionAnswerRecyclerViewAdatper(Context context, List<AnswerModel> listAnswer) {
        this.context = context;
        this.listAnswer = listAnswer;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox cbAnswer;

        public MyViewHolder(@NonNull View view) {
            super(view);

            cbAnswer = view.findViewById(R.id.cbAnswer);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_answer, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAnswerRecyclerViewAdatper.MyViewHolder myViewHolder, int position) {
        final AnswerModel answerModel = listAnswer.get(position);
        myViewHolder.cbAnswer.setText(answerModel.getAnswer());
        myViewHolder.cbAnswer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    answerModel.setChecked(true);
                } else {
                    answerModel.setChecked(false);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listAnswer.size();
    }


}
