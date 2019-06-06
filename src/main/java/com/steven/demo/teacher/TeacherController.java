package com.steven.demo.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TeacherController {

    @Autowired
    TeacherMapper teacherMapper;

    @GetMapping(value = "/insert")
    public void insert() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName(createRandomStr(6));
        teacher.setTeacherPwd(createRandomStr(6));
        teacherMapper.insert(teacher);
    }

    /**
     * 生成随机字符串
     *
     * @return
     */
    private static String createRandomStr(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
