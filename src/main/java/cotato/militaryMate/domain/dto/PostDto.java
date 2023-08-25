package cotato.militaryMate.domain.dto;

import lombok.*;
import org.springframework.lang.Nullable;

public class PostDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetPost {

        @Nullable
        private long id;

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
