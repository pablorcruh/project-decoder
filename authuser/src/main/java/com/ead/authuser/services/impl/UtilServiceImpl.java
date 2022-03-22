package com.ead.authuser.services.impl;

import com.ead.authuser.services.UtilService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilServiceImpl implements UtilService {


    public String createUrl(UUID userId, Pageable pageable){
        return "/courses?userId=" + userId + "&page=" + pageable.getPageNumber() + "&size="
                + pageable.getPageSize() + "&sort=" + pageable.getSort().toString().replaceAll(": ",",") ;
    }

}
