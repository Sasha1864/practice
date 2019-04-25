package org.communis.practice.repository;

import org.communis.practice.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnswerRepository extends JpaRepository<Answer, Long>, JpaSpecificationExecutor<Answer> {
    Answer findById(Long id);
}
