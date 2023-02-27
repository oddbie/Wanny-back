package com.oddbie.wannyback.todo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "todo")
@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, length = 50)
    private String item;

    @Column(length = 20)
    private String category;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dueDate;

    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date finishDate;
}
