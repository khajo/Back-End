package at.nacs.demo;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Builder
@Data
public class Runner {
    private String name;
    private Duration time;
}
