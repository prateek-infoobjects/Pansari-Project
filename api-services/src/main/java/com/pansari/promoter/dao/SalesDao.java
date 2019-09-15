package com.pansari.promoter.dao;

import com.pansari.promoter.entity.Sales;

import java.util.List;
import java.util.Set;

public interface SalesDao {

 void createSale(Sales sale);

 List<Sales> fetchSales();

 List<Object[]> fetchSalesByNative(Set<String> dates);

}
