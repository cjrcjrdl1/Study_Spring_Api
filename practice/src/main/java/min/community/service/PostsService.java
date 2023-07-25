package min.community.service;

import lombok.RequiredArgsConstructor;
import min.community.dao.Posts;
import min.community.dao.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long upload(Posts posts) {
        postsRepository.save(posts);
        return posts.getId();
    }
}
