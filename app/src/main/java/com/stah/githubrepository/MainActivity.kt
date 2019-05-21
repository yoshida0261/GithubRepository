package com.stah.githubrepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stah.api.MixiApiClient
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val api = MixiApiClient.apiClient.getRepository("mixi-inc")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                Log.d("TAG", "rx response=$it")
              //  binding.textViewResponse.text = Gson().toJson(it)
            }
            .doOnError {
            }
            .doOnCompleted {
            }
            .subscribe()
    }
}
