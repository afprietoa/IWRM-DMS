package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.controller;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IMeasurementHandler;
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
@RequiredArgsConstructor
public class MeasurementController {
    private IMeasurementHandler measurementHandler;

    @Operation(summary = "Create measurement",
            responses = {
                    @ApiResponse(responseCode = "201", description = "measurement created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "measurement create fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("measurement")
    public ResponseEntity<Map<String,String>> createMeasurement(@Valid @RequestBody MeasurementCreateRequestDto measurementCreateRequestDto){
        measurementHandler.createMeasurement(measurementCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, MEASUREMENT_CREATED_MESSAGE));
    }

    @Operation(summary = "Updated a measurement",
            responses = {
                    @ApiResponse(responseCode = "201", description = "measurement updated successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "measurement update fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("measurement")
    public ResponseEntity<Map<String,String>> updateMeasurement(@Valid @PathVariable Integer idMeasurement, @RequestBody MeasurementUpdateRequestDto measurementUpdateRequestDto){
        measurementHandler.updateMeasurement(idMeasurement, measurementUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, MEASUREMENT_UPDATED_MESSAGE));
    }

    @Operation(summary = "Get measurement Pagination",
            responses = {
                    @ApiResponse(responseCode = "201", description = "measurement pagination was successful",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "measurement pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("measurement/allByPagination")
    public Page<MeasurementPaginationResponseDto> getPaginationMeasurement(@RequestParam Integer pageSize, @RequestParam String sortBy){
        return measurementHandler.getPaginationMeasurement(pageSize, sortBy);
    }

    @Operation(summary = "Get measurement List",
            responses = {
                    @ApiResponse(responseCode = "201", description = "measurement pagination was successful.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "measurement pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("measurement/allByList")
    public List<MeasurementListResponseDto> getListMeasurement(){
        return measurementHandler.getListMeasurement();
    }

    @Operation(summary = "Get measurement",
            responses = {
                    @ApiResponse(responseCode = "200", description = "measurement returned.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "measurement not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("measurement/{idMeasurement}")
    public ResponseEntity<MeasurementResponseDto> getMeasurement(@PathVariable Integer idMeasurement) {
        return ResponseEntity.ok(measurementHandler.getMeasurement(idMeasurement));
    }


    @Operation(summary = "Delete measurement",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete measurement successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete measurement fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("measurement/{idMeasurement}")
    public ResponseEntity<Map<String, String>> deleteMeasurement(@PathVariable Integer idMeasurement){
        measurementHandler.deleteMeasurement(idMeasurement);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, MEASUREMENT_DELETED_MESSAGE));
    }
}
