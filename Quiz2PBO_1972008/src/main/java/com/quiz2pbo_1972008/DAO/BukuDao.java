package com.quiz2pbo_1972008.DAO;


import com.quiz2pbo_1972008.Model.BukuEntity;
import com.quiz2pbo_1972008.Util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BukuDao implements DAOInterface<BukuEntity>{
    @Override
    public int addData(BukuEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int delData(BukuEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int updateData(BukuEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<BukuEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder =s.getCriteriaBuilder();
        CriteriaQuery query =builder.createQuery(BukuEntity.class);
        query.from(BukuEntity.class);
        List<BukuEntity>alist =s.createQuery(query).getResultList();
        s.close();
        return FXCollections.observableArrayList(alist);
    }
}
