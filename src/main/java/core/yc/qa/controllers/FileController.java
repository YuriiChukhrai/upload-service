package core.yc.qa.controllers;

import core.yc.qa.models.UploadFileResponse;
import core.yc.qa.services.StorageService;
import core.yc.qa.util.QueryParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
class FileController {

    @Autowired
    private StorageService storageService;

    @Operation(summary = "Upload a file to the service storage folder.", method = "POST", operationId = "singleFileUpload")
    @ApiResponses(value = {@ApiResponse(content = @Content(schema = @Schema(implementation = UploadFileResponse.class)))})
    @PostMapping(value = "/upload", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UploadFileResponse singleFileUpload(

            @NotNull @RequestParam(value = QueryParams.FILE, required = true) @Parameter(in = ParameterIn.QUERY, name = QueryParams.FILE, schema = @Schema(implementation = MultipartFile.class)) MultipartFile file,
            @NotNull @RequestParam(value = QueryParams.PLATFORM, required = true) @Parameter(in = ParameterIn.QUERY, name = QueryParams.PLATFORM, schema = @Schema(implementation = String.class)) String platform

                                   ) {

        return storageService.store(file, platform);
    }



}
