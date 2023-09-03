package in.sp.main.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarResponseDTO
{
    private Integer car_id;
    private String carcompany;
    private String carcolor;
    private String carmodel;
    private String cartype;
    private String carimage;
    private String car360;
    private String carowner;
    private String numberplate;
    private LocalDate regdate;
    private String insurance;
    private LocalDate insurancevalidity;
    private String passengercapacity;
    private String fueltype;
    private String features;
    private String totalrunning;
    private int charge;

}
