package com.example.manifest.service;

import com.example.manifest.Entity.File;
import com.example.manifest.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    @Autowired
    private  FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void saveFile(MultipartFile inputFile) throws IOException {
        byte[] data = inputFile.getBytes();

        File file = new File();
        file.setData(data);

        fileRepository.save(file);
    }
}