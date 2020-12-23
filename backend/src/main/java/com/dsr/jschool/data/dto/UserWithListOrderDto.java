package com.dsr.jschool.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithListOrderDto {

    private Long id;
    private String name;
    private List<RoleDto> roles;
    private List<OrderDto> orders;
}
