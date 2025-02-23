package br.com.oquefazerembsb.events.dto.user;

import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    private String userName;
    private String userEmail;
}
