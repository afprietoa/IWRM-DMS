package co.edu.usa.iwrmdms.user_ms.adapters.driving.controller;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.ProfileRequestDto;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.IProfileHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import static co.edu.usa.iwrmdms.user_ms.configuration.Constants.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileRestController {
    private final IProfileHandler personHandler;

    @Operation(summary = "Add a new profile",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Profile created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Profile already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/profile")
    public ResponseEntity<Map<String, String>> createProfile(@RequestBody ProfileRequestDto profileRequestDto) {
        personHandler.createProfile(profileRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, PROFILE_CREATED_MESSAGE));
    }

    @Operation(summary = "Edit an existing profile",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Profile updated",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PatchMapping("/profile/{id}")
    public ResponseEntity<Map<String, String>> updateProfile(@PathVariable Long id, @RequestBody ProfileRequestDto profileRequestDto) {
        personHandler.updateProfile(id, profileRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(RESPONSE_MESSAGE_KEY, PROFILE_UPDATED_MESSAGE));
    }
}
