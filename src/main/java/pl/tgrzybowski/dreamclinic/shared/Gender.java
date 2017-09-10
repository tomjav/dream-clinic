package pl.tgrzybowski.dreamclinic.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    M("man"), W("woman");

    String label;
}
