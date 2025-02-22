package br.com.oquefazerembsb.events.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    private String userName;
    private String userEmail;
}
