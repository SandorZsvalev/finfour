package org.finfour.project.model;

import org.finfour.project.dto.FileDto;

import java.util.Objects;

public class FileCache {

    private Long id;
    private FileDto fileDto;

    public FileCache(Long id, FileDto fileDto) {
        this.id = id;
        this.fileDto = fileDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileDto getFileDto() {
        return fileDto;
    }

    public void setFileDto(FileDto fileDto) {
        this.fileDto = fileDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileCache fileCache = (FileCache) o;
        return Objects.equals(id, fileCache.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
