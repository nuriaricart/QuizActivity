package edu.upc.eseiaat.pma.quiz;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers [] = {R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_question = (TextView) findViewById(R.id.text_question);
        text_question.setText(R.string.question_content);

        final String[] answers = getResources().getStringArray(R.array.answers);

        for (int i=0; i<ids_answers.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_answers [i]);
            rb.setText(answers [i]);
        }

        Button btn_check = (Button) findViewById(R.id.btn_check);
        final int correct_answer = getResources().getInteger(R.integer.correct_answer);
        final RadioGroup group =(RadioGroup) findViewById(R.id.group_answers);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.i ("nuria","funciona");

                int id = group.getCheckedRadioButtonId();
                int answer = -1;

                for (int i=0; i<ids_answers.length; i++){
                    if (id == ids_answers [i])
                        answer = i;
                }

                if (answer == correct_answer){
                    Toast.makeText(QuizActivity.this,R.string.correct, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this,R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
