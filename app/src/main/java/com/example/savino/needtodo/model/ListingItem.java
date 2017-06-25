package com.example.savino.needtodo.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class ListingItem {

    @SerializedName("key")
    int mKey;

    @SerializedName("value")
    String mValue;

    @SerializedName("weight")
    int mWeight;

    @ParcelConstructor
    public ListingItem(int key, String value, int weight) {
        mKey = key;
        mValue = value;
        mWeight = weight;
    }

    public int getKey() {

        return mKey;
    }

    public String getValue() {
        return mValue;
    }

    public int getWeight() {
        return mWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListingItem)) return false;

        ListingItem that = (ListingItem) o;

        if (mKey != that.mKey) return false;
        if (mWeight != that.mWeight) return false;
        return mValue != null ? mValue.equals(that.mValue) : that.mValue == null;

    }

    @Override
    public int hashCode() {
        int result = mKey;
        result = 31 * result + (mValue != null ? mValue.hashCode() : 0);
        result = 31 * result + mWeight;
        return result;
    }
}
