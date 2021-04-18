package com.example.repository.RepositoryImplement;


import com.example.common.entity.MenuThucAn;
import com.example.common.entity.ThucAn;
import com.example.common.wrapper.ThucAnWrapper;
import com.example.repository.MenuThucAnRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class MenuThucAnRepositoryImp implements MenuThucAnRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public MenuThucAn create(MenuThucAn menuThucAns) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        if (menuThucAns != null){
            session.save(menuThucAns);
            return menuThucAns;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Object> getListThucAnByMenuId(long idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<MenuThucAn> root = query.from(MenuThucAn.class);
        Join<MenuThucAn ,ThucAn> join = root.join("thucAn",JoinType.LEFT);
        Predicate p = criteriaBuilder.equal(root.get("menu"),idMenu);
        query.where(p);
        query.select(criteriaBuilder.construct(
                ThucAnWrapper.class,
                join.get("id"),
                join.get("ten"),
                join.get("giaTien"),
                join.get("hinhAnh")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public boolean isIdThucAnExist(int idThucAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<MenuThucAn> query = criteriaBuilder.createQuery(MenuThucAn.class);
        Root<MenuThucAn> root = query.from(MenuThucAn.class);
        Predicate p = criteriaBuilder.equal(root.get("thucAn").get("id"),idThucAn);
        query.where(p);
        List result = session.createQuery(query).getResultList();
        return result != null;
    }

    @Override
    public boolean isIdMenuExist(long idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<MenuThucAn> query = criteriaBuilder.createQuery(MenuThucAn.class);
        Root<MenuThucAn> root = query.from(MenuThucAn.class);
        Predicate p = criteriaBuilder.equal(root.get("menu").get("id"),idMenu);
        query.where(p);
        List result = session.createQuery(query).getResultList();
        return result != null;
    }

    @Override
    public void deleteByIdThucAn(int idThucAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<MenuThucAn> query = criteriaBuilder.createCriteriaDelete(MenuThucAn.class);
        Root<MenuThucAn> root = query.from(MenuThucAn.class);
        Predicate p = criteriaBuilder.equal(root.get("thucAn").get("id"),idThucAn);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteByIdMenu(long idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<MenuThucAn> query = criteriaBuilder.createCriteriaDelete(MenuThucAn.class);
        Root<MenuThucAn> root = query.from(MenuThucAn.class);
        Predicate p = criteriaBuilder.equal(root.get("menu").get("id"),idMenu);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteThucAnByIdMenu(long idMenu, int idThucAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<MenuThucAn> query = criteriaBuilder.createCriteriaDelete(MenuThucAn.class);
        Root<MenuThucAn> root = query.from(MenuThucAn.class);
        Predicate p1 = criteriaBuilder.equal(root.get("thucAn").get("id"),idThucAn);
        Predicate p2 = criteriaBuilder.equal(root.get("menu").get("id"),idMenu);
        query.where(criteriaBuilder.and(p1,p2));
        session.createQuery(query).executeUpdate();
    }
}
