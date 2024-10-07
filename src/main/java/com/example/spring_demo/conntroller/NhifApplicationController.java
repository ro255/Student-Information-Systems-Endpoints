package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.NhifApplicationDto;
import com.example.spring_demo.models.NhifApplication;
import com.example.spring_demo.services.NhifApplicationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class NhifApplicationController {

  private static final Logger logger = LoggerFactory.getLogger(NhifApplicationController.class);


  @Autowired
  private final NhifApplicationService nhifApplicationService;

  @PostMapping("/nhifCard")
  public ResponseEntity<NhifApplication> nhifApplications(@RequestBody NhifApplicationDto nhifApplicationDto) {
    logger.info("Received NhifApplicationDto: {}", nhifApplicationDto);

    if (nhifApplicationDto == null) {
      logger.error("NhifApplicationDto is null");
      return ResponseEntity.badRequest().body(null);
    }
    NhifApplication nhifApplication = nhifApplicationService.nhifApplications(nhifApplicationDto);
    return ResponseEntity.ok(nhifApplication);

  }

  @GetMapping("/applicants")
  public ResponseEntity<List<NhifApplication>> getApplicants(){
    List<NhifApplication> nhifApplication = nhifApplicationService.getAllApplicants();
    return ResponseEntity.ok(nhifApplication);

  }

  @PutMapping("/nhifCard/{cardId}")
  public ResponseEntity<NhifApplication> UpdateNhifCard(@PathVariable Long cardId, @RequestBody NhifApplicationDto nhifApplicationDto){
    NhifApplication nhifApplication = nhifApplicationService.UpdateNhifCard(cardId,nhifApplicationDto);
    return ResponseEntity.ok(nhifApplication);

  }

  @DeleteMapping("/nhifCard/{cardId}")
  public ResponseEntity<Void> DeleteNhifCard(@PathVariable Long cardId){
    nhifApplicationService.DeleteNhifCard(cardId);
   return ResponseEntity.ok().build();

  }

}
