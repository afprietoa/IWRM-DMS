package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.controller;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IPollutantHandler;
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
public class PollutantRestController {
    private final IPollutantHandler pollutantHandler;

    @Operation(summary = "Create pollutant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "pollutant created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "pollutant create fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("pollutant")
    public ResponseEntity<Map<String,String>> createPollutant(@Valid @RequestBody PollutantCreateRequestDto pollutantCreateRequestDto){
        pollutantHandler.createPollutant(pollutantCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, POLLUTANT_CREATED_MESSAGE));
    }

    @Operation(summary = "Updated a pollutant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "pollutant updated successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "pollutant update fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("pollutant")
    public ResponseEntity<Map<String,String>> updatePollutant(@Valid @RequestBody PollutantUpdateRequestDto pollutantUpdateRequestDto){
        pollutantHandler.updatePollutant(pollutantUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, POLLUTANT_UPDATED_MESSAGE));
    }

    @Operation(summary = "Get pollutant Pagination",
            responses = {
                    @ApiResponse(responseCode = "201", description = "pollutant pagination was successful",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "pollutant pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("pollutant/allByPagination")
    public Page<PollutantPaginationResponseDto> getPaginationPollutant(@RequestParam Integer pageSize, @RequestParam String sortBy){
        return pollutantHandler.getPaginationPollutant(pageSize, sortBy);
    }

    @Operation(summary = "Get pollutant List",
            responses = {
                    @ApiResponse(responseCode = "201", description = "pollutant pagination was successful.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "pollutant pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("pollutant/allByList")
    public List<PollutantListResponseDto> getListPollutant(){
        return pollutantHandler.getListPollutant();
    }

    @Operation(summary = "Get pollutant",
            responses = {
                    @ApiResponse(responseCode = "200", description = "pollutant returned.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "pollutant not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("pollutant/{idPollutant}")
    public ResponseEntity<PollutantResponseDto> getPollutant(@PathVariable Integer idPollutant) {
        return ResponseEntity.ok(pollutantHandler.getPollutant(idPollutant));
    }


    @Operation(summary = "Delete pollutant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete pollutant successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete pollutant fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("pollutant/{idPollutant}")
    public ResponseEntity<Map<String, String>> deletePollutant(@PathVariable Integer idPollutant){
        pollutantHandler.deletePollutant(idPollutant);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, POLLUTANT_DELETED_MESSAGE));
    }
}
