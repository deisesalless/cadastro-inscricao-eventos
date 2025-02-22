package br.com.oquefazerembsb.events.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private Integer userID;
    private String userName;
    private String userEmail;
}
