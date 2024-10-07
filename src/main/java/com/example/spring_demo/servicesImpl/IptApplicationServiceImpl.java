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

  @Override
  public IptApplication iptApplication(IptApplicationDto iptApplicationDto) {
    IptApplication iptApplication = new IptApplication();

    iptApplication.setAppliedDate(iptApplicationDto.getAppliedDate());
    iptApplication.setRegion(iptApplicationDto.getRegion());
    iptApplication.setSection(iptApplicationDto.getSection());
    iptApplication.setInstitution(iptApplicationDto.getInstitution());
    iptApplicationRepository.save(iptApplication);

    return  iptApplicationRepository.save(iptApplication);
  }

  @Override
  public List<IptApplication> getAllIptApplications() {
    return iptApplicationRepository.findAll();

  }

  @Override
  public IptApplication updateIptApplication(Long ipt_application_id, IptApplicationDto iptApplicationDto) {
    if(ipt_application_id==null) {
      return null;
    }
    IptApplication iptApplication = iptApplicationRepository.findById(ipt_application_id).orElse(null);
    if(iptApplication != null){
      iptApplication.setAppliedDate(iptApplicationDto.getAppliedDate());
      iptApplication.setRegion(iptApplicationDto.getRegion());
      iptApplication.setSection(iptApplicationDto.getSection());
      iptApplication.setInstitution(iptApplicationDto.getInstitution());
        return iptApplicationRepository.save(iptApplication);
    } else {
        return null;
    }

  }

  @Override
  public void deleteIptApplication(Long ipt_application_id) {
  iptApplicationRepository.deleteById(ipt_application_id);

  }
}
