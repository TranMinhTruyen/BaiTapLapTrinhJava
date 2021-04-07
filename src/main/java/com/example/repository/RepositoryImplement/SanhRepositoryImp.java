package com.example.repository.RepositoryImplement;

import com.example.common.config.HibernateUtils;
import com.example.common.entity.Sanh;
import com.example.repository.SanhRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SanhRepositoryImp implements SanhRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllSanh() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Sanh> query = criteriaBuilder.createQuery(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query = query.select(root);
        List result = session.createQuery(query).getResultList();
        return result;
    }

    @Override
    public List getSanhByKeyWord(String keyword) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Sanh> query = criteriaBuilder.createQuery(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.select(root);

        if (keyword != null){
            Predicate p1 = criteriaBuilder.like(root.get("ten").as(String.class),keyword);
            Predicate p2 = criteriaBuilder.equal(root.get("id").as(String.class),keyword);
            query.where(criteriaBuilder.or(p1,p2));
            List result = session.createQuery(query).getResultList();
            session.close();
            return result;
        }
        else
            return getAllSanh();
    }

    @Override
    public Sanh createSanh(Sanh sanh) {
        Session session = this.sessionFactory.getCurrentSession();
        if (sanh != null){
            session.beginTransaction();
            session.save(sanh);
            session.getTransaction().commit();
            return sanh;
        }
        else
            return null;
    }

    @Override
    public void updateSanh(int id, Sanh sanh) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Sanh> query = criteriaBuilder.createCriteriaUpdate(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.set("ten",sanh.getTen());
        query.set("tongSoBan",sanh.getTongSoBan());
        query.set("giaTien",sanh.getGiaTien());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
    }

    @Override
    public Sanh getSanhById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Sanh> query = criteriaBuilder.createQuery(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        return session.createQuery(query).uniqueResult();
    }

    @Override
    public void deleteSanhById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Sanh> query = criteriaBuilder.createCriteriaDelete(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
    }


}
