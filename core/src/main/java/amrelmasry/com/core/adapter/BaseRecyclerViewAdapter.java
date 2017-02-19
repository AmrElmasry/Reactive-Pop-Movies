package amrelmasry.com.core.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import amrelmasry.com.core.adapter.viewholder.BaseViewHolder;
import amrelmasry.com.core.utils.general.ClassUtils;

/**
 * Created by Amr on 11/02/17.
 */

public abstract class BaseRecyclerViewAdapter<VH extends BaseViewHolder<T>, T>
        extends RecyclerView.Adapter<VH> {

    protected final String LOG_TAG = ClassUtils.generateClassTag(this);

    private List<T> items;

    public BaseRecyclerViewAdapter(List<T> items) {
        this.items = items;
    }

    public void add(int position, T item) {
        items.add(position, item);
        notifyItemChanged(position);
    }

    public void remove(int position) {
        items.remove(position);
        notifyItemChanged(position);
    }

    public void addAll(List<T> itemsList) {
        items.addAll(itemsList);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void replace(int position, T newItem) {
        items.remove(position);
        items.add(position, newItem);
        notifyItemChanged(position);
    }

    public T get(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected View inflateItemView(ViewGroup parent, @LayoutRes int itemLayout) {
        return LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
    }
}
