package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.controller;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IAlertHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import static co.edu.usa.iwrmdms.monitoring_ms.configuration.Constants.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AlertRestController {
    private final IAlertHandler alertHandler;

    @Operation(summary = "Create Alert",
            responses = {
                    @ApiResponse(responseCode = "201", description = "alert created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "alert create fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("alert")
    public ResponseEntity<Map<String,String>> createAlert(@Valid @RequestBody AlertCreateRequestDto alertCreateRequestDto){
        alertHandler.createAlert(alertCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, ALERT_CREATED_MESSAGE));
    }

    @Operation(summary = "Updated a Alert",
            responses = {
                    @ApiResponse(responseCode = "201", description = "alert updated successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "alert update fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("alert")
    public ResponseEntity<Map<String,String>> updateAlert(@Valid @RequestBody AlertUpdateRequestDto alertUpdateRequestDto){
        alertHandler.updateAlert(alertUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, ALERT_UPDATED_MESSAGE));
    }

    @Operation(summary = "Get Alert Pagination",
            responses = {
                    @ApiResponse(responseCode = "201", description = "alert pagination was successful",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "alert pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("alert/allByPagination")
    public Page<AlertPaginationResponseDto> getPaginationAlert(@RequestParam Integer pageSize, @RequestParam String sortBy){
        return alertHandler.getPaginationAlert(pageSize, sortBy);
    }

    @Operation(summary = "Get Alert List",
            responses = {
                    @ApiResponse(responseCode = "201", description = "alert pagination was successful.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "alert pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("alert/allByList")
    public List<AlertListResponseDto> getListAlert(){
        return alertHandler.getListAlert();
    }

    @Operation(summary = "Get Alert",
            responses = {
                    @ApiResponse(responseCode = "200", description = "alert returned.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "alert not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("alert/{idAlert}")
    public ResponseEntity<AlertResponseDto> getAlert(@PathVariable Integer idAlert) {
        return ResponseEntity.ok(alertHandler.getAlert(idAlert));
    }


    @Operation(summary = "Delete Alert",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete alert successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete alert fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("alert/{idAlert}")
    public ResponseEntity<Map<String, String>> deleteAlert(@PathVariable Integer idAlert){
        alertHandler.deleteAlert(idAlert);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, ALERT_DELETED_MESSAGE));
    }
}
