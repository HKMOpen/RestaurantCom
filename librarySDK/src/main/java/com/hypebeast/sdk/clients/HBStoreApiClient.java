package com.hypebeast.sdk.clients;

import android.os.Build;

import com.google.gson.GsonBuilder;
import com.hypebeast.sdk.Constants;
import com.hypebeast.sdk.api.gson.RealmExclusion;
import com.hypebeast.sdk.api.resources.hbstore.Brand;
import com.hypebeast.sdk.api.resources.hbstore.Products;
import com.hypebeast.sdk.api.resources.hbstore.SingleProduct;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by hesk on 30/6/15.
 */
public class HBStoreApiClient extends Client {

    /**
     * Base URL for all Disqus endpoints
     */
    private static final String BASE_URL_STORE = "https://store.hypebeast.com/";
    private static final String BASE_LOGIN = "https://disqus.com/api";
    /**
     * User agent
     */
    private static final String USER_AGENT = "HypebeastStoreApp/1.0 Android" + Build.VERSION.SDK_INT;

    /**
     * login adapter
     */
    private RestAdapter mLoginAdapter;


    public HBStoreApiClient() {
        super();
    }


    @Override
    protected void registerAdapter() {
        mAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL_STORE)
                .setLogLevel(RestAdapter.LogLevel.HEADERS)
                .setErrorHandler(handlerError)
                .setRequestInterceptor(getIn())
                .setConverter(new GsonConverter(gsonsetup))
                .build();
    }

    @Override
    protected String get_USER_AGENT() {
        return USER_AGENT;
    }

    @Override
    protected void jsonCreate() {
        gsonsetup = new GsonBuilder()
                .setDateFormat(Constants.DATE_FORMAT)
   /*             .registerTypeAdapter(Usage.class, new ApplicationsUsageDeserializer())
                .registerTypeAdapterFactory(new BlacklistsEntryTypeAdapterFactory())
                .registerTypeAdapterFactory(new PostTypeAdapterFactory())
                .registerTypeAdapterFactory(new ThreadTypeAdapterFactory())*/
                .setExclusionStrategies(new RealmExclusion())
                .create();
    }

    private RestAdapter fullEndpoint(final String endpoint) {
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.HEADERS)
                .setErrorHandler(handlerError)
                .setRequestInterceptor(getIn())
                .setConverter(new GsonConverter(gsonsetup))
                .build();
    }

    public Products createProducts() {
        return mAdapter.create(Products.class);
    }


    public Brand createBrand() {
        return mAdapter.create(Brand.class);
    }

    public SingleProduct createRequest(String url_full_product) {
        return fullEndpoint(url_full_product).create(SingleProduct.class);
    }
}
