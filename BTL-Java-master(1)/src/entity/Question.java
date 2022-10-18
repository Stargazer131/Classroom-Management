package entity;

import java.util.HashMap;

import generic.Pair;

public class Question
{
    private String questionID,
                   questionTitle;

    private HashMap<String, Boolean> answerList;

    public Question(String QUESTION_ID,String QUESTION_TITLE, HashMap<String, Boolean> answerList)
    {
        this.questionID = QUESTION_ID;

        this.questionTitle = QUESTION_TITLE;

        this.answerList = answerList;
    }

    public boolean checkAnswer(String answerKey)
    {
        if(answerList.get(answerKey))
        {
            return true;
        }
        return false;
    }

    public String getID()
    {
        return this.questionID;
    }

    public String getQuestionTitle()
    {
        return this.questionTitle;
    }

    public HashMap<String, Boolean> getAnswerList()
    {
        return this.answerList;
    }
}
