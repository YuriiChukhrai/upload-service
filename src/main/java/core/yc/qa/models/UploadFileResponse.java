package core.yc.qa.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@JacksonXmlRootElement(localName = "upload_file_response")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Accessors(chain = true)
@ToString
@Schema(name="UploadFileResponse", description = "Representation of model upload file response")
public final class UploadFileResponse {

    private String fileName;
    private String platform;
    private String fileType;

    private long size;
    private String sha256;
    private String md5;
}
