package amrelmasry.com.core.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import amrelmasry.com.core.utils.general.ClassUtils;
import butterknife.ButterKnife;

/**
 * Created by Amr on 11/02/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    protected abstract void bind(T item);

    protected final Context getContext() {
        return itemView.getContext();
    }
}
