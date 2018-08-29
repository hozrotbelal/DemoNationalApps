package belal.brur.com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetContentFileListResp {
    @SerializedName("contentfilelist")
    @Expose
    private List<Contentfilelist> contentfilelist = null;

    public List<Contentfilelist> getContentfilelist() {
        return contentfilelist;
    }

    public void setContentfilelist(List<Contentfilelist> contentfilelist) {
        this.contentfilelist = contentfilelist;
    }

    @Override
    public String toString() {
        return "GetContentFileListResp{" +
                "contentfilelist=" + contentfilelist +
                '}';
    }
}
