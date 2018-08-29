package belal.brur.com.model;

public class ParamAppUser {

    private  String AppId ="";
    private  String MenuId ="";

    public ParamAppUser(String appId, String menuId) {
        AppId = appId;
        MenuId = menuId;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    @Override
    public String toString() {
        return "ParamAppUser{" +
                "AppId='" + AppId + '\'' +
                ", MenuId='" + MenuId + '\'' +
                '}';
    }
}
