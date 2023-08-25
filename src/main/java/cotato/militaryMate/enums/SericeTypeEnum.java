package cotato.militaryMate.enums;

import lombok.Getter;

@Getter
public enum SericeTypeEnum {
    ARMY("육군"),
    NAVY("해군"),
    MARINE("해병대");
    String type;

    SericeTypeEnum(String type) {
        this.type = type;
    }

}
