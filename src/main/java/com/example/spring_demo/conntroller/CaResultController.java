package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.CaResultDto;
import com.example.spring_demo.models.CaResult;
import com.example.spring_demo.services.CaResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CaResultController {

  @Autowired
  private final CaResultService caResultService;

  @PostMapping("/ca_results")
  public ResponseEntity<CaResult> createCaResult(@RequestBody CaResultDto caResultDto) {
    System.out.println("caResultDto"+caResultDto);
    if (caResultDto == null) {
      return ResponseEntity.badRequest().body(null);
    }
    CaResult caResult = caResultService.createCaResult(caResultDto);
    return ResponseEntity.ok(caResult);

  }

  @GetMapping("/get_ca_results")
  public ResponseEntity<List<CaResult>> getCaResults() {
    List<CaResult> caResults= caResultService.getCaResults();
    return ResponseEntity.ok(caResults);

  }

  @PutMapping("/ca_results/{ca_id}")
  public ResponseEntity<CaResult> updateCaResult(@PathVariable Long ca_id,@RequestBody CaResultDto caResultDto) {
   CaResult caResult= caResultService.updateCaResult(ca_id,caResultDto);
   return ResponseEntity.ok(caResult);

  }

  @DeleteMapping("/ca_results/{ca_id}")
  public ResponseEntity<CaResult> deleteCaResult(@PathVariable Long ca_id) {
    caResultService.deleteCaResult(ca_id);
    return ResponseEntity.ok().build();
  }

}

