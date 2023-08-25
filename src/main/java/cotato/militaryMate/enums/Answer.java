package cotato.militaryMate.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Answer {
    YES(0), NO(1);

    private final Integer status;

    @JsonValue
    public Integer getStatus() {
        return this.status;
    }

}
