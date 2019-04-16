package at.nacs.themagic8ball;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class Magician {

    private final List<String> messages;
    private Random random = new Random();

    public String getMessageRandomly() {
        int index = random.nextInt(messages.size());
        return messages.get(index);
    }

}
