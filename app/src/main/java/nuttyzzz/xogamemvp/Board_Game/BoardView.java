package nuttyzzz.xogamemvp.Board_Game;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by dhero on 10/19/2017.
 */

public interface BoardView {
    void setImage(View view, Drawable drawable);

    void removeImage();

    void showDialog(Dialog dialog);

    void onClickReset(View view);

}
