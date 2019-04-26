package org.communis.practice.repository.specifications;

import org.communis.practice.entity.Answer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AnswerSpecification  implements Specification<Answer> {
    Long idQuestion;

    public AnswerSpecification(Long idQuestion) {
        this.idQuestion = idQuestion;
    }
    @Override
    public Predicate toPredicate(Root<Answer> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
    {
        final List predicates = new ArrayList();
        predicates.add(cb.or(
                cb.equal(root.get("question").get("id"), idQuestion)
        ));
        return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
    }
}
