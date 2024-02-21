package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("officeDao")
public class OfficeDaoImpl extends AbstractDao<Integer, Office> implements OfficeDao {
    @Override
    public List<Office> findAllOffices() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();

        return offices;
    }

    @Override
    public Office findById(Integer id) {
        return getByKey(id);
    }

    @Override
    public List<Office> findAllOfficesByAddress(String address) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("address", address+"%"));

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();

        return offices;
    }


    @Override
    public void createOffice(Office office) {
        persist(office);
    }
}
