package com.example.repository.RepositoryImplement;

import com.example.common.entity.NhanVien;
import com.example.common.response.NhanVienResponse;
import com.example.repository.NhanVienRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class NhanVienRepositoryImp implements NhanVienRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public NhanVien createNhanVien(NhanVien nhanVien) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if (nhanVien != null){
            session.save(nhanVien);
            return nhanVien;
        }
        else {
            return null;
        }
    }

    @Override
    public List getAllNhanVien() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.select(criteriaBuilder.construct(
                NhanVienResponse.class,
                root.get("id"),
                root.get("role"),
                root.get("ho"),
                root.get("ten"),
                root.get("ngaySinh").as(String.class),
                root.get("cmnd"),
                root.get("caLamViec").get("caLam"),
                root.get("hinhAnh")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    public List getNhanVienByKeyword(String keyword) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.select(criteriaBuilder.construct(
                NhanVienResponse.class,
                root.get("id"),
                root.get("role"),
                root.get("ho"),
                root.get("ten"),
                root.get("ngaySinh").as(String.class),
                root.get("cmnd"),
                root.get("caLamViec").get("caLam"),
                root.get("hinhAnh")
        ));

        Predicate p1 = criteriaBuilder.equal(root.get("id").as(String.class), keyword);
        Predicate p2 = criteriaBuilder.like(root.get("taiKhoan").as(String.class), keyword);
        Predicate p3 = criteriaBuilder.like(root.get("ho").as(String.class), keyword);
        Predicate p4 = criteriaBuilder.like(root.get("ten").as(String.class), keyword);
        Predicate p5 = criteriaBuilder.like(root.get("ngaySinh").as(String.class), keyword);
        Predicate p6 = criteriaBuilder.like(root.get("cmnd").as(String.class), keyword);
        Predicate p7 = criteriaBuilder.like(root.get("caLamViec").as(String.class), keyword);

        query.where(criteriaBuilder.or(p1,p2,p3,p4,p5,p6,p7));
        if (keyword != null)
            return session.createQuery(query).getResultList();
        else
            return getAllNhanVien();
    }

    @Override
    public NhanVien getNhanVienByTaiKhoanMatKhau(String taiKhoan, String matKhau) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = criteriaBuilder.createQuery(NhanVien.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.select(root);
        Predicate p1 = criteriaBuilder.like(root.get("taiKhoan").as(String.class), taiKhoan);
        Predicate p2 = criteriaBuilder.equal(root.get("matKhau").as(String.class), matKhau);

        query.where(criteriaBuilder.and(p1,p2));

        return session.createQuery(query).uniqueResult();
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = criteriaBuilder.createQuery(NhanVien.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);

        query.where(p);

        return session.createQuery(query).uniqueResult();
    }

    @Override
    public boolean NhanVienIsExist(String taiKhoan) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = criteriaBuilder.createQuery(NhanVien.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.select(root).where(criteriaBuilder.equal(root.get("taiKhoan"), taiKhoan));
        NhanVien result = session.createQuery(query).uniqueResult();
        if (result == null)
            return false;
        else
            return true;
    }

    @Override
    public void updateNhanVienById(int id, NhanVien nhanVien) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<NhanVien> query = criteriaBuilder.createCriteriaUpdate(NhanVien.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        query.set("matKhau",nhanVien.getMatKhau());
        query.set("ho",nhanVien.getHo());
        query.set("ten",nhanVien.getTen());
        query.set("ngaySinh",nhanVien.getNgaySinh());
        query.set("cmnd",nhanVien.getCmnd());
        query.set("caLamViec",nhanVien.getCaLamViec());
        query.set("hinhAnh",nhanVien.getHinhAnh());

        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    public void deleteNhanVienById(int id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<NhanVien> query = criteriaBuilder.createCriteriaDelete(NhanVien.class);
        Root<NhanVien> root = query.from(NhanVien.class);
        Predicate p = criteriaBuilder.equal(root.get("id"),id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
