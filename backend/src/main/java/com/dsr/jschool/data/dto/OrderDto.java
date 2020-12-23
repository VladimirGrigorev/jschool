package com.dsr.jschool.data.dto;

import com.dsr.jschool.data.dto.sparepart.SparePartDto;
import com.dsr.jschool.data.entity.SparePart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Date date;
    private SparePartDto sparePart;
}
