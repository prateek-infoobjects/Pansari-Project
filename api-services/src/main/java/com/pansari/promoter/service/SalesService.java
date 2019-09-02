package com.pansari.promoter.service;

import com.pansari.promoter.model.SalesDto;

public interface SalesService {

    void createSale(SalesDto salesDto) throws Exception;
}
