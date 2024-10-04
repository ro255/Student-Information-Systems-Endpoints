package com.example.spring_demo.conntroller;

import com.example.spring_demo.models.CreateInvoice;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.CreateInvoiceRepository;
import com.example.spring_demo.services.CreateInvoiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class CreateInvoiceController {

  private final CreateInvoiveService createInvoiveService;
  private final CreateInvoiceRepository createInvoiceRepository;

  @PostMapping("/create_invoice")
  public ResponseEntity<?>  createInvoive(@RequestBody CreateInvoiceRequest createInvoiceRequest){
      try{
        ApiResponse<Void> apiResponse = new ApiResponse<>(
          HttpStatus.OK.value(),
          "The invoice submitted successfully",
          null
        );
        return ResponseEntity.ok().build();
      } catch (Exception e){
        ApiResponse<Void>  apiResponse = new ApiResponse<>(
          HttpStatus.BAD_REQUEST.value(),
          "The invoice failed to submitted",
          null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
      }

  }


  @GetMapping("/see_invoice")
  public ResponseEntity<List<CreateInvoice>> getInvoice(){
    List<CreateInvoice> createInvoices = createInvoiceRepository.findAll();
    if(createInvoices.isEmpty()){
      throw  new RuntimeException("There is no invoice found");


    } try {
      ApiResponse<List<CreateInvoice>> apiResponse = new ApiResponse<>(
        HttpStatus.OK.value(),
        "The invoice retrieved successfully",
        createInvoices
      );
      return ResponseEntity.ok(apiResponse.getData());
    } catch (Exception e){
      ApiResponse<List<CreateInvoice>> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "There is no any available invoice",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }


  @PutMapping("/create_invoice/{invoiceId}")
  public ResponseEntity<?> updateInvoice(@PathVariable Long invoiceId, @RequestBody CreateInvoiceRequest request){
    try{
        CreateInvoice createInvoice =createInvoiceRepository.findById(invoiceId).orElseThrow(() ->
          new RuntimeException("There is no invoice found"));
        createInvoice.setInvoiceNumber(request.getInvoiceNumber());
        createInvoice.setCurrency(request.getCurrency());
        createInvoice.setCategory(request.getCategory());
        createInvoice.setStatus(request.getStatus());
        createInvoiceRepository.save(createInvoice);

        ApiResponse<Void> apiResponse = new ApiResponse<>(
          HttpStatus.OK.value(),
          "The invoice created successfully",
          null
        );
     return ResponseEntity.ok().build();
    } catch(Exception e){
      ApiResponse<Void>  apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The invoice failed",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
  }


  @DeleteMapping("/create_invoice/{invoiceId}")
  public ResponseEntity<?> deleteInvoice(@PathVariable Long invoiceId){
     try{
       CreateInvoice createInvoice= createInvoiceRepository.findById(invoiceId).orElseThrow(() ->
         new RuntimeException("There is no invoice found:"+invoiceId));
           createInvoiceRepository.delete(createInvoice);

           ApiResponse<Void> apiResponse = new ApiResponse<>(
             HttpStatus.OK.value(),
             "The invoice was deleted successfully",
             null
           );
           return ResponseEntity.ok().build();

     } catch(Exception e){
       ApiResponse<Void>  apiResponse = new ApiResponse<>(
         HttpStatus.BAD_REQUEST.value(),
         "Failed to delete the invoice",
         null
       );
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
     }
  }

}
