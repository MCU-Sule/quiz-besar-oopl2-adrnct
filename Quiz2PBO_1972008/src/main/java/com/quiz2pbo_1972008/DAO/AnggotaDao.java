package com.quiz2pbo_1972008.DAO;

import com.quiz2pbo_1972008.Model.AnggotaEntity;

import java.util.List;

import com.quiz2pbo_1972008.Util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class AnggotaDao implements DAOInterface<AnggotaEntity>{

    @Override
    public int addData(AnggotaEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int delData(AnggotaEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.delete(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public int updateData(AnggotaEntity data) {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public List<AnggotaEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder =s.getCriteriaBuilder();
        CriteriaQuery query =builder.createQuery(AnggotaEntity.class);
        query.from(AnggotaEntity.class);
        List<AnggotaEntity>alist =s.createQuery(query).getResultList();
        s.close();
        return FXCollections.observableArrayList(alist);
    }

}
