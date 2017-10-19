package nuttyzzz.xogamemvp.Board_Game;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import nuttyzzz.xogamemvp.R;

/**
 * Created by dhero on 10/19/2017.
 */

public class BoardPresenter implements BoardPresenterIF, BoardPresenterIF.CheckTheWinner {

    private BoardView boardView;
    private Context context;
    private String win, draw, player1, player2;
    private String message;
    private int player, countDraw;
    private Integer[] boardPlay;
    private Integer[][] winChk;

    public BoardPresenter(BoardView boardView, Context context) {
        this.boardView = boardView;
        this.context = context;
        setupGame();

    }

    @Override
    public void playTurn(View view) {
        ImageView mark = (ImageView) view;
        int markPosition = Integer.parseInt(mark.getTag().toString());
        if (mark.getDrawable() == null) {
            if (player == 1) {
                boardView.setImage(view, ResourcesCompat.getDrawable(view.getResources(), R.drawable.cross, null));
                boardPlay[markPosition] = 1;
                player = 2;
            } else if (player == 2) {
                boardView.setImage(view, ResourcesCompat.getDrawable(view.getResources(), R.drawable.circle, null));
                boardPlay[markPosition] = 2;
                player = 1;
            }
            if (onWinner() || onDraw(countDraw)) {
                boardView.showDialog(setupDialog(view));
            }
            countDraw++;
        }
    }

    @Override
    public Dialog setupDialog(View view) {
        Dialog dialog = new Dialog(view.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_winner);
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(R.id.dialogMessage)).setText(message);
        return dialog;
    }

    @Override
    public boolean onWinner() {
        for (Integer[] winchk : winChk) {
            if (boardPlay[winchk[0]] == 1 &&
                    boardPlay[winchk[1]] == 1 &&
                    boardPlay[winchk[2]] == 1) {
                message = player1 + " " + win;
                return true;
            } else if (boardPlay[winchk[0]] == 2 &&
                    boardPlay[winchk[1]] == 2 &&
                    boardPlay[winchk[2]] == 2) {
                message = player2 + " " + win;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onDraw(int countDraw) {
        if (countDraw == 8) {
            return true;
        }
        return false;
    }

    @Override
    public void setupGame() {
        win = context.getResources().getString(R.string.win);
        draw = context.getResources().getString(R.string.draw);
        player1 = context.getResources().getString(R.string.player1);
        player2 = context.getResources().getString(R.string.player2);
        message = draw;
        player = 1;
        countDraw = 0;
        boardPlay = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        winChk = new Integer[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        boardView.removeImage();
    }

    @Override
    public void onDestroy() {
        boardView = null;
    }
}
