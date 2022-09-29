package core.yc.qa.services;

import core.yc.qa.exception.model.StorageException;
import core.yc.qa.models.UploadFileResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;


@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Value("${file.upload-dir}")
    private String uploadFolderRoot;

    @Override
    public UploadFileResponse store(final MultipartFile file, final String platform) {

        final UploadFileResponse uploadFileResponse = new UploadFileResponse();

        // ../{file.upload-dir}/{date}/{platform}/
        final Path destinationPath = Paths.get(uploadFolderRoot, LocalDate.now().toString(), platform);

        if (file.isEmpty()) {
            throw new StorageException("The file is empty.");
        }

        try {

            // Check the destination before upload
            if(!Files.exists(destinationPath)){
                Files.createDirectories(destinationPath);
            }

            // Get the file and save it somewhere
            Files.copy(file.getInputStream(), Paths.get(destinationPath.toString(), file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            uploadFileResponse
                    .setFileName(file.getOriginalFilename())
                    .setFileType(file.getContentType())
                    .setPlatform(platform)
                    .setSize(file.getSize())
                    .setMd5(DigestUtils.md5Hex(file.getInputStream()))
                    .setSha256(DigestUtils.sha256Hex(file.getInputStream()));

        } catch (IOException e) {
            log.error("Can't save the file [{}] in location [{}]", file.getOriginalFilename(), destinationPath, e);
        }

        log.info("Save file: {}", uploadFileResponse);
        return uploadFileResponse;
    }
}