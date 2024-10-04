package com.example.spring_demo.conntroller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter

public class IptApplicationRequest {

    private String region;
    private String institution;
    private String section;
    private Date appliedDate;

}
