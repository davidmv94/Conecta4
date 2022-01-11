package com.davidthar.conecta4

/*
* Coded by @DavidThar
* Challenge #1 (January)
* for Monthly-App-Challenge-2022 by MoureDev
 */

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.davidthar.conecta4.databinding.ActivityGameBinding
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

private lateinit var binding : ActivityGameBinding

private var turn = 1
private var redScore = 0
private var yellowScore = 0
private var starterColor = 1

private var MAX_X = 6
private var MAX_Y = 5
private var MIN_XY = 0

private lateinit var arrayArrows : Array<ImageView>
private lateinit var arrayBoard : Array<Array<Square>>

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setArrays()
        setButtons()
        setArrows()
    }

    private fun checkWin(x : Int, y : Int, color : Int){
        var countHorizontal = 1
        var countVertical = 1
        var countDiagonal1 = 1
        var countDiagonal2 = 1

        //Left
        if(x-1>=MIN_XY && arrayBoard[x-1][y].color == color){
            countHorizontal++
            if(x-2>=MIN_XY && arrayBoard[x-2][y].color == color){
                countHorizontal++
                if(x-3>=MIN_XY && arrayBoard[x-3][y].color == color) countHorizontal++
            }
        }

        //Right
        if(x+1<= MAX_X && arrayBoard[x+1][y].color == color){
            countHorizontal++
            if(x+2<= MAX_X && arrayBoard[x+2][y].color == color){
                countHorizontal++
                if(x+3<= MAX_X && arrayBoard[x+3][y].color == color) countHorizontal++
            }
        }

        //Top
        if(y-1>=MIN_XY && arrayBoard[x][y-1].color == color){
            countVertical++
            if(y-2>=MIN_XY && arrayBoard[x][y-2].color == color){
                countVertical++
                if(y-3>=MIN_XY && arrayBoard[x][y-3].color == color) countVertical++
            }
        }

        //Down
        if(y+1<=MAX_Y && arrayBoard[x][y+1].color == color){
            countVertical++
            if(y+2<=MAX_Y && arrayBoard[x][y+2].color == color){
                countVertical++
                if(y+3<=MAX_Y && arrayBoard[x][y+3].color == color) countVertical++
            }
        }

        //Left-Top
        if(x-1>=MIN_XY && y-1>= MIN_XY && arrayBoard[x-1][y-1].color == color){
            countDiagonal1++
            if(x-2>=MIN_XY && y-2>= MIN_XY && arrayBoard[x-2][y-2].color == color){
                countDiagonal1++
                if(x-3>=MIN_XY && y-3>= MIN_XY && arrayBoard[x-3][y-3].color == color) countDiagonal1++
            }
        }

        //Right-Top
        if(x+1<= MAX_X && y-1>= MIN_XY && arrayBoard[x+1][y-1].color == color){
            countDiagonal2++
            if(x+2<= MAX_X && y-2>= MIN_XY && arrayBoard[x+2][y-2].color == color){
                countDiagonal2++
                if(x+3<= MAX_X && y-3>= MIN_XY && arrayBoard[x+3][y-3].color == color) countDiagonal2++
            }
        }

        //Right-Down
        if(x+1<= MAX_X && y+1<= MAX_Y && arrayBoard[x+1][y+1].color == color){
            countDiagonal1++
            if(x+2<= MAX_X && y+2<= MAX_Y && arrayBoard[x+2][y+2].color == color){
                countDiagonal1++
                if(x+3<= MAX_X && y+3<= MAX_Y && arrayBoard[x+3][y+3].color == color) countDiagonal1++
            }
        }

        //Left-Down
        if(x-1>=MIN_XY && y+1<= MAX_Y && arrayBoard[x-1][y+1].color == color){
            countDiagonal2++
            if(x-2>=MIN_XY && y+2<= MAX_Y && arrayBoard[x-2][y+2].color == color){
                countDiagonal2++
                if(x-3>=MIN_XY && y+3<= MAX_Y && arrayBoard[x-3][y+3].color == color) countDiagonal2++
            }
        }


        if(countHorizontal>=4 || countVertical>=4 || countDiagonal1 >=4 || countDiagonal2 >= 4){
            setKonfetti(binding.viewKonfetti,color)
            arrayArrows.forEach { it.setOnClickListener{} }
            createWinDialog(color)
            when(color){
                1 -> redScore++
                2 -> yellowScore++
            }
            setScore()
        }
    }

    private fun setArrows() {
        arrayArrows[0].setOnClickListener {
            when {
                arrayBoard[0][5].color == 0 -> setPiece(0,5,turn)
                arrayBoard[0][4].color == 0 -> setPiece(0,4,turn)
                arrayBoard[0][3].color == 0 -> setPiece(0,3,turn)
                arrayBoard[0][2].color == 0 -> setPiece(0,2,turn)
                arrayBoard[0][1].color == 0 -> setPiece(0,1,turn)
                arrayBoard[0][0].color == 0 -> setPiece(0,0,turn)
            }
        }
        arrayArrows[1].setOnClickListener {
            when {
                arrayBoard[1][5].color == 0 -> setPiece(1,5,turn)
                arrayBoard[1][4].color == 0 -> setPiece(1,4,turn)
                arrayBoard[1][3].color == 0 -> setPiece(1,3,turn)
                arrayBoard[1][2].color == 0 -> setPiece(1,2,turn)
                arrayBoard[1][1].color == 0 -> setPiece(1,1,turn)
                arrayBoard[1][0].color == 0 -> setPiece(1,0,turn)
            }
            
        }
        arrayArrows[2].setOnClickListener {
            when {
                arrayBoard[2][5].color == 0 -> setPiece(2,5,turn)
                arrayBoard[2][4].color == 0 -> setPiece(2,4,turn)
                arrayBoard[2][3].color == 0 -> setPiece(2,3,turn)
                arrayBoard[2][2].color == 0 -> setPiece(2,2,turn)
                arrayBoard[2][1].color == 0 -> setPiece(2,1,turn)
                arrayBoard[2][0].color == 0 -> setPiece(2,0,turn)
            }
            
        }
        arrayArrows[3].setOnClickListener {
            when {
                arrayBoard[3][5].color == 0 -> setPiece(3,5,turn)
                arrayBoard[3][4].color == 0 -> setPiece(3,4,turn)
                arrayBoard[3][3].color == 0 -> setPiece(3,3,turn)
                arrayBoard[3][2].color == 0 -> setPiece(3,2,turn)
                arrayBoard[3][1].color == 0 -> setPiece(3,1,turn)
                arrayBoard[3][0].color == 0 -> setPiece(3,0,turn)
            }
            
        }
        arrayArrows[4].setOnClickListener {
            when {
                arrayBoard[4][5].color == 0 -> setPiece(4,5,turn)
                arrayBoard[4][4].color == 0 -> setPiece(4,4,turn)
                arrayBoard[4][3].color == 0 -> setPiece(4,3,turn)
                arrayBoard[4][2].color == 0 -> setPiece(4,2,turn)
                arrayBoard[4][1].color == 0 -> setPiece(4,1,turn)
                arrayBoard[4][0].color == 0 -> setPiece(4,0,turn)
            }
            
        }
        arrayArrows[5].setOnClickListener {
            when {
                arrayBoard[5][5].color == 0 -> setPiece(5,5,turn)
                arrayBoard[5][4].color == 0 -> setPiece(5,4,turn)
                arrayBoard[5][3].color == 0 -> setPiece(5,3,turn)
                arrayBoard[5][2].color == 0 -> setPiece(5,2,turn)
                arrayBoard[5][1].color == 0 -> setPiece(5,1,turn)
                arrayBoard[5][0].color == 0 -> setPiece(5,0,turn)
            }
            
        }
        arrayArrows[6].setOnClickListener {
            when {
                arrayBoard[6][5].color == 0 -> setPiece(6,5,turn)
                arrayBoard[6][4].color == 0 -> setPiece(6,4,turn)
                arrayBoard[6][3].color == 0 -> setPiece(6,3,turn)
                arrayBoard[6][2].color == 0 -> setPiece(6,2,turn)
                arrayBoard[6][1].color == 0 -> setPiece(6,1,turn)
                arrayBoard[6][0].color == 0 -> setPiece(6,0,turn)
            }
            
        }
    }

    private fun setPiece(x : Int, y : Int, color : Int){
        arrayBoard[x][y].color = color
        when(color){
            1 -> arrayBoard[x][y].image.setImageResource(R.drawable.ficha_roja)
            2 -> arrayBoard[x][y].image.setImageResource(R.drawable.ficha_amarilla)
        }
        checkWin(x,y,color)
        changeTurn()
    }

    private fun changeTurn(){
        turn = if (turn==1) 2 else 1
        when(turn){
            1 -> binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.red_piece)
            2 -> binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.yellow_piece)
        }
    }

    private fun setArrays() {

        arrayArrows = arrayOf(
            binding.arrow1,binding.arrow2,binding.arrow3,binding.arrow4,
            binding.arrow5,binding.arrow6,binding.arrow7)


        arrayBoard = arrayOf(
            arrayOf(Square(0,binding.box00),Square(0,binding.box10),Square(0,binding.box20),
                Square(0,binding.box30),Square(0,binding.box40),Square(0,binding.box50)),
            arrayOf(Square(0,binding.box01),Square(0,binding.box11),Square(0,binding.box21),
                Square(0,binding.box31),Square(0,binding.box41),Square(0,binding.box51)),
            arrayOf(Square(0,binding.box02),Square(0,binding.box12),Square(0,binding.box22),
                Square(0,binding.box32),Square(0,binding.box42),Square(0,binding.box52)),
            arrayOf(Square(0,binding.box03),Square(0,binding.box13),Square(0,binding.box23),
                Square(0,binding.box33),Square(0,binding.box43),Square(0,binding.box53)),
            arrayOf(Square(0,binding.box04),Square(0,binding.box14),Square(0,binding.box24),
                Square(0,binding.box34),Square(0,binding.box44),Square(0,binding.box54)),
            arrayOf(Square(0,binding.box05),Square(0,binding.box15),Square(0,binding.box25),
                Square(0,binding.box35),Square(0,binding.box45),Square(0,binding.box55)),
            arrayOf(Square(0,binding.box06),Square(0,binding.box16),Square(0,binding.box26),
                Square(0,binding.box36),Square(0,binding.box46),Square(0,binding.box56))
        )
    }

    private fun setButtons() {
        binding.btnResetCounter.setOnClickListener {
            redScore = 0
            yellowScore = 0
            setScore()
            resetGame()
        }

        binding.btnResetGame.setOnClickListener { resetGame() }
    }

    private fun resetGame(){
        starterColor = if (starterColor == 1) 2 else 1

        setArrays()
        setArrows()
        arrayBoard.forEach { array ->
            array.forEach {
                it.image.setImageResource(R.drawable.ficha_vacia)
            }
        }
        if(starterColor == 1){
            turn = 1
            binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.red_piece)
        }else{
            turn = 2
            binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.yellow_piece)
        }

    }

    private fun setScore() {
        binding.btnRedScore.text = redScore.toString()
        binding.btnYellowScore.text = yellowScore.toString()
    }

    private fun setKonfetti(konfettiView : KonfettiView, color : Int){
        val konfettiColor : Int = if (color==1) Color.RED else Color.YELLOW
        konfettiView.build()
            .addColors(konfettiColor)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(1000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(-50f, konfettiView.width + 50f, -50f, -50f)
            .streamFor(300, 2000L)
    }

    private fun createWinDialog(color : Int){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_win)
        dialog.setCancelable(false)

        val btnBack = dialog.findViewById(R.id.win_dialog_back) as Button
        val title =  dialog.findViewById<TextView>(R.id.win_dialog_title)
        val text = dialog.findViewById<TextView>(R.id.win_dialog_text)

        if(color==1){
            title.setTextColor(ContextCompat.getColor(this,R.color.red_piece))
            title.background = ContextCompat.getDrawable(this, R.drawable.dialog_red_title)
            text.text = getString(R.string.color_wins,"rojo")
            btnBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.red_piece)
        }else{
            title.setTextColor(ContextCompat.getColor(this,R.color.yellow_piece))
            title.background = ContextCompat.getDrawable(this, R.drawable.dialog_yellow_title)
            text.text = getString(R.string.color_wins,"amarillo")
            btnBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.yellow_piece)
        }

        title.setTextColor(ContextCompat.getColor(this,R.color.white))

        btnBack.setOnClickListener {
            dialog.dismiss()
            resetGame()
        }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }
}