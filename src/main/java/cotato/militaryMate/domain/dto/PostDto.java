package cotato.militaryMate.domain.dto;

import lombok.*;

public class PostDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class getPost{
        private String title;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String title;
        private String content;
    }



}
