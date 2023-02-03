package app.takahashi.kamesan.sound

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import app.takahashi.kamesan.sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{ setContentView(this.root) }

        //　ドラムのサウンドファイルを読み込んで、プレイヤーを作る
        val drumSound: MediaPlayer = MediaPlayer.create(this, R.raw.drum_sound)

        /*binding.drumImage.setOnTouchListener{ view, motionEvent->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){
                binding.drumImage.setImageResource(R.drawable.drum_playing_image)
                drumSound.seekTo(0)
                drumSound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP){
                binding.drumImage.setImageResource(R.drawable.drum_image)
            }
            true
        }*/

        binding.drumImage.setOnClickListener{
            drumSound.seekTo(0)
            drumSound.start()
        }

        // ピアノのサウンドファイルを読み込んで、プレイヤーを作る
        val pianosound: MediaPlayer = MediaPlayer.create( this, R.raw.piano_sound )

        // ピアノがタッチされた時に呼ばれる
        binding.pianoImage.setOnTouchListener{ view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_DOWN){
                binding.pianoImage.setImageResource(R.drawable.piano_playing_image)
                pianosound.seekTo(0)
                pianosound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP){
                binding.pianoImage.setImageResource(R.drawable.piano_image)
            }
            true
        }

        // ピアノのサウンドファイルを読み込んで、プレイヤーを作る
        val guitarsound: MediaPlayer = MediaPlayer.create( this, R.raw.guitar_sound )

        // ピアノがタッチされた時に呼ばれる
        binding.guitarImage.setOnTouchListener{ view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_DOWN){
                binding.guitarImage.setImageResource(R.drawable.guitar_playing_image)
                guitarsound.seekTo(0)
                guitarsound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP){
                binding.guitarImage.setImageResource(R.drawable.guitar_image)
            }
            true
        }
    }
}