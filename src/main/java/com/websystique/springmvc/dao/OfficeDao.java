package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> findAllOffices();

    Office findById(Integer id);

    List<Office> findAllOfficesByAddress(String address);

    void createOffice(Office office);
}
