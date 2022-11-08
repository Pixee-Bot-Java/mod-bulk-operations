/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.folio.pv.rest.resource;

import org.folio.pv.domain.dto.SearchResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-07T19:00:11.529445900+02:00[Europe/Helsinki]")
@Validated
@Tag(name = "to-be-changed", description = "the to-be-changed API")
public interface ToBeChangedApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /to-be-changed
     * example endpoint to generate api doc
     *
     * @return example endpoint result to generate api doc (status code 200)
     */
    @Operation(
        operationId = "exampleEndpointToGenerateApiDoc",
        responses = {
            @ApiResponse(responseCode = "200", description = "example endpoint result to generate api doc", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  SearchResult.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/to-be-changed",
        produces = { "application/json" }
    )
    default ResponseEntity<SearchResult> exampleEndpointToGenerateApiDoc(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"record\" : \"{}\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
