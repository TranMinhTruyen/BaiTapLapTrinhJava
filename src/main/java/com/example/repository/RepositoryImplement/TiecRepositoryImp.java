package com.example.repository.RepositoryImplement;

import com.example.common.entity.Tiec;
import com.example.common.response.TiecResponse;
import com.example.repository.TiecRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(rollbackOn = Exception.class)
public class TiecRepositoryImp implements TiecRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllTiec() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tiec> query = criteriaBuilder.createQuery(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(root);
        List result = session.createQuery(query).getResultList();
        return result;
    }

    @Override
    public Tiec getTiecbyId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tiec> query = criteriaBuilder.createQuery(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        Tiec result = session.createQuery(query).uniqueResult();
        return result;
    }

    @Override
    public Tiec creatTiec(Tiec tiec) {
        Session session = this.sessionFactory.getCurrentSession();
        if (tiec != null){
            session.save(tiec);
            return tiec;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Object> getTiecByKeyword(String keyword) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.select(criteriaBuilder.construct(
                TiecResponse.class,
                root.get("id"),
                root.get("thoiGianBatDau"),
                root.get("ngayBatDau"),
                root.get("loai"),
                root.get("sanh").get("id"),
                root.get("khachHang").get("id"),
                root.get("trangThai"),
                root.get("danhSachNhanVien").get("caLam"),
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
    public Tiec updateTiec(int id, Tiec tiec) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Tiec> query = criteriaBuilder.createCriteriaUpdate(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);
        query.set("thoiGianBatDau",tiec.getThoiGianBatDau());
        query.set("ngayBatDau",tiec.getNgayBatDau());
        query.set("loai",tiec.getLoai());
        query.set("sanh",tiec.getSanh());
        query.set("trangThai",tiec.getTrangThai());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        session.createQuery(query).executeUpdate();
        return tiec;
    }

    @Override
    public void deleteTiec(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Tiec> query = criteriaBuilder.createCriteriaDelete(Tiec.class);
        Root<Tiec> root = query.from(Tiec.class);

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);

        session.createQuery(query).executeUpdate();
    }
}
