package com.example.repository.RepositoryImplement;

import com.example.common.entity.CaLamViec;
import com.example.common.response.CaLamViecResponse;
import com.example.repository.CaLamViecRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class CaLamViecRepositoryImp implements CaLamViecRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public List getAllCalamViec() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<CaLamViec> root = query.from(CaLamViec.class);
        query.select(criteriaBuilder.construct(
                CaLamViecResponse.class,
                root.get("id"),
                root.get("caLam")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public CaLamViec createCaLamViec(CaLamViec caLamViec) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (caLamViec != null){
            session.save(caLamViec);
            return caLamViec;
        }
        else {
            return null;
        }
    }

    @Override
    public List getCaLamViecByKeyword(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<CaLamViec> root = query.from(CaLamViec.class);
        query.select(criteriaBuilder.construct(
                CaLamViecResponse.class,
                root.get("id"),
                root.get("caLam")
        ));

        Predicate p1 = criteriaBuilder.equal(root.get("id").as(String.class), keyword);
        Predicate p2 = criteriaBuilder.like(root.get("caLam").as(String.class), keyword);

        query.where(criteriaBuilder.or(p1,p2));
        if (keyword != null)
            return session.createQuery(query).getResultList();
        else
            return getAllCalamViec();
    }

    @Override
    public CaLamViec getCaLamViecById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CaLamViec> query = criteriaBuilder.createQuery(CaLamViec.class);
        Root<CaLamViec> root = query.from(CaLamViec.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        return session.createQuery(query).uniqueResult();
    }

    @Override
    public void updateCaLamViec(int id, CaLamViec caLamViec) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<CaLamViec> query = criteriaBuilder.createCriteriaUpdate(CaLamViec.class);
        Root<CaLamViec> root = query.from(CaLamViec.class);
        query.set("caLam",caLamViec.getCaLam());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteCaLamViec(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<CaLamViec> query = criteriaBuilder.createCriteriaDelete(CaLamViec.class);
        Root<CaLamViec> root = query.from(CaLamViec.class);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
