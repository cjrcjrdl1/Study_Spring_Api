package min.community.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostsRequestDto {

    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
