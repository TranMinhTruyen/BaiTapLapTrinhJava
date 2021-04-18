package com.example.repository.RepositoryImplement;

import com.example.common.entity.Tiec;
import com.example.common.wrapper.TiecWrapper;
import com.example.repository.TiecRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class TiecRepositoryImp implements TiecRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public Tiec createTiec(Tiec tiec) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (tiec != null){
            session.save(tiec);
            return tiec;
        }
        else {
            return null;
        }
    }

    @Override
    public List getAllTiec() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(criteriaBuilder.construct(
                TiecWrapper.class,
                root.get("id"),
                root.get("thoiGianBatDau").as(String.class),
                root.get("ngayBatDau").as(String.class),
                root.get("loai"),
                root.get("sanh").get("ten"),
                root.get("khachHang").get("ten"),
                root.get("trangThai"),
                root.get("caLamViec").get("caLam"),
                root.get("menu").get("tenMenu")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public List getTiecByKeyword(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(criteriaBuilder.construct(
                TiecWrapper.class,
                root.get("id"),
                root.get("thoiGianBatDau").as(String.class),
                root.get("ngayBatDau").as(String.class),
                root.get("loai"),
                root.get("sanh").get("ten"),
                root.get("khachHang").get("ten"),
                root.get("trangThai"),
                root.get("caLamViec").get("caLam"),
                root.get("menu").get("tenMenu")
        ));
        if (keyword != null){
            Predicate p1 = criteriaBuilder.equal(root.get("id").as(String.class),keyword);
            Predicate p2 = criteriaBuilder.like(root.get("thoiGianBatDau").as(String.class),keyword);
            Predicate p3 = criteriaBuilder.like(root.get("ngayBatDau").as(String.class),keyword);
            Predicate p4 = criteriaBuilder.like(root.get("sanh").get("id").as(String.class),keyword);
            Predicate p5 = criteriaBuilder.like(root.get("khachHang").get("id").as(String.class),keyword);
            Predicate p6 = criteriaBuilder.like(root.get("trangThai").as(String.class),keyword);
            query.where(criteriaBuilder.or(p1,p2,p3,p4,p5,p6));
            return session.createQuery(query).getResultList();
        }
        else{
            return getAllTiec();
        }
    }

    @Override
    public boolean isTiecExist(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tiec> query = criteriaBuilder.createQuery(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(root);
        Tiec result = session.createQuery(query).uniqueResult();
        return result != null;
    }

    @Override
    public void updateTiec(int id, Tiec tiec) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Tiec> query = criteriaBuilder.createCriteriaUpdate(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.set("thoiGianBatDau",tiec.getThoiGianBatDau());
        query.set("ngayBatDau",tiec.getNgayBatDau());
        query.set("loai",tiec.getLoai());
        query.set("sanh",tiec.getSanh().getId());
        query.set("menu",tiec.getMenu().getId());
        query.set("caLamViec",tiec.getCaLamViec().getId());
        query.set("trangThai",tiec.getTrangThai());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteTiec(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Tiec> query = criteriaBuilder.createCriteriaDelete(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        session.createQuery(query).executeUpdate();
    }
}
