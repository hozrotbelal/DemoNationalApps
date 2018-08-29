package belal.brur.com.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


import java.security.InvalidParameterException;

import belal.brur.com.model.Contentfilelist;
import belal.brur.com.viewholder.ContentFileViewHolder;

public class ContentFileListAdapter extends RecyclerArrayAdapter<Contentfilelist> {

    private static final int VIEW_TYPE_REGULAR = 1;

    public ContentFileListAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        return VIEW_TYPE_REGULAR;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_REGULAR:
                return new ContentFileViewHolder(parent);
            default:
                throw new InvalidParameterException();
        }
    }
}