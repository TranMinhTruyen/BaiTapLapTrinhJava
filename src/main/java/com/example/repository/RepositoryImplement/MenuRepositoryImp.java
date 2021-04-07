package com.example.repository.RepositoryImplement;

import com.example.common.config.HibernateUtils;
import com.example.common.entity.Menu;
import com.example.common.entity.ThucAn;
import com.example.common.wrapper.MenuWrapper;
import com.example.repository.MenuRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class MenuRepositoryImp implements MenuRepository {

    private final Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public List getAllMenu() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = criteriaBuilder.createQuery(Menu.class);
        Root<Menu> root = query.from(Menu.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    @Override
    public List<Object> getMenuCuaTiec(int keyword) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Menu> root = query.from(Menu.class);

        Join<Menu, ThucAn> thucAn = root.join("thucAn", JoinType.LEFT);
        Predicate p = criteriaBuilder.equal(root.get("tiec"),keyword);
        query.where(p);
        query.select(criteriaBuilder.construct(
                MenuWrapper.class,
                thucAn.get("id"),
                thucAn.get("ten"),
                thucAn.get("giaTien"),
                thucAn.get("hinhAnh"),
                root.get("soLuong")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public Menu createMenu(Menu menu) {
        if (menu != null){
            session.beginTransaction();
            session.save(menu);
            session.getTransaction().commit();
            return menu;
        }
        else
            session.getTransaction().rollback();
            return null;
    }

    @Override
    public Boolean isMenuExists(int idTiec, int idThucAn) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = criteriaBuilder.createQuery(Menu.class);
        Root<Menu> root = query.from(Menu.class);

        Predicate p1 = criteriaBuilder.equal(root.get("tiec"),idTiec);
        Predicate p2 = criteriaBuilder.equal(root.get("thucAn"),idThucAn);

        query.where(criteriaBuilder.and(p1,p2));

        Transaction transaction = session.beginTransaction();
        Menu result =  session.createQuery(query).uniqueResult();
        transaction.commit();

        return result != null;
    }

    @Override
    public Menu updateSoLuong(int idTiec, int idThucAn, Menu menu) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Menu> query = criteriaBuilder.createCriteriaUpdate(Menu.class);
        Root<Menu> root = query.from(Menu.class);
        query.set("soLuong",menu.getSoLuong());

        Predicate p1 = criteriaBuilder.equal(root.get("tiec"),idTiec);
        Predicate p2 = criteriaBuilder.equal(root.get("thucAn"),idThucAn);

        query.where(criteriaBuilder.and(p1,p2));

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
        return menu;
    }

    @Override
    public void deleteThucAn(int idTiec, int idThucAn) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Menu> query = criteriaBuilder.createCriteriaDelete(Menu.class);
        Root<Menu> root = query.from(Menu.class);

        Predicate p1 = criteriaBuilder.equal(root.get("tiec"),idTiec);
        Predicate p2 = criteriaBuilder.equal(root.get("thucAn"),idThucAn);

        query.where(criteriaBuilder.and(p1,p2));

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
    }

    @Override
    public void deleteMenu(int idTiec) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Menu> query = criteriaBuilder.createCriteriaDelete(Menu.class);
        Root<Menu> root = query.from(Menu.class);

        Predicate p = criteriaBuilder.equal(root.get("tiec"),idTiec);

        query.where(p);

        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
    }
}
