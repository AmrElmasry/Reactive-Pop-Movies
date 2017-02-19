package amrelmasry.com.core.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import amrelmasry.com.core.adapter.BaseRecyclerViewAdapter;
import butterknife.ButterKnife;

/**
 * Created by Amr on 11/02/17.
 */

public abstract class BaseCoreRecyclerViewActivity extends BaseCoreActivity {


    private RecyclerView mRecyclerView;
    private BaseRecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerViewAdapter = setupAdapter();
        setupRecyclerView();
    }

    protected void setupRecyclerView() {
        mRecyclerView = initRecyclerView();
        mRecyclerView.setLayoutManager(setupRecyclerViewLayoutManager());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @NonNull
    protected RecyclerView initRecyclerView() {
        RecyclerView recyclerView = ButterKnife.findById(this, getRecyclerViewId());
        if (recyclerView == null) {
            throw new RecyclerViewNotFoundException("RecyclerView activity must " +
                    "have a recyclerView!");
        }
        return recyclerView;
    }

    @NonNull
    protected RecyclerView.LayoutManager setupRecyclerViewLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    @NonNull
    protected abstract BaseRecyclerViewAdapter setupAdapter();

    @IdRes
    protected abstract int getRecyclerViewId();

    @NonNull
    protected RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public BaseRecyclerViewAdapter getRecyclerViewAdapter() {
        return mRecyclerViewAdapter;
    }

    private static class RecyclerViewNotFoundException extends RuntimeException {
        RecyclerViewNotFoundException(String message) {
            super(message);
        }
    }
}
