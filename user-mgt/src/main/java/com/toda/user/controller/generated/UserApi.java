/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.toda.user.controller.generated;

import com.toda.user.model.dto.generated.ErrorVTO;
import com.toda.user.model.dto.generated.UserResultSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-10T00:48:20.900242300+03:00[Africa/Cairo]", comments = "Generator version: 7.10.0")
@Validated
public interface UserApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /users : Retrieve All Users With Pagination
     *
     * @param ids Comma-separated list of user IDs to retrieve (optional)
     * @param fullName  (optional)
     * @param pageNum  (optional, default to 0)
     * @param pageSize  (optional, default to 10)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users",
        produces = { "application/json" }
    )
    
    default ResponseEntity<UserResultSet> getUsersByIds(
         @Valid @RequestParam(value = "ids", required = false) List<Long> ids,
         @Valid @RequestParam(value = "fullName", required = false) String fullName,
         @Valid @RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
         @Valid @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"fullName\" : \"fullName\", \"id\" : 0 }, { \"fullName\" : \"fullName\", \"id\" : 0 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"domain\" : \"domain\", \"formErrors\" : [ { \"code\" : \"code\", \"attrName\" : \"attrName\" }, { \"code\" : \"code\", \"attrName\" : \"attrName\" } ], \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"domain\" : \"domain\", \"formErrors\" : [ { \"code\" : \"code\", \"attrName\" : \"attrName\" }, { \"code\" : \"code\", \"attrName\" : \"attrName\" } ], \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
