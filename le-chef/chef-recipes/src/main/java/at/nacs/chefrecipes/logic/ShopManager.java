package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopManager {

    private final ShopRepository shopRepository;

}
