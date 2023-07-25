package min.community.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import min.community.dao.Member;
import min.community.dao.Posts;
import min.community.dto.MemberRequestDto;
import min.community.dto.MemberResponseDto;
import min.community.dto.PostsRequestDto;
import min.community.dto.PostsResponseDto;
import min.community.service.MemberService;
import min.community.service.PostsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final MemberService memberService;
    private final PostsService postsService;

    @PostMapping("/api/members")
    public MemberResponseDto save(@RequestBody @Valid MemberRequestDto request) {
        Member member = new Member();
        member.setName(request.getName());
        member.setPw(request.getPw());

        Long id = memberService.join(member);

        return new MemberResponseDto(id);
    }

    @PostMapping("/api/posts")
    public PostsResponseDto upload(@RequestBody @Valid PostsRequestDto request) {
        Posts posts = new Posts();
        posts.setTitle(request.getTitle());
        posts.setContent(request.getContent());

        Long id = postsService.upload(posts);

        return new PostsResponseDto(id);
    }
}
