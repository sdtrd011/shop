package com.kb.shop.controller;


import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    public ResponseEntity<Void> setShipping(@RequestBody ShippingInfo shippingInfo) {
        shippingService.setShippingInfo(shippingInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateShippingStatus(@PathVariable Long id, @RequestParam String shippingStatus) {
        shippingService.updateShippingStatus(id, shippingStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getShippingById(@PathVariable Long id) {
        ShippingInfo info = shippingService.getShippingInfo(id);
        if (info != null) {
            return new ResponseEntity<>(info, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 주문 ID로 배송 정보 조회
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ShippingInfo>> getByOrderId(@PathVariable Long orderId) {
        List<ShippingInfo> list = shippingService.getByOrderId(orderId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 주문 아이템 ID로 배송 정보 조회
    @GetMapping("/order-item/{orderItemId}")
    public ResponseEntity<List<ShippingInfo>> getByOrderItemId(@PathVariable Long orderItemId) {
        List<ShippingInfo> list = shippingService.getByOrderItemId(orderItemId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
