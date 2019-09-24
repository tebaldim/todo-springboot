package it.matteotebaldi.todospringboot.beans;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class BrowseResult<T> {
    private List<T> resultsList = new LinkedList<>();
    private Long count;
}
