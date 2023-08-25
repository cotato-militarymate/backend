package cotato.militaryMate.enums;


import lombok.Getter;

@Getter
public enum ExcerciseAbilityEnum {
    HIGH("상"),
    MID("중"),
    LOW("하");
    String ability;

    ExcerciseAbilityEnum(String ability) {
        this.ability = ability;
    }
}
