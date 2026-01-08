package com.gil.skillhubapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table( name = "login_history", schema = "skillhub" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistory {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private Long userId;

    private String email;

    private String accessToken;

    @CreationTimestamp
    private LocalDate loginAt;

    //@PrePersist
    //void onLogin() {
       // this.loginAt = LocalDate.now();
    //} Usaremos a notation @CreationTimestamp
}
