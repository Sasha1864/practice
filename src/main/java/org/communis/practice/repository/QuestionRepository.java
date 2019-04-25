package org.communis.practice.repository;

import org.communis.practice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long>, JpaSpecificationExecutor<Question>
{
    Optional<Question> findFirstByQuestion(String question);
    Question findById(Long id);
}