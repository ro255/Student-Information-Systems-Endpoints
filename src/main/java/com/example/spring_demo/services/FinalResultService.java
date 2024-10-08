package com.example.spring_demo.services;

import com.example.spring_demo.Dto.FinalResultDto;
import com.example.spring_demo.models.FinalResult;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface FinalResultService {

  FinalResult createResult(FinalResultDto finalResultDto);

  List<FinalResult> getResults();

  FinalResult updateResult(Long resultId, FinalResultDto finalResultDto);

  void deleteResult(Long resultId);

}
