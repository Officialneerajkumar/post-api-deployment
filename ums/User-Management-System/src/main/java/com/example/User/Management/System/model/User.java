package com.example.User.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;

}
