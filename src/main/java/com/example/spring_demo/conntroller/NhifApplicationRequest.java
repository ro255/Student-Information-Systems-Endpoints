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

    private Date AYear;
    private String RegistrationNo;
    private Users users;
    private String Gender;
    private String FormIV_index;
    private String CardNumber;
    private String Category;
    private String Year;
    private String phone;
    private String NHIF_SubmissionResponse;
    private Date NHIF_SubmissionTime;
    private String Control_Number;
    private String Identification_Number;
    private String Amount;
    private String status;


}
