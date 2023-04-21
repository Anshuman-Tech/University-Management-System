package com.ums.university.management.system.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String emailId;
    private String dob;
    private String phone;
    private String guardianName;
    private String guardianPhone;
}
