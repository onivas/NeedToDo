package com.example.savino.needtodo.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class Listing {

    @SerializedName("title")
    String mTitle;

    @SerializedName("subtitle")
    String mSubTitle;

    @SerializedName("elements")
    ListingItem[] mItems;

    @ParcelConstructor
    public Listing(String title, String subTitle, ListingItem[] items) {
        mTitle = title;
        mSubTitle = subTitle;
        mItems = items;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public ListingItem[] getItems() {
        return mItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Listing)) return false;

        Listing listing = (Listing) o;

        if (mTitle != null ? !mTitle.equals(listing.mTitle) : listing.mTitle != null) return false;
        if (mSubTitle != null ? !mSubTitle.equals(listing.mSubTitle) : listing.mSubTitle != null)
            return false;
        return mItems != null ? mItems.equals(listing.mItems) : listing.mItems == null;

    }

    @Override
    public int hashCode() {
        int result = mTitle != null ? mTitle.hashCode() : 0;
        result = 31 * result + (mSubTitle != null ? mSubTitle.hashCode() : 0);
        result = 31 * result + (mItems != null ? mItems.hashCode() : 0);
        return result;
    }
}
