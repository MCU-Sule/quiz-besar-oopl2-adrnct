package com.quiz2pbo_1972008.DAO;

import com.quiz2pbo_1972008.Model.AnggotaEntity;
import com.quiz2pbo_1972008.Model.BukuEntity;
import com.quiz2pbo_1972008.Model.PeminjamanEntity;
import com.quiz2pbo_1972008.Util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PeminjamanDao implements DAOInterface<PeminjamanEntity>{
    @Override
    public int addData(PeminjamanEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int delData(PeminjamanEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int updateData(PeminjamanEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<PeminjamanEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder =s.getCriteriaBuilder();
        CriteriaQuery query =builder.createQuery(PeminjamanEntity.class);
        query.from(PeminjamanEntity.class);
        List<PeminjamanEntity>alist =s.createQuery(query).getResultList();
        s.close();
        return FXCollections.observableArrayList(alist);
    }
}
