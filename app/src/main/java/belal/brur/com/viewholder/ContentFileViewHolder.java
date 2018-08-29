package belal.brur.com.viewholder;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;


import belal.brur.com.R;
import belal.brur.com.activity.ActivityFullScreenImage;
import belal.brur.com.model.Contentfilelist;
import belal.brur.com.utils.Tools;

import static belal.brur.com.utils.CommonContents.COMMON_IMAGE_PATH;


/**
 * @author Md. Hozrot Belal
 *         Email: belal.cse.brur@gmail.com
 */
public class ContentFileViewHolder extends BaseViewHolder<Contentfilelist> {

    TextView tvName;
    LinearLayout linMain;
    ImageView ivItem;

    public ContentFileViewHolder(ViewGroup parent) {
        super(parent, R.layout.row_file_item);

        tvName = (TextView) $(R.id.row_txt_name);
        linMain = (LinearLayout) $(R.id.lin_main);
        ivItem = (ImageView) $(R.id.img_item);
    }

    @Override
    public void setData(final Contentfilelist data) {

        tvName.setText(data.getTitle());
       // Tools.displayImageOriginal(getContext(),   ivItem,data.getiMG() );
        Tools.loadImage(getContext(), ivItem, data.getiMG(), false, true);

        ivItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intentSearch = new Intent(getContext(), ActivityFullScreenImage.class);
                intentSearch.putExtra(COMMON_IMAGE_PATH, data.getiMG());
                getContext().startActivity(intentSearch);


            }
        });
    }
}
