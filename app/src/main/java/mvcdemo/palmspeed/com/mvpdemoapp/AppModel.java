package mvcdemo.palmspeed.com.mvpdemoapp;

public class AppModel {

    private UserStatus userStatus;

    public AppModel(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }


}
