package org.finfour.project.service;

import org.finfour.project.dto.FileDto;
import org.finfour.project.model.FileEntity;

public interface FileEntityConverter {

    FileDto toDto (FileEntity fileEntity);

    FileEntity fromDto (FileDto fileDto);

}
