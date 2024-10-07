package com.example.spring_demo.services;

import com.example.spring_demo.Dto.IptApplicationDto;
import com.example.spring_demo.models.IptApplication;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public interface IptApplicationService {

    IptApplication iptApplication(IptApplicationDto iptApplicationDto);

   List<IptApplication> getAllIptApplications();

   IptApplication updateIptApplication(Long ipt_application_id, IptApplicationDto iptApplicationDto);

   void deleteIptApplication(Long ipt_application_id);

}
