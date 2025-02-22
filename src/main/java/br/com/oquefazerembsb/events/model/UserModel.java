package br.com.oquefazerembsb.events.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;

    @Column(name = "user_email", length = 255, nullable = false, unique = true)
    private String userEmail;
}
