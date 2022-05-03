package org.example.concurrency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by santoshsharma on 03 May, 2022, at 16:35
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String newJoiner;
    private String learningPending;
    private int salary;
    private int rating;
}
