package com.oddbie.wannyback.todo.model;

import javax.persistence.Column;
import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class TodoRequestDto {
    @Column(nullable = false, length = 50)
    private String item;

    @Column(length = 20)
    private String category;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dueDate;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date finishDate;

    public TodoRequestDto(String item, String category) {
        this.item = item;
        this.category = category;
    }
}
