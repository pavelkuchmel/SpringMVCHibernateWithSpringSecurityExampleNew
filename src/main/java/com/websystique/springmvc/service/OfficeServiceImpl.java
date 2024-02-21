package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.OfficeDao;
import com.websystique.springmvc.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("officeService")
@Transactional
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDao dao;


    @Override
    public List<Office> findAll() {
        return dao.findAllOffices();
    }

    @Override
    public Office findById(Integer key) {
        return dao.findById(key);
    }

    @Override
    public List<Office> findAllOfficesByAddress(String address) {
        return dao.findAllOfficesByAddress(address);
    }


    @Override
    public String createOffice(Office office) {
        try {
            dao.createOffice(office);
        } catch (Exception e){
            e.printStackTrace();
            return "Office Creation Error";
        }

        return "Office has been created successfully";
    }
}
