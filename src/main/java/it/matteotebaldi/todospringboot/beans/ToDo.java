package it.matteotebaldi.todospringboot.beans;

import lombok.Data;

@Data
public class ToDo {
    private Long id;
    private String title;
    private String description;
}
