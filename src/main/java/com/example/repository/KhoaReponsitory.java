package com.example.repository;

import com.example.config.HibernateUtils;
import com.example.entity.Khoa;
import com.example.entity.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class KhoaReponsitory {

    public List getAllKhoa(){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Khoa> query = builder.createQuery(Khoa.class);
            Root<Khoa> root = query.from(Khoa.class);
            query = query.select(root);
            Query q = session.createQuery(query);
            return q.getResultList();
        }
    }


    public Khoa addKhoa(Khoa khoa){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            if (khoa != null){
                session.beginTransaction();
                session.save(khoa);
                session.getTransaction().commit();
                return khoa;
            }
            else
                return null;
        }
    }


    public Khoa getKhoaById(int id){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Khoa> query = builder.createQuery(Khoa.class);
            Root<Khoa> root = query.from(Khoa.class);

            query = query.select(root).where(builder.equal(root.get("id").as(String.class),id));
            return session.createQuery(query).getSingleResult();
        }
    }


    public Khoa updateKhoaById(Khoa khoa, int id){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaUpdate<Khoa> criteriaUpdate = builder.createCriteriaUpdate(Khoa.class);
            Root<Khoa> root = criteriaUpdate.from(Khoa.class);

            criteriaUpdate.set("name",khoa.getName()).where(builder.equal(root.get("id").as(String.class),id));

            session.beginTransaction();
            session.createQuery(criteriaUpdate).executeUpdate();
            session.getTransaction().commit();
            return khoa;
        }
    }


    public void deleteKhoaById(int id){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Khoa> criteriaDeleteK = builder.createCriteriaDelete(Khoa.class);
            CriteriaDelete<Student> criteriaDeleteS = builder.createCriteriaDelete(Student.class);
            Root<Khoa> rootK = criteriaDeleteK.from(Khoa.class);
            Root<Student> rootS= criteriaDeleteS.from(Student.class);

            criteriaDeleteK.where(builder.equal(rootK.get("id").as(String.class),id));
            criteriaDeleteS.where(builder.equal(rootS.get("khoa"),id));

            session.beginTransaction();
            session.createQuery(criteriaDeleteS).executeUpdate();
            session.createQuery(criteriaDeleteK).executeUpdate();
            session.getTransaction().commit();
        }
    }


    public List<Object[]> getSinhVienByKhoa (int id){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

            Root<Khoa> root = query.from(Khoa.class);

            query = query.select(root.get("listSV")).where(builder.equal(root.get("id").as(String.class),id));
            return session.createQuery(query).getResultList();
        }
    }
}
