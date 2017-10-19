package nuttyzzz.xogamemvp.Board_Game;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * Created by dhero on 10/19/2017.
 */

public interface BoardPresenterIF {

    interface CheckTheWinner{
        boolean onWinner();
        boolean onDraw(int countDraw);
    }

    void playTurn(View view);

    Dialog setupDialog(View view);

    void setupGame();

    void onDestroy();
}
