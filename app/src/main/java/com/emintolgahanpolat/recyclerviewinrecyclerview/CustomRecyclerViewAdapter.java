package com.emintolgahanpolat.recyclerviewinrecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_QUESTION = 1, TYPE_ANSWER = 2;

    private List<Object> objectList;
    private Context context;

    public CustomRecyclerViewAdapter(Context context, List<Object> objectList) {
        this.context = context;
        this.objectList = objectList;
    }



    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof QuestionModel) {
            return TYPE_QUESTION;
        }
        else if (objectList.get(position) instanceof AnswerModel) {
            return TYPE_ANSWER;
        }

        return -1;
    }





    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case TYPE_QUESTION:
                QuestionModel questionModel = (QuestionModel) objectList.get(position);
                ((QuestionViewHolder) holder).showQuestionDetails(questionModel);
                break;
            case TYPE_ANSWER:
                AnswerModel answerModel = (AnswerModel) objectList.get(position);
                ((AnswerViewHolder) holder).showAnswerDetails(answerModel);

                break;
        }
    }

    @Override
    public int getItemCount() {
        return objectList == null ? 0 : objectList.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layout = 0;
        final RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case TYPE_QUESTION:
                layout = R.layout.list_item_question;
                View booksView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new QuestionViewHolder(booksView);

                break;
            case TYPE_ANSWER:
                layout = R.layout.list_item_answer;
                View answerView = LayoutInflater
                        .from(parent.getContext())
                        .inflate(layout, parent, false);
                viewHolder = new AnswerViewHolder(answerView);
                break;
            default:
                viewHolder = null;
                break;
        }


        return viewHolder;
    }



    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView txtQuestion;
        private RecyclerView answerRecyclerView;
        CustomRecyclerViewAdapter customRecyclerViewAdapter;
        public QuestionViewHolder(View view) {
            super(view);
            txtQuestion = view.findViewById(R.id.txtQuestion);
            answerRecyclerView = view.findViewById(R.id.answerRecyclerView);

        }

        public void showQuestionDetails(QuestionModel questionModel) {


            txtQuestion.setText(questionModel.getQuestion());


            answerRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            answerRecyclerView.setHasFixedSize(true);

            customRecyclerViewAdapter = new CustomRecyclerViewAdapter(context,questionModel.getAnswers());
            customRecyclerViewAdapter.notifyDataSetChanged();
            answerRecyclerView.setAdapter(customRecyclerViewAdapter);




        }
    }


    public class AnswerViewHolder extends RecyclerView.ViewHolder {

        private CheckBox cbAnswer;
        public AnswerViewHolder(View view) {
            super(view);

            cbAnswer = view.findViewById(R.id.cbAnswer);
        }

        public void showAnswerDetails(final AnswerModel answerModel) {
            cbAnswer.setText(answerModel.getAnswer());
            cbAnswer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
    }



}
