/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.11.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package pm.little.api.controllers;

import jakarta.annotation.Generated;
import pm.little.api.models.Media;

import java.io.IOException;
import java.util.UUID;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-07T19:49:07.297619+02:00[Europe/Prague]", comments = "Generator version: 7.11.0")
@Validated
@Tag(name = "media", description = "Media resources")
public interface MediaApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /media : (Optional) List media items
     *
     * @param limit Limit of the list (required)
     * @param offset Offset of the list (required)
     * @return A list of media (status code 200)
     */
    @Operation(
        operationId = "mediaGet",
        summary = "(Optional) List media items",
        tags = { "media" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of media", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Media.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/media",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Media>> mediaGet(
        @NotNull @Parameter(name = "limit", description = "Limit of the list", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = true) Integer limit,
        @NotNull @Parameter(name = "offset", description = "Offset of the list", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = true) Integer offset
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"description\" : \"description\", \"mediaUUID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"video\", \"title\" : \"title\", \"url\" : \"\" }, { \"description\" : \"description\", \"mediaUUID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"video\", \"title\" : \"title\", \"url\" : \"\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /media/{media_uuid} : Delete media (admin only)
     *
     * @param mediaUuid The UUID of the media resource (required)
     * @return No Content (status code 204)
     */
    @Operation(
        operationId = "mediaMediaUuidDelete",
        summary = "Delete media (admin only)",
        tags = { "media" },
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content")
        },
        security = {
            @SecurityRequirement(name = "admin_jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/media/{media_uuid}"
    )
    
    default ResponseEntity<Void> mediaMediaUuidDelete(
        @Parameter(name = "media_uuid", description = "The UUID of the media resource", required = true, in = ParameterIn.PATH) @PathVariable("media_uuid") UUID mediaUuid
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /media/{media_uuid} : Get media metadata
     *
     * @param mediaUuid The UUID of the media resource (required)
     * @return Media metadata (status code 200)
     */
    @Operation(
        operationId = "mediaMediaUuidGet",
        summary = "Get media metadata",
        tags = { "media" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Media metadata", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Media.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/media/{media_uuid}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Media> mediaMediaUuidGet(
        @Parameter(name = "media_uuid", description = "The UUID of the media resource", required = true, in = ParameterIn.PATH) @PathVariable("media_uuid") UUID mediaUuid
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"description\" : \"description\", \"mediaUUID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"video\", \"title\" : \"title\", \"url\" : \"\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /media/{media_uuid} : Update media metadata (admin only)
     *
     * @param mediaUuid The UUID of the media resource (required)
     * @param media  (required)
     * @return Updated media metadata (status code 200)
     */
    @Operation(
        operationId = "mediaMediaUuidPut",
        summary = "Update media metadata (admin only)",
        tags = { "media" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Updated media metadata", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Media.class))
            })
        },
        security = {
            @SecurityRequirement(name = "admin_jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/media/{media_uuid}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Media> mediaMediaUuidPut(
        @Parameter(name = "media_uuid", description = "The UUID of the media resource", required = true, in = ParameterIn.PATH) @PathVariable("media_uuid") UUID mediaUuid,
        @Parameter(name = "Media", description = "", required = true) @Valid @RequestBody Media media
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"description\" : \"description\", \"mediaUUID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"video\", \"title\" : \"title\", \"url\" : \"\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /media : Upload new media (admin only)
     *
     * @param file The file to upload (required)
     * @param title Media title (optional)
     * @param type Media type (e.g. video, image, etc.) (optional)
     * @param description Media description (optional)
     * @return The uploaded media metadata (status code 200)
     */
    @Operation(
        operationId = "mediaPostMultipart",
        summary = "Upload new media (admin only)",
        tags = { "media" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The uploaded media metadata", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Media.class))
            })
        },
        security = {
            @SecurityRequirement(name = "admin_jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/media",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    
    default ResponseEntity<Media> mediaPostMultipart(
        @Parameter(name = "file", description = "The file to upload", required = true) @RequestPart(value = "file", required = true) MultipartFile file,
        @Parameter(name = "title", description = "Media title") @Valid @RequestParam(value = "title", required = false) String title,
        @Parameter(name = "type", description = "Media type (e.g. video, image, etc.)") @Valid @RequestParam(value = "type", required = false) String type,
        @Parameter(name = "description", description = "Media description") @Valid @RequestParam(value = "description", required = false) String description
    ) throws IOException {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"description\" : \"description\", \"mediaUUID\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"type\" : \"video\", \"title\" : \"title\", \"url\" : \"\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
