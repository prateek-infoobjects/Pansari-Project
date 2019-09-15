package com.pansari.promoter.service;

import com.pansari.promoter.entity.Sales;
import com.pansari.promoter.model.SalesDto;

import java.util.List;
import java.util.Set;

public interface SalesService {

    void createSale(SalesDto salesDto) throws Exception;

    List<Sales> getSalesByDates();

     List<Object[]> getSalesByDatesNatively(Set<String> dates) ;
}
