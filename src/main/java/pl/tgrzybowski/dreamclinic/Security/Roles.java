package pl.tgrzybowski.dreamclinic.Security;

public enum Roles {
    PATIENT,
    ADMIN,
    DOCTOR,
    EMPLOYEE,
    ANONYMOUS;

    public String toString() {
        return "ROLE_" + this.name();
    }

    public static Roles roleOf(String role) {
        String splited = role.split("_")[1];
        return Roles.valueOf(splited);
    }
}
