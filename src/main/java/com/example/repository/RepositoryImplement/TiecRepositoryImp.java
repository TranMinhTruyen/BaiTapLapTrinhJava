package com.example.repository.RepositoryImplement;

import com.example.common.config.HibernateUtils;
import com.example.common.entity.Sanh;
import com.example.common.entity.Tiec;
import com.example.repository.TiecRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TiecRepositoryImp implements TiecRepository {

    private final Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public List getAllTiec() {
        return null;
    }

    @Override
    public Tiec getTiecbyId(int id) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tiec> query = criteriaBuilder.createQuery(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        Tiec result = session.createQuery(query).uniqueResult();
        return result;
    }
}
