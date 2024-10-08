package com.example.spring_demo.services;

import com.example.spring_demo.Dto.IptApplicationDto;
import com.example.spring_demo.models.IptApplication;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public interface IptApplicationService {


  IptApplication createIptApplication(IptApplicationDto iptApplicationDto);

  List<IptApplication> getIptApplications();

  IptApplication updateIptApplication(Long iptApplicationId, IptApplicationDto iptApplicationDto);

  void deleteIptApplication(Long iptApplicationId);

}
