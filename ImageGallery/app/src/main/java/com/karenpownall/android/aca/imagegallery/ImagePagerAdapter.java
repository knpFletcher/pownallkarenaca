package com.karenpownall.android.aca.imagegallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImagePagerAdapter extends PagerAdapter {

    Context context;

    int[] images;
    LayoutInflater inflater;

    public ImagePagerAdapter(Context context, int[] images){
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        ImageView image;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.pager_item, container, false);

        //get reference to imageView in pager_item layout
        image = (ImageView) itemView.findViewById(R.id.imageView);

        //set an image to the imageView
        image.setImageResource(images[position]);

        //add pager_item layout as the current page to the ViewPager
        ((ViewPager)container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //remove pager_item layout from ViewPager
        ((ViewPager)container).removeView((LinearLayout)object);
    }
}
