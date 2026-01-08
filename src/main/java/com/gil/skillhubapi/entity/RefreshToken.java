package com.gil.skillhubapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "refresh_tokens", schema = "skillhub")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefreshToken {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private Long userId;

    @Column( nullable = false, unique = true )
    private String token;

    private LocalDateTime expiryDate;

    private Boolean revoked;
}
