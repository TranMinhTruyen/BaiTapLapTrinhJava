package com.example.repository.RepositoryImplement;

import com.example.common.entity.Menu;
import com.example.common.wrapper.MenuWrapper;
import com.example.repository.MenuRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class MenuRepositoryImp implements MenuRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List getAllMenu() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Menu> root = query.from(Menu.class);
        query.select(criteriaBuilder.construct(
                MenuWrapper.class,
                root.get("id"),
                root.get("tenMenu")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public Menu getMenuById(long keyword) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = criteriaBuilder.createQuery(Menu.class);
        Root<Menu> root = query.from(Menu.class);
        Predicate p = criteriaBuilder.equal(root.get("id"),keyword);
        query.where(p);
        return session.createQuery(query).uniqueResult();
    }

    @Override
    public Menu createMenu(Menu menu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        if (menu != null){
            session.save(menu);
            return menu;
        }
        else {
            return null;
        }
    }

    @Override
    public Menu updateMenu(long idMenu, Menu menu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Menu> query = criteriaBuilder.createCriteriaUpdate(Menu.class);
        Root<Menu> root = query.from(Menu.class);
        query.set("tenMenu",menu.getTenMenu());

        Predicate p = criteriaBuilder.equal(root.get("id"),idMenu);
        query.where(p);
        session.createQuery(query).executeUpdate();

        return menu;
    }

    @Override
    public void deleteMenu(long idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Menu> query = criteriaBuilder.createCriteriaDelete(Menu.class);
        Root<Menu> root = query.from(Menu.class);
        Predicate p = criteriaBuilder.equal(root.get("id"),idMenu);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
