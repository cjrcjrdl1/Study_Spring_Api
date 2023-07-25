package min.community.dto;

import lombok.Data;

@Data
public class PostsResponseDto {
    private Long id;

    public PostsResponseDto(Long id) {
        this.id = id;
    }
}
