package com.example.customerSimpleCrudDemo.jpa.been;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
@EntityListeners(AuditingEntityListener.class)
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME",nullable = false,length = 100)
    private String name;
    @Column(name = "PHONE",nullable = true,length = 10)
    private String phone;
    @Column(name = "ADDRESS",nullable = true,length = 100)
    private String address;
    @Column(name = "EMAIL",nullable = false,length = 20)
    private String email;
    @CreatedBy
    @Column(name = "CREATOR",nullable = false,length = 100)
    private String creator;
    @LastModifiedBy
    @Column(name = "LASTMODIFIEDBY",nullable = false,length = 100)
    private String lastModifiedBy;
    @CreatedDate
    @Column(name = "CREATEAT",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "UPDATEAT",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedDate;

}
