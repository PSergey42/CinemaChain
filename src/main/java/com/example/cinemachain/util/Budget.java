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
        List<Long> s = Arrays.stream(budget.split("-")).map(Long::parseLong).toList();
        return new Budget(s.get(1), s.get(0));
    }
}
