package com.custom_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.validation.constraints.Size;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "categories")
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Category extends BaseEntity {
    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String name;
}
