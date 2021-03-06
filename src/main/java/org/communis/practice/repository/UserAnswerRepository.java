package org.communis.practice.repository;

import org.communis.practice.entity.Answer;
import org.communis.practice.entity.Message;
import org.communis.practice.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long>, JpaSpecificationExecutor<UserAnswer> {
    UserAnswer findById(Long id);
    List<UserAnswer> findAllUserAnswersByAnswer(Answer answer);
}
