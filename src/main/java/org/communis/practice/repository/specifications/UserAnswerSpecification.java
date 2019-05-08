package org.communis.practice.repository.specifications;

import org.communis.practice.entity.Answer;
import org.communis.practice.entity.UserAnswer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserAnswerSpecification  implements Specification<UserAnswer> {
    Long answerId;

    public UserAnswerSpecification(Long answerId) {
        this.answerId = answerId;
    }
    @Override
    public Predicate toPredicate(Root<UserAnswer> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
    {
        final List predicates = new ArrayList();
        predicates.add(cb.or(
                cb.equal(root.get("answer").get("id"), answerId)
        ));
        return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
    }
}