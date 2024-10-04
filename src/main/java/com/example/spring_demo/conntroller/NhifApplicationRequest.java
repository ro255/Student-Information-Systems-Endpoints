package com.example.spring_demo.conntroller;

import com.example.spring_demo.models.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@Builder

public class NhifApplicationRequest {


    private Users users;
    private String CardNumber;
    private String Category;
    private String NHIF_SubmissionResponse;
    private Date NHIF_SubmissionTime;
    private String Control_Number;
    private String Identification_Number;
    private String Amount;
    private String status;


}
