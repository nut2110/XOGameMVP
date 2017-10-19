package nuttyzzz.xogamemvp.Board_Game;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by dhero on 10/19/2017.
 */

public interface BoardView {
    void setImage(View view, Drawable drawable);

    void removeImage();

    void showDialog(Dialog dialog);

    void onClickReset(View view);

    void setAnimationPicker(View view);

    void setAnimationPlayer(int player);

}
