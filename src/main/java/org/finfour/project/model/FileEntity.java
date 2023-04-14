package org.finfour.project.model;

import javax.persistence.*;

@Entity
@Table(name = "file_entity")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // можно заменить на GenerationType.IDENTITY тогда не будет сквозной нумерации
    private int id;

    public FileEntity() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


