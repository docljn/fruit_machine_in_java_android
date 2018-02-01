package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by lornanoble on 01/02/2018.
 */

public class HighlightOnTouchListener implements View.OnTouchListener {

    final ImageButton imageButton;

    public HighlightOnTouchListener(final ImageButton imageButton) {
        super();
        this.imageButton = imageButton;
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            //grey color filter, you can change the color as you like
            imageButton.setColorFilter(Color.argb(155, 185, 185, 185));
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            imageButton.setColorFilter(Color.argb(0, 185, 185, 185));
        }
        return false;
    }

}
