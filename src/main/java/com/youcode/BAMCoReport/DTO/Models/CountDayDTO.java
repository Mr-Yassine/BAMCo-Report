package com.youcode.BAMCoReport.DTO.Models;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(value = "Count", description = "Count Properties")
public class CountDayDTO {

    private String day;
    private int count;

}
