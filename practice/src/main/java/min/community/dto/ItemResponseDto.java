package min.community.dto;


import lombok.Data;

@Data
public class ItemResponseDto {
    private Long id;

    public ItemResponseDto(Long id) {
        this.id = id;
    }
}
