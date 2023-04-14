package org.finfour.project.service;

import org.finfour.project.dto.FileDto;
import org.finfour.project.model.FileEntity;
import org.springframework.stereotype.Service;

@Service
public class FileEntityConverterImpl implements FileEntityConverter {
    @Override
    public FileDto toDto(FileEntity fileEntity) {
        return null;
    }

    @Override
    public FileEntity fromDto(FileDto fileDto) {
        return null;
    }
}
