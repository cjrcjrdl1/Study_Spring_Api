package min.community.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import min.community.dao.Item;
import min.community.dao.Member;
import min.community.dao.Posts;
import min.community.dto.*;
import min.community.service.ItemService;
import min.community.service.MemberService;
import min.community.service.PostsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final MemberService memberService;
    private final PostsService postsService;

    private final ItemService itemService;

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

    @PostMapping("/api/item")
    public ItemResponseDto createItem(@RequestBody @Valid ItemRequestDto request) {
        Item item = new Item();
        item.setItemName(request.getItemName());
        item.setItemQuantity(request.getItemQuantity());

        Long id = itemService.createItem(item);

        return new ItemResponseDto(id);
    }

    @PutMapping("/api/members/{id}")
    public MemberUpdateResponseDto updateMember(@PathVariable("id") Long id,
                                                @RequestBody @Valid MemberUpdateRequestDto request) {
        memberService.update(id, request.getPw());
        Member findMember = memberService.findOne(id);
        return new MemberUpdateResponseDto(findMember.getId(), findMember.getPw());
    }

    @GetMapping("/api/members")
    public Result memberList() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return new Result(collect);
    }


}
