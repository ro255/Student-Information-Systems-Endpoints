package com.example.spring_demo.conntroller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseRegistrationRequest {

    private String course_code;
    private String course_name;
    private Integer unit;
    private  String status;

}
