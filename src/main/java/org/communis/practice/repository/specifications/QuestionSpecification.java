package org.communis.practice.repository.specifications;

import lombok.Data;
import org.communis.practice.dto.filters.QuestionFilterWrapper;
import org.communis.practice.dto.filters.UserFilterWrapper;
import org.communis.practice.entity.Country;
import org.communis.practice.entity.Question;
import org.communis.practice.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionSpecification implements Specification<Question> {

    private Long id;
    public QuestionSpecification(Long id) {
        this.id = id;
    }
    @Override
    public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> cq, CriteriaBuilder cb)
    {
        final List predicates = new ArrayList();
        predicates.add(cb.or(
                cb.equal(root.get("country").get("id"), id)
        ));
        return cb.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
    }
}
