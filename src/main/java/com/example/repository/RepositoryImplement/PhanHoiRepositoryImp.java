package com.example.repository.RepositoryImplement;

import com.example.common.entity.PhanHoi;
import com.example.common.response.PhanHoiResponse;
import com.example.repository.PhanHoiRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PhanHoiRepositoryImp implements PhanHoiRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public List getAllPhanHoi() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<PhanHoi> root = query.from(PhanHoi.class);
        query.select(criteriaBuilder.construct(
                PhanHoiResponse.class,
                root.get("id"),
                root.get("noiDung"),
                root.get("tiec"),
                root.get("khachHang")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public PhanHoi createPhanHoi(PhanHoi phanHoi) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (phanHoi != null){
            session.save(phanHoi);
            return phanHoi;
        }
        else {
            return null;
        }
    }

    @Override
    public List getPhanHoiByKeyword(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<PhanHoi> root = query.from(PhanHoi.class);
        if (keyword != null){
            query.select(criteriaBuilder.construct(
                    PhanHoiResponse.class,
                    root.get("id"),
                    root.get("noiDung"),
                    root.get("tiec"),
                    root.get("khachHang")
            ));
            Predicate p1 = criteriaBuilder.like(root.get("noiDung").as(String.class),keyword);
            Predicate p2 = criteriaBuilder.equal(root.get("id").as(String.class),keyword);
            Predicate p3 = criteriaBuilder.equal(root.get("tiec").as(String.class),keyword);
            Predicate p4 = criteriaBuilder.equal(root.get("khachHang").as(String.class),keyword);
            query.where(criteriaBuilder.or(p1,p2,p3,p4));
            return session.createQuery(query).getResultList();
        }
        else{
            return getAllPhanHoi();
        }
    }

    @Override
    public PhanHoi getPhanHoiById(int idTiec, int idKhachHang) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PhanHoi> query = criteriaBuilder.createQuery(PhanHoi.class);
        Root<PhanHoi> root = query.from(PhanHoi.class);
        query.select(root);
        Predicate p1 = criteriaBuilder.equal(root.get("tiec"),idTiec);
        Predicate p2 = criteriaBuilder.equal(root.get("khachHang"),idKhachHang);
        query.where(criteriaBuilder.and(p1,p2));
        return session.createQuery(query).uniqueResult();
    }

    @Override
    public void updatePhanHoi(int idTiec, int idKhachHang, PhanHoi phanHoi) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<PhanHoi> query = criteriaBuilder.createCriteriaUpdate(PhanHoi.class);
        Root<PhanHoi> root = query.from(PhanHoi.class);
        query.set("noiDung",phanHoi.getNoiDung());

        Predicate p1 = criteriaBuilder.equal(root.get("tiec"),idTiec);
        Predicate p2 = criteriaBuilder.equal(root.get("khachHang"),idKhachHang);
        query.where(criteriaBuilder.and(p1,p2));

        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deletePhanHoi(int idTiec, int idKhachHang) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<PhanHoi> query = criteriaBuilder.createCriteriaDelete(PhanHoi.class);
        Root<PhanHoi> root = query.from(PhanHoi.class);

        Predicate p1 = criteriaBuilder.equal(root.get("tiec"),idTiec);
        Predicate p2 = criteriaBuilder.equal(root.get("khachHang"),idKhachHang);
        query.where(criteriaBuilder.and(p1,p2));

        session.createQuery(query).executeUpdate();
    }
}
