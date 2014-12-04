package com.sismics.docs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sismics.docs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Languages adapter.
 *
 * @author bgamard.
 */
public class LanguageAdapter extends BaseAdapter {
    /**
     * Context.
     */
    private Context context;

    private List<Language> languageList;

    public LanguageAdapter(Context context) {
        this.context = context;
        this.languageList = new ArrayList<>();
        languageList.add(new Language("fra", R.string.language_french, R.drawable.fra));
        languageList.add(new Language("eng", R.string.language_english, R.drawable.eng));
        languageList.add(new Language("jpn", R.string.language_japanese, R.drawable.jpn));
    }

    @Override
    public int getCount() {
        return languageList.size();
    }

    @Override
    public Language getItem(int position) {
        if (position >= languageList.size()) {
            return null;
        }
        return languageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id.hashCode();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.language_list_item, parent, false);
        }

        // Fill the view
        Language language = getItem(position);
        TextView languageTextView = (TextView) view.findViewById(R.id.languageTextView);
        languageTextView.setText(context.getText(language.name));
        languageTextView.setCompoundDrawablesWithIntrinsicBounds(language.drawable, 0, 0, 0);

        return view;
    }

    /**
     * A language.
     */
    private static class Language {
        private String id;
        private int name;
        private int drawable;

        /**
         * A language.
         *
         * @param id Language ID
         * @param name Language name
         * @param drawable Language drawable
         */
        public Language(String id, int name, int drawable) {
            this.id = id;
            this.name = name;
            this.drawable = drawable;
        }
    }
}