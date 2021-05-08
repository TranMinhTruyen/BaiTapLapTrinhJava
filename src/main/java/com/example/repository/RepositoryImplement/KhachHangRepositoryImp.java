package com.example.repository.RepositoryImplement;

import com.example.common.entity.KhachHang;
import com.example.common.entity.Menu;
import com.example.common.entity.NhanVien;
import com.example.common.response.KhachHangResponse;
import com.example.common.response.MenuResponse;
import com.example.repository.KhachHangRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class KhachHangRepositoryImp implements KhachHangRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public KhachHang createKhachHang(KhachHang khachHang) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (khachHang != null){
            session.save(khachHang);
            return khachHang;
        }
        else {
            return null;
        }
    }

    @Override
    public List getAllKhachHang() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        query.select(criteriaBuilder.construct(
                KhachHangResponse.class,
                root.get("id"),
                root.get("ho"),
                root.get("ten"),
                root.get("ngaySinh").as(String.class),
                root.get("hinhAnh")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public List getKhachHangByKeyword(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        query.select(criteriaBuilder.construct(
                KhachHangResponse.class,
                root.get("id"),
                root.get("ho"),
                root.get("ten"),
                root.get("ngaySinh").as(String.class),
                root.get("hinhAnh")
        ));

        Predicate p1 = criteriaBuilder.equal(root.get("id").as(String.class), keyword);
        Predicate p2 = criteriaBuilder.like(root.get("taiKhoan").as(String.class), keyword);
        Predicate p3 = criteriaBuilder.like(root.get("ho").as(String.class), keyword);
        Predicate p4 = criteriaBuilder.like(root.get("ten").as(String.class), keyword);
        Predicate p5 = criteriaBuilder.like(root.get("ngaySinh").as(String.class), keyword);

        query.where(criteriaBuilder.or(p1,p2,p3,p4,p5));
        if (keyword != null)
            return session.createQuery(query).getResultList();
        else
            return getAllKhachHang();
    }

    @Override
    public KhachHang getKhachHangByTaiKhoanMatKhau(String taiKhoan, String matKhau) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = criteriaBuilder.createQuery(KhachHang.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        query.select(root);
        Predicate p1 = criteriaBuilder.like(root.get("taiKhoan").as(String.class), taiKhoan);
        Predicate p2 = criteriaBuilder.equal(root.get("matKhau").as(String.class), matKhau);

        query.where(criteriaBuilder.and(p1,p2));

        return session.createQuery(query).uniqueResult();
    }

    @Override
    public KhachHang getKhachHangById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = criteriaBuilder.createQuery(KhachHang.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        return session.createQuery(query).uniqueResult();
    }

    @Override
    public boolean KhachHangIsExist(String taiKhoan) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<KhachHang> query = criteriaBuilder.createQuery(KhachHang.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        query.select(root).where(criteriaBuilder.equal(root.get("taiKhoan"), taiKhoan));
        KhachHang result = session.createQuery(query).uniqueResult();
        if (result == null)
            return false;
        else
            return true;
    }

    @Override
    public void updateKhachHangById(int id, KhachHang khachHang) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<KhachHang> query = criteriaBuilder.createCriteriaUpdate(KhachHang.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        query.set("matKhau",khachHang.getMatKhau());
        query.set("ho",khachHang.getHo());
        query.set("ten",khachHang.getTen());
        query.set("ngaySinh",khachHang.getNgaySinh());
        query.set("hinhAnh",khachHang.getHinhAnh());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteKhachHangById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<KhachHang> query = criteriaBuilder.createCriteriaDelete(KhachHang.class);
        Root<KhachHang> root = query.from(KhachHang.class);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
