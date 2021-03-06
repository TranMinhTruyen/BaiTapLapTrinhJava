package com.example.repository.RepositoryImplement;

import com.example.common.entity.ThucAn;
import com.example.common.response.ThucAnResponse;
import com.example.repository.ThucAnRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ThucAnRepositoryImp implements ThucAnRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public List getAllThucAn() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.select(criteriaBuilder.construct(
                ThucAnResponse.class,
                root.get("id"),
                root.get("ten"),
                root.get("loai"),
                root.get("hinhAnh")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public ThucAn createThucAn(ThucAn thucAn) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (thucAn != null){
            session.save(thucAn);
            return thucAn;
        }
        else{
            return null;
        }
    }

    @Override
    public List getThucAnByKeyword(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.select(criteriaBuilder.construct(
                ThucAnResponse.class,
                root.get("id"),
                root.get("ten"),
                root.get("loai"),
                root.get("hinhAnh")
        ));
        Predicate p1 = criteriaBuilder.equal(root.get("id").as(String.class),keyword);
        Predicate p2 = criteriaBuilder.like(root.get("ten").as(String.class),keyword);
        Predicate p3 = criteriaBuilder.like(root.get("loai").as(String.class),keyword);
        query.where(criteriaBuilder.or(p1,p2,p3));
        if (keyword != null)
            return session.createQuery(query).getResultList();
        else return getAllThucAn();
    }


    @Override
    public ThucAn getThucAnById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ThucAn> query = criteriaBuilder.createQuery(ThucAn.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        return session.createQuery(query).uniqueResult();
    }


    @Override
    public void updateThucAn(int id, ThucAn thucAn) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<ThucAn> query = criteriaBuilder.createCriteriaUpdate(ThucAn.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.set("ten",thucAn.getTen());
        query.set("loai",thucAn.getLoai());
        query.set("hinhAnh",thucAn.getHinhAnh());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteThucAn(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<ThucAn> query = criteriaBuilder.createCriteriaDelete(ThucAn.class);
        Root<ThucAn> root = query.from(ThucAn.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        session.createQuery(query).executeUpdate();
    }
}
