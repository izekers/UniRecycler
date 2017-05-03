package com.zoker.unirecycler;

import android.content.Intent;

/**
 *
 * Created by Zoker on 2017/4/13.
 */

public class IntentModel {
    private String name;
    private Intent intent;

    public IntentModel(String name, Intent intent) {
        this.name = name;
        this.intent = intent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
