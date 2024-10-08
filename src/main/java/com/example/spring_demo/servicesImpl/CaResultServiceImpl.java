package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.CaResultDto;
import com.example.spring_demo.models.CaResult;
import com.example.spring_demo.respositories.CaResultRepository;
import com.example.spring_demo.services.CaResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaResultServiceImpl implements CaResultService {

  @Autowired
  private final CaResultRepository caResultRepository;

  public CaResultServiceImpl(CaResultRepository caResultRepository) {
    this.caResultRepository = caResultRepository;
  }

  @Override
  public CaResult createCaResult(CaResultDto caResultDto) {
    CaResult caResult = new CaResult();
    System.out.println(caResultDto);
    System.out.println("=========================START========================================");
    caResult.setPoints(caResultDto.getPoints());
    caResult.setRemark(caResultDto.getRemark());

    System.out.println(caResult);
    System.out.println("============================END=======================================");
    return caResultRepository.save(caResult);


  }

  @Override
  public List<CaResult> getCaResults() {
    return caResultRepository.findAll();
  }


  @Override
  public void deleteCaResult(Long caId) {
    caResultRepository.deleteById(caId);

  }


  @Override
  public CaResult updateCaResult(Long caId, CaResultDto caResultDto) {
    CaResult caResult= caResultRepository.findById(caId).get();
    if(caResultDto !=null) {
      caResult.setPoints(caResultDto.getPoints());
      caResult.setRemark(caResultDto.getRemark());

      System.out.println(caResultDto);
      System.out.print("=============================================================END===========================================================");
      caResultRepository.save(caResult);
    }
    return null;
  }

}
