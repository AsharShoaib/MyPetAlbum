package mypetalbum.cbc.android.ca.mypetalbum;

import android.content.Context;
import android.content.Intent;

public class PetImageIntent extends Intent {

    public static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";

    public static final String ARG_TRANSITION_IMAGE = "ARG_TRANSITION_IMAGE";

    public PetImageIntent(Intent o) {
        super(o);
    }

    public PetImageIntent(Context packageContext, int imageId, String transitionName) {
        super(packageContext, PetDetailActivity.class);
        putExtra(ARG_IMAGE_ID, imageId);

        putExtra(ARG_TRANSITION_IMAGE, transitionName);
    }

    public int getImageId() {
        return getIntExtra(ARG_IMAGE_ID, -1);
    }


    public String getTransitionName() {
        return getStringExtra(ARG_TRANSITION_IMAGE);
    }
}
