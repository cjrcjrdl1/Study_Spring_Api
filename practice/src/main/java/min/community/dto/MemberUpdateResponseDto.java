package min.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberUpdateResponseDto {

    private Long id;
    private String pw;

}
