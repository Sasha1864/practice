package org.communis.practice.repository.specifications;

import lombok.Data;
import org.communis.practice.entity.Question;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class QuestionSpecification implements Specification<Question> {

    private Long idCountry;
    public QuestionSpecification(Long id) {
        this.idCountry = id;
    }
    @Override
    public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
    {
        final List predicates = new ArrayList();
        predicates.add(cb.equal(root.get("country").get("id"), idCountry));
        return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
    }
}
