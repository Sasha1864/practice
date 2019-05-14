package org.communis.practice.controller.rest;

import org.communis.practice.dto.AnswerWrapper;
import org.communis.practice.dto.QuestionWrapper;
import org.communis.practice.entity.Answer;
import org.communis.practice.entity.Question;
import org.communis.practice.entity.UserAnswer;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionRestController {

    @Autowired
    private final QuestionService questionService;

    @Autowired
    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("questions/add")
    public Long add(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return questionService.add(questionWrapper);
    }
    @PostMapping("answers/add")
    public Long addAnswer(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return questionService.addAnswer(answerWrapper);
    }
    @PutMapping("answers/edit")
    public void edit(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.editAnswer(answerWrapper);
    }
    @PostMapping("answers/delete")
    public void deleteAnswer(Long id) throws ServerException {
        questionService.deleteAnswer(id);
    }

    @PutMapping("/edit")
    public void edit(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.edit(questionWrapper);
    }

    @GetMapping("{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getById(id);
    }

    @GetMapping("")
    public List<Question> findAllQuestions(){
        return questionService.findAllQuestions();
    }

    @GetMapping("userAnswers")
    public List<UserAnswer> findAllUserAnswers(){
        return questionService.findAllUserAnswers();
    }

    @GetMapping("country/{countryId}")
    public List<Question> getQuestionsByCountryId(@PathVariable Long countryId) throws ServerException {
        return questionService.getQuestionsByCountryId(countryId);
    }
    @GetMapping("answers/userAnswers/")
    public List<UserAnswer> getUserAnswersByAnswer(Long answerId) throws ServerException {
        return questionService.findAllUserAnswersByAnswer(answerId);
    }

    @GetMapping("answers/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) throws ServerException {
        List<Answer> answers = questionService.getAnswersByQuestionId(questionId);
        return answers;
    }

    @PostMapping("save/{userId}/{answerId}")
    public void addUserAnswer(@PathVariable Long userId, @PathVariable Long answerId) {
        questionService.addUserAnswer(userId, answerId);
    }
}
