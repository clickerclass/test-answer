package com.clickerclass.testanswers.mapper;

import com.clickerclass.testanswers.entity.Answer;
import com.clickerclass.testanswers.entity.Question;
import com.clickerclass.testanswers.entity.TestAnswer;
import com.clickerclass.testanswers.model.AnswerModel;
import com.clickerclass.testanswers.model.QuestionModel;
import com.clickerclass.testanswers.model.TestAnswerModel;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-11T09:55:52-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class TestAnswerMapperImpl implements TestAnswerMapper {

    @Override
    public TestAnswerModel toModel(TestAnswer testAnswer) {
        if ( testAnswer == null ) {
            return null;
        }

        TestAnswerModel testAnswerModel = new TestAnswerModel();

        testAnswerModel.setId( testAnswer.getId() );
        testAnswerModel.setName( testAnswer.getName() );
        testAnswerModel.setCreationDate( testAnswer.getCreationDate() );
        testAnswerModel.setClientId( testAnswer.getClientId() );
        testAnswerModel.setCourseId( testAnswer.getCourseId() );
        testAnswerModel.setTestId( testAnswer.getTestId() );
        testAnswerModel.setQuestionsTests( questionSetToQuestionModelSet( testAnswer.getQuestionsTests() ) );
        testAnswerModel.setResults( testAnswer.getResults() );

        return testAnswerModel;
    }

    @Override
    public TestAnswer toEntity(TestAnswerModel testAnswerModel) {
        if ( testAnswerModel == null ) {
            return null;
        }

        TestAnswer testAnswer = new TestAnswer();

        testAnswer.setId( testAnswerModel.getId() );
        testAnswer.setName( testAnswerModel.getName() );
        testAnswer.setCreationDate( testAnswerModel.getCreationDate() );
        testAnswer.setClientId( testAnswerModel.getClientId() );
        testAnswer.setCourseId( testAnswerModel.getCourseId() );
        testAnswer.setTestId( testAnswerModel.getTestId() );
        testAnswer.setQuestionsTests( questionModelSetToQuestionSet( testAnswerModel.getQuestionsTests() ) );
        testAnswer.setResults( testAnswerModel.getResults() );

        return testAnswer;
    }

    protected AnswerModel answerToAnswerModel(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerModel answerModel = new AnswerModel();

        answerModel.setId( answer.getId() );
        answerModel.setDescription( answer.getDescription() );
        answerModel.setTrueOption( answer.isTrueOption() );

        return answerModel;
    }

    protected Set<AnswerModel> answerSetToAnswerModelSet(Set<Answer> set) {
        if ( set == null ) {
            return null;
        }

        Set<AnswerModel> set1 = new HashSet<AnswerModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Answer answer : set ) {
            set1.add( answerToAnswerModel( answer ) );
        }

        return set1;
    }

    protected QuestionModel questionToQuestionModel(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionModel questionModel = new QuestionModel();

        questionModel.setId( question.getId() );
        questionModel.setDescription( question.getDescription() );
        questionModel.setAnswers( answerSetToAnswerModelSet( question.getAnswers() ) );

        return questionModel;
    }

    protected Set<QuestionModel> questionSetToQuestionModelSet(Set<Question> set) {
        if ( set == null ) {
            return null;
        }

        Set<QuestionModel> set1 = new HashSet<QuestionModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Question question : set ) {
            set1.add( questionToQuestionModel( question ) );
        }

        return set1;
    }

    protected Answer answerModelToAnswer(AnswerModel answerModel) {
        if ( answerModel == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setId( answerModel.getId() );
        answer.setDescription( answerModel.getDescription() );
        if ( answerModel.getTrueOption() != null ) {
            answer.setTrueOption( answerModel.getTrueOption() );
        }

        return answer;
    }

    protected Set<Answer> answerModelSetToAnswerSet(Set<AnswerModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<Answer> set1 = new HashSet<Answer>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AnswerModel answerModel : set ) {
            set1.add( answerModelToAnswer( answerModel ) );
        }

        return set1;
    }

    protected Question questionModelToQuestion(QuestionModel questionModel) {
        if ( questionModel == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( questionModel.getId() );
        question.setDescription( questionModel.getDescription() );
        question.setAnswers( answerModelSetToAnswerSet( questionModel.getAnswers() ) );

        return question;
    }

    protected Set<Question> questionModelSetToQuestionSet(Set<QuestionModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<Question> set1 = new HashSet<Question>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( QuestionModel questionModel : set ) {
            set1.add( questionModelToQuestion( questionModel ) );
        }

        return set1;
    }
}
