package com.example.repository.RepositoryImplement;

import com.example.comon.config.HibernateUtils;
import com.example.comon.entity.Sanh;
import com.example.repository.SanhRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class SanhRepositoryImp implements SanhRepository {

    @Override
    public List getAllSanh() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Sanh> query = criteriaBuilder.createQuery(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query = query.select(root);
        List result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }

    @Override
    public List getSanhByKeyWord(String keyword) {
        Session session = HibernateUtils.getSessionFactory().openSession();
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
        Session session = HibernateUtils.getSessionFactory().openSession();
        if (sanh != null){
            session.beginTransaction();
            session.save(sanh);
            session.getTransaction().commit();
            session.close();
            return sanh;
        }
        else
            return null;
    }

    @Override
    public Sanh updateSanh(int id, Sanh sanh) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Sanh> query = criteriaBuilder.createCriteriaUpdate(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.set("ten",sanh.getTen());
        query.set("soChoNgoi",sanh.getGiaTien());
        query.set("giaTien",sanh.getSoChoNgoi());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
        session.close();
        return sanh;
    }

    @Override
    public Sanh getSanhById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Sanh> query = criteriaBuilder.createQuery(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        Sanh result = session.createQuery(query).uniqueResult();
        session.close();
        return result;
    }

    @Override
    public boolean deleteSanhById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Sanh> query = criteriaBuilder.createCriteriaDelete(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }


}
