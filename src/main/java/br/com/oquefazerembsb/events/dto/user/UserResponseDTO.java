package br.com.oquefazerembsb.events.dto.user;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Integer userID;
    private String userName;
    private String userEmail;
}
