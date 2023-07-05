package hexagonal.template.hexagonalmss.domain;

public class Member {
    private String ra;
    private String name;
    private String email;
    private String password;

    public Member(String ra, String name, String email, String password) {
        if (!validateRa(ra)) {
            throw new IllegalArgumentException("Invalid RA");
        }
        this.ra = ra;
        if (!validateName(name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
        if (!validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = password;
    }

    public String getRa() {
        return ra;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public Member(MemberDTO memberDTO) {
        if (!validateRa(memberDTO.getRa())) {
            throw new IllegalArgumentException("Invalid RA");
        }
        this.ra = memberDTO.getRa();
        if (!validateName(memberDTO.getName())) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = memberDTO.getName();
        if (!validateEmail(memberDTO.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = memberDTO.getEmail();
        if (!validatePassword(memberDTO.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = memberDTO.getPassword();
    }

    private boolean validateRa(String ra) {
        if (ra == null || ra.isEmpty()) {
            return false;
        }
        if (ra.length() != 10) {
            return false;
        }
        if (!ra.matches("\\d{2}\\.\\d{5}-\\d")) {
            return false;
        }
        return true;
    }

    private boolean validateName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (name.length() < 3 || name.length() > 50) {
            return false;
        }
        return true;
    }

    private boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (!email.matches("\\w+@\\w+\\.\\w+")) {
            return false;
        }
        return true;
    }

    private boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.length() < 8 || password.length() > 21) {
            return false;
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,21}$")) {
            return false;
        }
        return true;
    }


}
