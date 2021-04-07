package com.example.repository.RepositoryImplement;

import com.example.common.config.HibernateUtils;
import com.example.common.entity.ThucAn;
import com.example.common.entity.Tiec;
import com.example.repository.ThucAnRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class ThucAnRepositoryImp implements ThucAnRepository {

    private final Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public ThucAn getThucAnById(int id) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ThucAn> query = criteriaBuilder.createQuery(ThucAn.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        return session.createQuery(query).uniqueResult();
    }
}
