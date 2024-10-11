package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.IptApplicationDto;
import com.example.spring_demo.models.IptApplication;
import com.example.spring_demo.services.IptApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class IptApplicationController {
  private final IptApplicationService iptApplicationService;

  @PostMapping("/ipt_applications")
  public ResponseEntity<IptApplication> createIptApplication(@RequestBody IptApplicationDto iptApplicationDto) {
    IptApplication iptApplication= iptApplicationService.createIptApplication(iptApplicationDto);
    return ResponseEntity.ok(iptApplication);
  }

  @GetMapping("/get_ipt_applications")
  public ResponseEntity<List<IptApplication>> getIptApplications() {
    List<IptApplication> iptApplications= iptApplicationService.getIptApplications();
    return ResponseEntity.ok(iptApplications);
  }

  @PutMapping("/ipt_applications/{ipt_application_id}")
  public ResponseEntity<IptApplication> updateIptApplication(@PathVariable Long ipt_application_id, @RequestBody IptApplicationDto iptApplicationDto) {
    IptApplication iptApplication= iptApplicationService.updateIptApplication(ipt_application_id,iptApplicationDto);
    return ResponseEntity.ok(iptApplication);
  }

  @DeleteMapping("/ipt_applications/{ipt_application_id}")
  public ResponseEntity<IptApplication> deleteIptApplication(@PathVariable Long ipt_application_id) {
    iptApplicationService.deleteIptApplication(ipt_application_id);
    return ResponseEntity.ok().build();
  }

}
