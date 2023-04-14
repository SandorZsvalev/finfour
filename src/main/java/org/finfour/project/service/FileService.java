package org.finfour.project.service;

import org.finfour.project.dto.FileDto;

public interface FileService {

    FileDto getFile(Long documentId);
}
