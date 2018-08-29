package belal.brur.com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contentfilelist {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("IMG")
    @Expose
    private String iMG;
    @SerializedName("IMGW")
    @Expose
    private String iMGW;
    @SerializedName("AUDIO")
    @Expose
    private String aUDIO;
    @SerializedName("VIDEO")
    @Expose
    private String vIDEO;
    @SerializedName("FILE")
    @Expose
    private String fILE;
    @SerializedName("YT")
    @Expose
    private String yT;
    @SerializedName("Entry")
    @Expose
    private String entry;
    @SerializedName("LastUpdated")
    @Expose
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getiMG() {
        return iMG;
    }

    public void setiMG(String iMG) {
        this.iMG = iMG;
    }

    public String getiMGW() {
        return iMGW;
    }

    public void setiMGW(String iMGW) {
        this.iMGW = iMGW;
    }

    public String getaUDIO() {
        return aUDIO;
    }

    public void setaUDIO(String aUDIO) {
        this.aUDIO = aUDIO;
    }

    public String getvIDEO() {
        return vIDEO;
    }

    public void setvIDEO(String vIDEO) {
        this.vIDEO = vIDEO;
    }

    public String getfILE() {
        return fILE;
    }

    public void setfILE(String fILE) {
        this.fILE = fILE;
    }

    public String getyT() {
        return yT;
    }

    public void setyT(String yT) {
        this.yT = yT;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Contentfilelist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", iMG='" + iMG + '\'' +
                ", iMGW='" + iMGW + '\'' +
                ", aUDIO='" + aUDIO + '\'' +
                ", vIDEO='" + vIDEO + '\'' +
                ", fILE='" + fILE + '\'' +
                ", yT='" + yT + '\'' +
                ", entry='" + entry + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
