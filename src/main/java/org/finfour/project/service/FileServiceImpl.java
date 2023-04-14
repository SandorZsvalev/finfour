package org.finfour.project.service;

import org.finfour.project.dto.FileDto;
import org.finfour.project.model.FileCache;
import org.finfour.project.model.FileEntity;
import org.finfour.project.repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileEntityRepository fileEntityRepository;

    @Autowired
    FileEntityConverter fileEntityConverter;

    private static final LinkedList<FileCache> FILE_CACHES = new LinkedList<>();
    private static final int CACHE_CAPACITY = 10;

    @Override
    public FileDto getFile(Long documentId) {
        int fromCacheIfExist = getFromCacheIfExist(documentId);
        if (fromCacheIfExist >= 0) {
            FileCache fileCache = FILE_CACHES.get(fromCacheIfExist);
            FILE_CACHES.remove(fileCache);
            FILE_CACHES.addFirst(fileCache);
            return fileCache.getFileDto();
        }
        FileEntity byId = fileEntityRepository.findById(documentId).get();
        FileDto fileDto = fileEntityConverter.toDto(byId);

        if (FILE_CACHES.size() >= CACHE_CAPACITY) {
            FILE_CACHES.removeLast();
        }

        FILE_CACHES.addFirst(new FileCache(documentId, fileDto));
        return fileDto;
    }

    private int getFromCacheIfExist(long documentIs) {
        return FILE_CACHES.indexOf(new FileCache(documentIs, null));
    }

    public List<FileCache> getCache() {
        return FILE_CACHES;
    }
}
