package org.olddriver.learnspring.controller;

import org.olddriver.learnspring.Dept;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class ValidationController {

    @PostMapping("/addDept")
    public String addDept(@RequestBody @Validated({Dept.Add.class}) /*@Valid*/ Dept dept){
        return "ok";
    }

    @PostMapping("/addDeptList")
    @Validated({Dept.Add.class})
    public @NotNull String addDeptList(@RequestBody  List<@Valid Dept> deptList){
        return "";
    }
}
