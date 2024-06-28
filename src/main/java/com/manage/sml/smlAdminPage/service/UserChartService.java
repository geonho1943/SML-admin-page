package com.manage.sml.smlAdminPage.service;

import com.manage.sml.smlAdminPage.entity.DateTimeTemp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserChartService {

    // TODO: JPA적용전 DB 구조 검증 해야함
//    @Autowired
//    private UserRepository userRepository

    //유저에 대한 기능(로그인, 가입, 탈퇴, 이용정지)


    public List<DateTimeTemp> getLoginCountByDay(){
        List<DateTimeTemp> temp = new ArrayList<>();

        temp.add(new DateTimeTemp("2024-06-26 01:01:01",1));
        temp.add(new DateTimeTemp("2024-06-27 01:01:01",2));
        temp.add(new DateTimeTemp("2024-06-28 01:01:01",0));
        temp.add(new DateTimeTemp("2024-06-29 01:01:01",2));
        temp.add(new DateTimeTemp("2024-06-30 01:01:01",5));
        temp.add(new DateTimeTemp("2024-07-01 01:01:01",7));
        temp.add(new DateTimeTemp("2024-07-02 01:01:01",6));
        return temp;
    }

}
