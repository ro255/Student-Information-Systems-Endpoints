package com.example.spring_demo.servicesImpl;

import com.example.spring_demo.Dto.FinalResultDto;
import com.example.spring_demo.models.FinalResult;
import com.example.spring_demo.respositories.FinalResultRepository;
import com.example.spring_demo.services.FinalResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinalResultServiceImpl implements FinalResultService {

  @Autowired
  private final FinalResultRepository finalResultRepository;

  public FinalResultServiceImpl(FinalResultRepository finalResultRepository) {
    this.finalResultRepository = finalResultRepository;

  }


  @Override
  public FinalResult createResult(FinalResultDto finalResultDto) {
    System.out.println(finalResultDto);
    System.out.println("=====================START===========================");

    FinalResult finalResult = new FinalResult();
    finalResult.setGrade(finalResultDto.getGrade());
    finalResult.setPoints(finalResultDto.getPoints());
    finalResult.setRemark(finalResultDto.getRemark());
    finalResult.setCourse_code(finalResultDto.getCourse_code());
    finalResult.setCourse_name(finalResultDto.getCourse_name());
    finalResult.setUnit(finalResultDto.getUnit());

    System.out.println(finalResult);
    System.out.println("====================END===============================");

    return finalResultRepository.save(finalResult);


  }

  @Override
  public List<FinalResult> getResults() {
    return finalResultRepository.findAll();
  }

  @Override
  public FinalResult updateResult(Long resultId, FinalResultDto finalResultDto) {
    FinalResult finalResult = finalResultRepository.findById(resultId).get();
    if(finalResult != null) {
      finalResult.setGrade(finalResultDto.getGrade());
      finalResult.setPoints(finalResultDto.getPoints());
      finalResult.setRemark(finalResultDto.getRemark());
      finalResult.setCourse_code(finalResultDto.getCourse_code());
      finalResult.setCourse_name(finalResultDto.getCourse_name());
      finalResult.setUnit(finalResultDto.getUnit());
      return finalResultRepository.save(finalResult);
    } else {
      return null;
    }

  }

  @Override
  public void deleteResult(Long resultId) {
    finalResultRepository.deleteById(resultId);

  }
}
