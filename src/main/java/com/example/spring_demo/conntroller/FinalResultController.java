package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.FinalResultDto;
import com.example.spring_demo.models.FinalResult;
import com.example.spring_demo.services.FinalResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class FinalResultController {

  @Autowired
  private final FinalResultService finalResultService;

  @PostMapping("/result")
  public ResponseEntity<FinalResult> createResult(@RequestBody FinalResultDto finalResultDto) {
    System.out.println("finalResultDto"+finalResultDto);
    if (finalResultDto == null) {
      return ResponseEntity.badRequest().body(null);
    }
    FinalResult finalResult = finalResultService.createResult(finalResultDto);
    return ResponseEntity.ok(finalResult);

  }

  @GetMapping("/final_results")
  public ResponseEntity<List<FinalResult>> getResults(){
    List<FinalResult> finalResults= finalResultService.getResults();
    return ResponseEntity.ok(finalResults);
  }

 @PutMapping("/result/{result_id}")
  public ResponseEntity<FinalResult> updateResult(@PathVariable Long result_id,@RequestBody FinalResultDto finalResultDto){
    FinalResult finalResult=finalResultService.updateResult(result_id,finalResultDto);
    return ResponseEntity.ok(finalResult);
 }

 @DeleteMapping("/result/{result_id}")
  public ResponseEntity<FinalResult> deleteResult(@PathVariable Long result_id){
    finalResultService.deleteResult(result_id);
    return ResponseEntity.ok().build();

 }
}
