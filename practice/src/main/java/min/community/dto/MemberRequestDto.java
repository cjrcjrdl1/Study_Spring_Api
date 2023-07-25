package min.community.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberRequestDto {
    @NotEmpty
    private String pw;

    @NotEmpty
    private String name;
}
