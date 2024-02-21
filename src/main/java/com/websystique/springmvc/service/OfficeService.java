package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Office;

import java.util.List;

public interface OfficeService {
    List<Office> findAll();

    Office findById(Integer key);

    List<Office> findAllOfficesByAddress(String address);

    String createOffice(Office office);
}
