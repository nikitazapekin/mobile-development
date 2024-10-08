/*
package com.example.navig;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int imageResId;
    private String name;
    private double price;

    public Product(int imageResId, String name, double price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    protected Product(Parcel in) {
        imageResId = in.readInt();
        name = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResId);
        dest.writeString(name);
        dest.writeDouble(price);
    }
}
*/


 package com.example.navig;

public class Product {
    private int imageResId;
    private String name;
    private double price;
    public Product(int imageResId, String name, double price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

