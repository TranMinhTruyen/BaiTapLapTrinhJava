package com.example.repository.RepositoryImplement;

import com.example.common.entity.ThucAn;
import com.example.common.wrapper.ThucAnWrapper;
import com.example.repository.ThucAnRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ThucAnRepositoryImp implements ThucAnRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllThucAn() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.select(criteriaBuilder.construct(
                ThucAnWrapper.class,
                root.get("id"),
                root.get("ten"),
                root.get("giaTien"),
                root.get("hinhAnh")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public ThucAn createThucAn(ThucAn thucAn) {
        Session session = this.sessionFactory.getCurrentSession();
        if (thucAn != null){
            session.save(thucAn);
            return thucAn;
        }
        else{
            return null;
        }
    }

    @Override
    public ThucAn getThucAnById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
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
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<ThucAn> query = criteriaBuilder.createCriteriaUpdate(ThucAn.class);
        Root<ThucAn> root = query.from(ThucAn.class);
        query.set("ten",thucAn.getTen());
        query.set("giaTien",thucAn.getGiaTien());
        query.set("hinhAnh",thucAn.getHinhAnh());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteThucAn(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<ThucAn> query = criteriaBuilder.createCriteriaDelete(ThucAn.class);
        Root<ThucAn> root = query.from(ThucAn.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        session.createQuery(query).executeUpdate();
    }
}
