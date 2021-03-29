package com.example.repository.RepositoryImplement;

import com.example.config.HibernateUtils;
import com.example.entity.Sanh;
import com.example.repository.SanhRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SanhRepositoryImp implements SanhRepository {

    private final Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public List getAllSanh() {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Sanh> query = criteriaBuilder.createQuery(Sanh.class);
            Root<Sanh> root = query.from(Sanh.class);
            query = query.select(root);
            Query q = session.createQuery(query);
            return q.getResultList();
    }

    @Override
    public Sanh createSanh(Sanh sanh) {
        if (sanh != null){
            session.beginTransaction();
            session.save(sanh);
            session.getTransaction().commit();
            return sanh;
        }
        else
            return null;
    }
}
