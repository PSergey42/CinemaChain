package com.example.cinemachain.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class Budget {
    private long up;
    private long down;

    public static Budget parseBudget(String budget){
        String[] s = budget.split("-");
        return new Budget(Long.parseLong(s[1]), Long.parseLong(s[0]));
    }
}
