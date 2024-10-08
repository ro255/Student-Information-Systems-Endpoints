package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.IptApplicationDto;
import com.example.spring_demo.models.IptApplication;
import com.example.spring_demo.respositories.IptApplicationRepository;
import com.example.spring_demo.services.IptApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IptApplicationServiceImpl implements IptApplicationService {

  @Autowired
  private final IptApplicationRepository iptApplicationRepository;

  public IptApplicationServiceImpl(IptApplicationRepository iptApplicationRepository) {
    this.iptApplicationRepository = iptApplicationRepository;
  }

  public IptApplication createIptApplication(IptApplicationDto iptApplicationDto) {
    System.out.println(iptApplicationDto);
    System.out.println("====================================START===========================================");
   IptApplication iptApplication = new IptApplication();
   iptApplication.setInstitution(iptApplicationDto.getInstitution());
   iptApplication.setSection(iptApplicationDto.getSection());
   iptApplication.setRegion(iptApplicationDto.getRegion());
   iptApplication.setAppliedDate(iptApplicationDto.getAppliedDate());

   System.out.println(iptApplication);
   System.out.println("=================================END=========================================");
    return iptApplicationRepository.save(iptApplication);
  }

  @Override
  public List<IptApplication> getIptApplications() {
    return iptApplicationRepository.findAll();
  }

  @Override
  public IptApplication updateIptApplication(Long iptApplicationId, IptApplicationDto iptApplicationDto) {
    IptApplication iptApplication = iptApplicationRepository.findById(iptApplicationId).get();
    if(iptApplicationDto != null) {
      iptApplication.setInstitution(iptApplicationDto.getInstitution());
      iptApplication.setSection(iptApplicationDto.getSection());
      iptApplication.setRegion(iptApplicationDto.getRegion());
      iptApplication.setAppliedDate(iptApplicationDto.getAppliedDate());

      System.out.println(iptApplication);
      System.out.println("=============================================END==============================================");
      return iptApplicationRepository.save(iptApplication);
    } else{
      return null;
    }

  }

  @Override
  public void deleteIptApplication(Long iptApplicationId) {
    iptApplicationRepository.deleteById(iptApplicationId);

  }
}
