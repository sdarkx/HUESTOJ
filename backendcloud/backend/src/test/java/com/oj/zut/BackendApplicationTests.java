package com.oj.zut;

import com.oj.zut.service.utils.problems.getProblemListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }

    @Autowired
    private getProblemListService getProblemListService;

    @Test
    void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("current_page", "1");
        map.put("page_size", "5");

        Map<String, List<Map<String, String>>> problems = getProblemListService.getProblems(map);

        System.out.println(problems.get("error_message"));
        System.out.println(problems.get("page_list"));
        System.out.println(problems.get("problems_list"));
    }
    //[{error_message=success}]
    //[{total=2, current=1, pages=1, size=5}]
    //[{pb_id=1001, pb_rating=100, id=2, pb_name=Hello World!, pb_accepted=24381}, {pb_id=1001, pb_rating=100, id=2, pb_name=Hello World!, pb_accepted=24381}]

}
