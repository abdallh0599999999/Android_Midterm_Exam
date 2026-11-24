
package com.example.mid_exam_abedallah_qweader_1301214925;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mid_exam_abedallah_qweader_1301214925.databinding.FragmentPageBinding;

public class PageFragment extends Fragment {

    private FragmentPageBinding binding;

    private static final String ARG_TITLE = "title";

    public static PageFragment newInstance(String title) {
        PageFragment fragment = new PageFragment();

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentPageBinding.inflate(
                inflater, container, false);

        String title = getArguments().getString(ARG_TITLE);

        binding.pageTitle.setText(title);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
