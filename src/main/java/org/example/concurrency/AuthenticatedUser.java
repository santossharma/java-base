package org.example.concurrency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by santoshsharma on 03 May, 2022, at 23:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticatedUser {
    private int userId;
    private String name;
    private int[] roleIds;
}
