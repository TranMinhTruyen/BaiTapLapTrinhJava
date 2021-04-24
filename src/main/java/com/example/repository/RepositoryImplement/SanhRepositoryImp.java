package com.example.repository.RepositoryImplement;

import com.example.common.entity.Sanh;
import com.example.common.response.SanhResponse;
import com.example.repository.SanhRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class SanhRepositoryImp implements SanhRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;


    @Override
    public List<Object> getAllSanh() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.select(criteriaBuilder.construct(
                SanhResponse.class,
                root.get("id"),
                root.get("ten"),
                root.get("giaTien"),
                root.get("tongSoBan"),
                root.get("hinhAnh")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public List<Object> getSanhByKeyWord(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Sanh> root = query.from(Sanh.class);
        if (keyword != null){
            query.select(criteriaBuilder.construct(
                    SanhResponse.class,
                    root.get("id"),
                    root.get("ten"),
                    root.get("giaTien"),
                    root.get("tongSoBan"),
                    root.get("hinhAnh")
            ));
            Predicate p1 = criteriaBuilder.like(root.get("ten").as(String.class),keyword);
            Predicate p2 = criteriaBuilder.equal(root.get("id").as(String.class),keyword);
            query.where(criteriaBuilder.or(p1,p2));
            return session.createQuery(query).getResultList();
        }
        else{
            return getAllSanh();
        }
    }

    @Override
    public Sanh createSanh(Sanh sanh) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (sanh != null){
            session.save(sanh);
            return sanh;
        }
        else {
            return null;
        }
    }

    @Override
    public void updateSanh(int id, Sanh sanh) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Sanh> query = criteriaBuilder.createCriteriaUpdate(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);
        query.set("ten",sanh.getTen());
        query.set("tongSoBan",sanh.getTongSoBan());
        query.set("giaTien",sanh.getGiaTien());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        session.createQuery(query).executeUpdate();
    }

    @Override
    public Sanh getSanhById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
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
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Sanh> query = criteriaBuilder.createCriteriaDelete(Sanh.class);
        Root<Sanh> root = query.from(Sanh.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        session.createQuery(query).executeUpdate();
    }
}
