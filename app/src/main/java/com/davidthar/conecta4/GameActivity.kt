package com.davidthar.conecta4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.davidthar.conecta4.databinding.ActivityGameBinding

private lateinit var binding : ActivityGameBinding

private var turn = 1
private var redScore = 0
private var yellowScore = 0
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

    private fun changeTurn(){
        turn = if (turn==1) 2 else 1
        when(turn){
            1 -> binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.red_piece)
            2 -> binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.yellow_piece)
        }
    }

    private fun setArrows() {
        arrayArrows[0].setOnClickListener {
            when {
                arrayBoard[0][5].color == 0 -> setPiece(arrayBoard[0][5],turn)
                arrayBoard[0][4].color == 0 -> setPiece(arrayBoard[0][4],turn)
                arrayBoard[0][3].color == 0 -> setPiece(arrayBoard[0][3],turn)
                arrayBoard[0][2].color == 0 -> setPiece(arrayBoard[0][2],turn)
                arrayBoard[0][1].color == 0 -> setPiece(arrayBoard[0][1],turn)
                arrayBoard[0][0].color == 0 -> setPiece(arrayBoard[0][0],turn)
            }
        }
        arrayArrows[1].setOnClickListener {
            when {
                arrayBoard[1][5].color == 0 -> setPiece(arrayBoard[1][5],turn)
                arrayBoard[1][4].color == 0 -> setPiece(arrayBoard[1][4],turn)
                arrayBoard[1][3].color == 0 -> setPiece(arrayBoard[1][3],turn)
                arrayBoard[1][2].color == 0 -> setPiece(arrayBoard[1][2],turn)
                arrayBoard[1][1].color == 0 -> setPiece(arrayBoard[1][1],turn)
                arrayBoard[1][0].color == 0 -> setPiece(arrayBoard[1][0],turn)
            }
            
        }
        arrayArrows[2].setOnClickListener {
            when {
                arrayBoard[2][5].color == 0 -> setPiece(arrayBoard[2][5],turn)
                arrayBoard[2][4].color == 0 -> setPiece(arrayBoard[2][4],turn)
                arrayBoard[2][3].color == 0 -> setPiece(arrayBoard[2][3],turn)
                arrayBoard[2][2].color == 0 -> setPiece(arrayBoard[2][2],turn)
                arrayBoard[2][1].color == 0 -> setPiece(arrayBoard[2][1],turn)
                arrayBoard[2][0].color == 0 -> setPiece(arrayBoard[2][0],turn)
            }
            
        }
        arrayArrows[3].setOnClickListener {
            when {
                arrayBoard[3][5].color == 0 -> setPiece(arrayBoard[3][5],turn)
                arrayBoard[3][4].color == 0 -> setPiece(arrayBoard[3][4],turn)
                arrayBoard[3][3].color == 0 -> setPiece(arrayBoard[3][3],turn)
                arrayBoard[3][2].color == 0 -> setPiece(arrayBoard[3][2],turn)
                arrayBoard[3][1].color == 0 -> setPiece(arrayBoard[3][1],turn)
                arrayBoard[3][0].color == 0 -> setPiece(arrayBoard[3][0],turn)
            }
            
        }
        arrayArrows[4].setOnClickListener {
            when {
                arrayBoard[4][5].color == 0 -> setPiece(arrayBoard[4][5],turn)
                arrayBoard[4][4].color == 0 -> setPiece(arrayBoard[4][4],turn)
                arrayBoard[4][3].color == 0 -> setPiece(arrayBoard[4][3],turn)
                arrayBoard[4][2].color == 0 -> setPiece(arrayBoard[4][2],turn)
                arrayBoard[4][1].color == 0 -> setPiece(arrayBoard[4][1],turn)
                arrayBoard[4][0].color == 0 -> setPiece(arrayBoard[4][0],turn)
            }
            
        }
        arrayArrows[5].setOnClickListener {
            when {
                arrayBoard[5][5].color == 0 -> setPiece(arrayBoard[5][5],turn)
                arrayBoard[5][4].color == 0 -> setPiece(arrayBoard[5][4],turn)
                arrayBoard[5][3].color == 0 -> setPiece(arrayBoard[5][3],turn)
                arrayBoard[5][2].color == 0 -> setPiece(arrayBoard[5][2],turn)
                arrayBoard[5][1].color == 0 -> setPiece(arrayBoard[5][1],turn)
                arrayBoard[5][0].color == 0 -> setPiece(arrayBoard[5][0],turn)
            }
            
        }
        arrayArrows[6].setOnClickListener {
            when {
                arrayBoard[6][5].color == 0 -> setPiece(arrayBoard[6][5],turn)
                arrayBoard[6][4].color == 0 -> setPiece(arrayBoard[6][4],turn)
                arrayBoard[6][3].color == 0 -> setPiece(arrayBoard[6][3],turn)
                arrayBoard[6][2].color == 0 -> setPiece(arrayBoard[6][2],turn)
                arrayBoard[6][1].color == 0 -> setPiece(arrayBoard[6][1],turn)
                arrayBoard[6][0].color == 0 -> setPiece(arrayBoard[6][0],turn)
            }
            
        }


    }

    private fun setPiece(square : Square, color : Int){
        square.color = color
        when(color){
            1 -> square.image.setImageResource(R.drawable.ficha_roja)
            2 -> square.image.setImageResource(R.drawable.ficha_amarilla)
        }
        changeTurn()
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
        }

        binding.btnResetGame.setOnClickListener {
            setArrays()
            arrayBoard.forEach { array ->
                array.forEach {
                    it.image.setImageResource(R.drawable.ficha_vacia)
                }
            }
            turn = 1
            binding.btnTurn.backgroundTintList = ContextCompat.getColorStateList(this,R.color.red_piece)
        }
    }

    private fun setScore() {
        binding.btnRedScore.text = redScore.toString()
        binding.btnYellowScore.text = yellowScore.toString()
    }
}