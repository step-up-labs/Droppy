package com.shehabic.droppy;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Helper class which allows to dismiss already opened Popup.
 *
 * @author Josef Hruška (josef@stepuplabs.io)
 */

public final class Droppy {

    /**
     * It may be necessary to dismiss view before ,the fragment/activity which created popup, is stopped.
     *
     * @param activity - activity which created popup
     */
    public static void dismissAllPopups(Activity activity) {
        dismiss(activity.getWindow());
    }

    /**
     * It may be necessary to dismiss view before ,the fragment/activity which created popup, is stopped.
     *
     * @param fragment - fragment which created popup
     */
    public static void dismissAllPopups(Fragment fragment) {
        dismissAllPopups(fragment.getActivity());
    }

    /**
     * When the popup is opened its holder and modal view are added as direct child of Window.
     * It is added as another contentView (addContentView()) next to the activity content.
     *
     * @param window - window which contains popup and activity content.
     */
    private static void dismiss(Window window) {
        View droppyHolder = window.getDecorView().findViewWithTag("DROPPY_POPUP_HOLDER");
        View droppyModal = window.getDecorView().findViewWithTag("DROPPY_POPUP_MODAL");

        if (droppyHolder != null) {
            ((ViewGroup) droppyHolder.getParent()).removeView(droppyHolder);
        }
        if (droppyModal != null) {
            ((ViewGroup) droppyModal.getParent()).removeView(droppyModal);
        }
    }
}
