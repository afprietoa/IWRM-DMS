package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.controller;


import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IEventHandler;
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
public class EventRestController {

    private IEventHandler eventHandler;

    @Operation(summary = "Create Event",
            responses = {
                    @ApiResponse(responseCode = "201", description = "event created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "event create fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("event")
    public ResponseEntity<Map<String,String>> createevent(@Valid @RequestBody EventCreateRequestDto eventCreateRequestDto){
        eventHandler.createEvent(eventCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, EVENT_CREATED_MESSAGE));
    }

    @Operation(summary = "Updated a Event",
            responses = {
                    @ApiResponse(responseCode = "201", description = "event updated successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "event update fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("event")
    public ResponseEntity<Map<String,String>> updateEvent(@Valid @PathVariable Integer idEvent, @RequestBody EventUpdateRequestDto eventUpdateRequestDto){
        eventHandler.updateEvent(idEvent, eventUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, EVENT_UPDATED_MESSAGE));
    }

    @Operation(summary = "Get Event Pagination",
            responses = {
                    @ApiResponse(responseCode = "201", description = "event pagination was successful",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "event pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("event/allByPagination")
    public Page<EventPaginationResponseDto> getPaginationEvent(@RequestParam Integer pageSize, @RequestParam String sortBy){
        return eventHandler.getPaginationEvent(pageSize, sortBy);
    }

    @Operation(summary = "Get Event List",
            responses = {
                    @ApiResponse(responseCode = "201", description = "event pagination was successful.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "event pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("event/allByList")
    public List<EventListResponseDto> getListEvent(){
        return eventHandler.getListEvent();
    }

    @Operation(summary = "Get Event",
            responses = {
                    @ApiResponse(responseCode = "200", description = "event returned.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "event not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("event/{idEvent}")
    public ResponseEntity<EventResponseDto> getEvent(@PathVariable Integer idEvent) {
        return ResponseEntity.ok(eventHandler.getEvent(idEvent));
    }


    @Operation(summary = "Delete Event",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete event successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete event fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("event/{idEvent}")
    public ResponseEntity<Map<String, String>> deleteEvent(@PathVariable Integer idEvent){
        eventHandler.deleteEvent(idEvent);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, EVENT_DELETED_MESSAGE));
    }
}
