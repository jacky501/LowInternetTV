package org.atctech.lowinternettv.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.atctech.lowinternettv.R;
import org.atctech.lowinternettv.adapter.ViewPagerCustomAdapter;
import org.atctech.lowinternettv.model.CategoryDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePage_One extends Fragment {

    int selectedTabIndex = 0;
    String selectedTabText = "";

    TabLayout product_tabs;
    ViewPager product_viewpager;

    ViewPagerCustomAdapter viewPagerCustomAdapter;

    List<CategoryDetails> allCategoriesList = new ArrayList<>();
    List<CategoryDetails> allSubCategoriesList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get CategoriesList from AppContext
        allCategoriesList.add(new CategoryDetails("1",null,null,"Pant","1","1","15"));
        allCategoriesList.add(new CategoryDetails("2",null,null,"shirt","2","1","15"));
        allCategoriesList.add(new CategoryDetails("3",null,null,"t-shirt","3","1","15"));
        allCategoriesList.add(new CategoryDetails("4",null,null,"underware","4","1","15"));
        allCategoriesList.add(new CategoryDetails("5",null,null,"jangia","5","1","15"));

        allSubCategoriesList = new ArrayList<>();

        // Get SubCategoriesList from AllCategoriesList
        for (int i=0;  i<allCategoriesList.size();  i++) {
            if (!allCategoriesList.get(i).getParentId().equalsIgnoreCase("0")) {
                allSubCategoriesList.add(allCategoriesList.get(i));
            }
        }

    }


    public HomePage_One() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page__one, container, false);


        product_tabs = (TabLayout) view.findViewById(R.id.product_tabs);
        product_viewpager = (ViewPager) view.findViewById(R.id.product_viewpager);


        // Setup ViewPagerAdapter
        setupViewPagerAdapter();


        product_viewpager.setOffscreenPageLimit(0);
        product_viewpager.setAdapter(viewPagerCustomAdapter);

        // Add corresponding ViewPagers to TabLayouts
        product_tabs.setupWithViewPager(product_viewpager);


        try {
            product_tabs.getTabAt(selectedTabIndex).select();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void setupViewPagerAdapter() {

        // Initialize ViewPagerAdapter with ChildFragmentManager for ViewPager
        viewPagerCustomAdapter = new ViewPagerCustomAdapter(getChildFragmentManager());

        for (int i=0;  i < allSubCategoriesList.size();  i++) {

            ChannelListFragment channelListFragment = new ChannelListFragment();

            // Initialize Category_Products Fragment with specified arguments
            // Add the Fragments to the ViewPagerAdapter with TabHeader
            viewPagerCustomAdapter.addFragment(channelListFragment, allSubCategoriesList.get(i).getName());

            if (selectedTabText.equalsIgnoreCase(allSubCategoriesList.get(i).getName())) {
                selectedTabIndex = i + 1;
            }
        }

    }

}
