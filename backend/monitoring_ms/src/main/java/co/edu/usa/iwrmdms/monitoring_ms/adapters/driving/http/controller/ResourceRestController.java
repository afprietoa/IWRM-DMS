package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.controller;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IResourceHandler;
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
import static co.edu.usa.iwrmdms.monitoring_ms.configuration.Constants.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResourceRestController {
    private IResourceHandler resourceHandler;

    @Operation(summary = "Create Resource",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Resource create fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("resource")
    public ResponseEntity<Map<String,String>> createResource(@Valid @RequestBody ResourceCreateRequestDto resourceCreateRequestDto){
        resourceHandler.createResource(resourceCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, RESOURCE_CREATED_MESSAGE));
    }

    @Operation(summary = "Updated a Resource",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource updated successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Resource update fail.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("resource")
    public ResponseEntity<Map<String,String>> updateResource(@Valid @PathVariable Integer idResource, @RequestBody ResourceUpdateRequestDto resourceUpdateRequestDto){
        resourceHandler.updateResource(idResource, resourceUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, RESOURCE_UPDATED_MESSAGE));
    }

    @Operation(summary = "Get Resource Pagination",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource pagination was successful",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Resource pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("resource/allByPagination")
    public Page<ResourcePaginationResponseDto> getPaginationResource(@RequestParam Integer pageSize, @RequestParam String sortBy){
        return resourceHandler.getPaginationResource(pageSize, sortBy);
    }

    @Operation(summary = "Get Resource List",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource pagination was successful.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Resource pagination failed.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("resource/allByList")
    public List<ResourceListResponseDto> getListResource(){
        return resourceHandler.getListResource();
    }

    @Operation(summary = "Get Resource",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource returned.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "Resource not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("resource/{idResource}")
    public ResponseEntity<ResourceResponseDto> getResource(@PathVariable Integer idResource) {
        return ResponseEntity.ok(resourceHandler.getResource(idResource));
    }


    @Operation(summary = "Delete Resource",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Delete resource successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Delete resource fail",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("resource/{idResource}")
    public ResponseEntity<Map<String, String>> deleteResource(@PathVariable Integer idResource){
        resourceHandler.deleteResource(idResource);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, RESOURCE_DELETED_MESSAGE));
    }
}
