package OnlineExamination;

public class User {
	String username;
    String password;
    String profileInfo;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profileInfo = "Default Profile Info";
    }

    public void updateProfile(String newInfo) {
        this.profileInfo = newInfo;
        System.out.println("Profile updated successfully.");
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password updated successfully.");
    }
}