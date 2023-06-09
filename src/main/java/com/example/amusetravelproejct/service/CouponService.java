package com.example.amusetravelproejct.service;


import com.example.amusetravelproejct.dto.request.InsertCouponTypeReq;
import com.example.amusetravelproejct.dto.response.GetCouponRes;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface CouponService {


    String pushCoupon(InsertCouponTypeReq insertCouponTypeReq)throws Exception;

    GetCouponRes getCoupon(String couponCode) throws Exception;
}
