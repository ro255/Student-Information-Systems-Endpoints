package com.example.spring_demo.Dto;

import lombok.*;

import java.math.BigInteger;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MyFullProfile {

  private BigInteger profileId;
}
