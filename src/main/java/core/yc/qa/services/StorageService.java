package core.yc.qa.services;

import core.yc.qa.models.UploadFileResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    //void init();

    UploadFileResponse store(MultipartFile file, String platform);

    //Stream<Path> loadAll();

    //Path load(String filename);

    //Resource loadAsResource(String filename);

    //void deleteAll();
}
