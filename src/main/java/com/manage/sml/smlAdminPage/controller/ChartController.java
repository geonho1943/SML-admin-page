package com.manage.sml.smlAdminPage.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("chart-info")
public class ChartController {

    @GetMapping("/loginCountByDay")
    public Map<String, Integer> getLoginInfoByDay(@RequestParam String user_idx) {
        //todo: test 데이터 작성
        return loginService.getLoginInfoByDay(user_idx);
    }
}
