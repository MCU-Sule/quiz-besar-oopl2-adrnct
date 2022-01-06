package com.quiz2pbo_1972008.DAO;

import java.util.List;

public interface DAOInterface<E> {
    public int addData(E data) ;
    public int delData(E data) ;
    public int updateData(E data);
    public List<E> showData();
}
