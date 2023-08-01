package min.community.service;

import lombok.RequiredArgsConstructor;
import min.community.dao.Item;
import min.community.dao.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long createItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

}
