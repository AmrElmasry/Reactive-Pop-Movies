package amrelmasry.com.reactive_pop_movies.features.grid;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import amrelmasry.com.core.rxbus.SelectionBus;
import amrelmasry.com.reactive_pop_movies.R;
import amrelmasry.com.reactive_pop_movies.common.constantgroups.FilteringTypes;
import amrelmasry.com.reactive_pop_movies.common.utils.Constants;
import amrelmasry.com.reactive_pop_movies.features.grid.rxbus.msgs.FilterSelectionEvent;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesFilteringDialogFragment extends DialogFragment {

    @BindView(R.id.filtering_options_radio_group)
    RadioGroup mRadioGroup;
    @BindView(R.id.highest_rated_option)
    AppCompatRadioButton mHighestRatedRadioButton;
    @BindView(R.id.most_popular_option)
    AppCompatRadioButton mMostPopularRadioButton;

    public static MoviesFilteringDialogFragment newInstance(@FilteringTypes int previouslyFilter) {
        Bundle args = new Bundle();
        args.putInt(Constants.Arguments.PREV_FILTER, previouslyFilter);
        MoviesFilteringDialogFragment fragment = new MoviesFilteringDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies_filterting_dialog, container, false);
        ButterKnife.bind(this, view);
        setPrevSelectedItem();
        setCheckedChangeListener();
        return view;
    }

    private void setPrevSelectedItem() {
        int prevFilter = getArguments().getInt(Constants.Arguments.PREV_FILTER);
        switch (prevFilter) {
            case FilteringTypes.MOST_POPULAR_FILTER:
                mMostPopularRadioButton.setChecked(true);
                break;
            case FilteringTypes.HIGHEST_RATED_FILTER:
                mHighestRatedRadioButton.setChecked(true);
                break;
        }
    }

    private void setCheckedChangeListener() {
        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.most_popular_option) {
                SelectionBus.send(new FilterSelectionEvent(FilteringTypes.MOST_POPULAR_FILTER));
            } else if (checkedId == R.id.highest_rated_option) {
                SelectionBus.send(new FilterSelectionEvent(FilteringTypes.HIGHEST_RATED_FILTER));
            }
            dismiss();
        });
    }

}
