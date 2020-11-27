package se.big.johanna.downupload.downupload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import se.big.johanna.downupload.downupload.model.FileDB;
import se.big.johanna.downupload.downupload.repository.FileDBRepository;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Autowired
    FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(fileDB);
    }

    public FileDB getFile(String id){
        var file = fileDBRepository.findById(id);
        // TODO: 2020-11-27 throw exception
        return file.orElse(null);
    }

    public Stream<FileDB> getAllFiles(){
        return fileDBRepository.findAll().stream();
    }
}
