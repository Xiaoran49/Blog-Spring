package com.example.synu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberQuery {
    private Integer id;
    private String name;
    private String sex;
    private Integer salary;
    private String department;
    private Integer age;
    private Integer delFlag;
}
