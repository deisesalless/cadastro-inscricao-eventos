package br.com.oquefazerembsb.events.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class EventResponseDTO {
    private Integer eventID;
    private String title;
    private String prettyName;
    private String location;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
}
