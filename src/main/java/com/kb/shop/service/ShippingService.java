package com.kb.shop.service;


import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public ShippingInfo getShippingInfo (Long id) { return shippingRepository.selectShippingInfo(id);}

    public List<ShippingInfo> getByOrderId(Long orderId) {
        return shippingRepository.selectShippingInfoByOrder(orderId);
    }

    public List<ShippingInfo> getByOrderItemId(Long orderItemId) {
        return shippingRepository.selectShippingInfoByOrderItem(orderItemId);
    }

    public void setShippingInfo(ShippingInfo shippingInfo){
        shippingRepository.setShippingInfo(shippingInfo);
    }

    public void updateShippingStatus(Long id, String shippingStatus){
        shippingRepository.updateShippingStatus(id, shippingStatus);
    }

}
