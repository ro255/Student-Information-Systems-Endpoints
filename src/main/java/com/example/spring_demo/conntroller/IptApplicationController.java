package com.example.spring_demo.conntroller;

import com.example.spring_demo.Dto.IptApplicationDto;
import com.example.spring_demo.models.IptApplication;
import com.example.spring_demo.services.IptApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class IptApplicationController {

  @Autowired
  private final IptApplicationService iptApplicationService;

  @PostMapping("/ipt")
  public ResponseEntity<IptApplication> iptApplication(@RequestBody IptApplicationDto iptApplicationDto) {
    IptApplication iptApplication = iptApplicationService.iptApplication(iptApplicationDto);
    return ResponseEntity.ok(iptApplication);

  }

  @GetMapping("/ipt_applications")
  public ResponseEntity<List<IptApplication>> iptApplications() {
    List<IptApplication> iptApplications = iptApplicationService.getAllIptApplications();
    return ResponseEntity.ok(iptApplications);

  }

  @PutMapping("/ipt/{ipt_application_id}")
  public ResponseEntity<?> updateIptApplication(@PathVariable Long ipt_application_id, @RequestBody IptApplicationDto iptApplicationDto) {
    IptApplication iptApplication = iptApplicationService.updateIptApplication(ipt_application_id, iptApplicationDto);
    return ResponseEntity.ok(iptApplication);

  }

  @DeleteMapping("/ipt/{ipt_application_id}")
  public ResponseEntity<Void> deleteIptApplication(@PathVariable Long ipt_application_id) {
    iptApplicationService.deleteIptApplication(ipt_application_id);
    return ResponseEntity.ok().build();
  }

}
